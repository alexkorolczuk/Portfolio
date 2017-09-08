//
//  UserInput.c
//  WritingSkills
//
//  Created by Aleksandra Korolczuk on 2017-09-05.
//  Copyright © 2017 Aleksandra Korolczuk. All rights reserved.
//
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
#include <ctype.h>
#include "UserInput.h"
#include "Result.h"
#include "Instructions.h"

#define true 1
#define false 0

char input[100] = "";
int option_number = 0;



int examOptions(){
    
    int exam = 0;
    
    printf("---------------------MENU--------------------------\n");

    printf("What exam are you taking?\n");
    printf("Type numbers only.\n");
    printf("1  - CELPIP\n");
    printf("2  - IELTS\n");
    printf("9  - QUIT\n");
    
    option_number = checkInput();
    
    while(option_number == false){
      checkInput();
    }
    
    if (option_number == 1) {
        printf("Your choice is Celpip.\n");
        exam = 1;
    } else if (option_number == 2) {
        printf("Please choose if you are writing task 1 for 150 words (press 1) or task 2 for 250 words(press 2).\n");
        int task = checkInput();
        if (task == 1){
            printf("Your choice is IELTS, task 1 for 150 words.\n");
            exam = 2;
        }else if(task == 2) {
            printf("Your choice is IELTS, task 2 for 250 words.\n");
            exam = 3;
        }
    }
    return exam;
    
}

int startWriting(int option){
    
    printf("---------------------MENU--------------------------\n");
    printf("1  - START WRITING\n");
    printf("2  - GO BACK TO EXAM OPTIONS\n");
    printf("#  - SUBMIT THE TASK\n");
    printf("9  - QUIT\n");
    
    option_number = checkInput();
    
    while(option_number == false){
        checkInput();
    }
    
    if (option_number == 1) {
        time_t start = time(NULL);
        analizeText(start, option);
    } else if (option_number == 2){
        return false;
    }
    return false;


}


 int checkInput() {
     int length,i;
    
    scanf ("%s", input);
    length =(int) strlen (input);
    for (i=0;i<length; i++){
        if (!isdigit(input[i])){
            printf("(Numbers 1,2 or 9 only.)\n");
            return false;
        } else if(input[i] != '1' && input[i] != '2' && input[i] != '9') {
            printf("Please type 1,2 or 9.\n");
            return false;
        } else if (input[i] == '9'){
            printf("THANK YOU AND GOOD LUCK!!!\n");
            exit(0);
        } else if (input[i] == '1')
            option_number = 1;
        else if (input[i] == '2')
            option_number = 2;
    }
    return option_number;
 

}

