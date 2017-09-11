//
//  Instructions.c
//  WritingSkills
//
//  Created by Aleksandra Korolczuk on 2017-09-05.
//  Copyright © 2017 Aleksandra Korolczuk. All rights reserved.
//

#include "Instructions.h"
#include "UserInput.h"


void printHeadline(){
    printf("===================================================\n");
    printf("===WELCOME TO WRITING SKILLS TRAINING PROGRAM!!!===\n");
    printf("===================================================\n");
    printf("Improve your writing score on the English exam.\n");
    printf("\n");

}


void showInstructions(int option) {
    int words_limit;
    printf("\n");
    printf("---------------------INSTRUCTIONS-------------------\n");
    printf("\n");
    if (option == 1){
        printf("---------------------CELPIP-------------------------\n");
        words_limit = 150;
    }else if (option == 2){
        printf("-------------------IELTS TASK 1---------------------\n");
        words_limit = 150;
    }else{
        printf("-------------------IELTS TASK 2---------------------\n");
        words_limit = 250;
    }

    
        printf("Writing section during a real exam has 2 scored tasks.\nIt should take 53 min to accoplish bot of them.\nNow you goning to write just one of them. \nYou've got 25 minutes to submit the file.\n");
        printf("\n");
        printf("WORDS: Your limit is %d words.\n", words_limit);
        printf("SPECIAL EXPRESSIONS: We are going to count how many special expressions you used from: firstly, secondly, thirdly, moreover, however, nevertheless, therefore, nontheless, importantly.\n");
        printf("TIME: Our program will mesure the time for you from\nthe moment you are ready to write, until you submit\nyour task.\n");
        printf("SUBMIT THE FILE: Type # when you finished.\n");
    
    }

