//
//  Result.c
//  WritingSkills
//
//  Created by Aleksandra Korolczuk on 2017-09-05.
//  Copyright © 2017 Aleksandra Korolczuk. All rights reserved.
//

#include <time.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

#include "Result.h"
#include "UserInput.h"

#define true 1
#define false 0

void analizeText(time_t start, int option){
    
    
    //--------------------get the input----------------------------:
    
    printf("----------------START WRITING NOW------------------\n");
    int words = 0, sentences = 0, paragraph = 0, i;
    char task[10000];
    scanf("%[^'#']",task);
    time_t end;
    char *expressions[13] = {"Firstly", "Secondly", "Thirdly", "However", "however", "Moreover", "moreover", "Nevertheless", "therefore", "Therefore", "Nonetheless", "Importantly", "importantly"};
    int special_exp = 0;
    
    //--------------------time----------------------------------:
    time(&end);
    int seconds = difftime(end, start);

    
    //--------------------count word, sentences--------------------:
  
    for (i = 0; task[i] != '\0';i++){
        if(task[i] == ' ' || task[i] == '\t')
            words ++;
        if (task[i] == '\n') {
            words++;
            paragraph++;
        }
        if( task[i] == '.' || task[i] == '!'  || task[i] == '?')
            sentences++;
        
    }
    
    
    if (strstr(task, "...") != NULL) {
        sentences = sentences - 2;
    }
    if (strstr(task, " \n") != NULL) {
        words= words-1;
    }
    if (strstr(task, "  ") != NULL)
        words= words-1;
    
    
    //--------------------count special expressions:--------------------:
    for(i=0;i<=13;i++){
        if (strstr(task, (expressions[i]) ) != NULL)
            special_exp++;
   }
    output(words-1, sentences, paragraph, special_exp, seconds, option);
}



void output(int number_words, int sentences, int paragraph, int special_exp, int seconds, int option) {
    
    char * words;
    if (option == 1 || option == 2){
        if (number_words > 150)
            words = "You exceeded the limit of words.\nBe careful next time.";
        else if (number_words < 120)
            words = "Your task has less than 120 words.\nTry to be closer to the limit of 150 words";
        else
            words = "Good job!";
    } else {
        if (number_words > 250)
            words = "You crossed the limit of 250 words. Be careful next time";
        else if (number_words < 220)
            words = "Your task has less than 220 words.\nTry to be closer to the limit of 250 words.";
        else
            words = "Good job!";
    }

    printf("\n");
    printf("---------------------RESULTS-----------------------\n");
    printf("\n");
    printf("NUMBER OF WORDS: %d. %s.\n", number_words, words);
    printf("NUMBER OF SENTENCES: %d\n", sentences);
    printf("NUMBER OF PARAGRAPHS: %d\n", paragraph);
    printf("NUMBER OF USED SPECIAL EXPRESSIONS: %d \n", special_exp);

    if (seconds > 60.0){
        int minutes = seconds / 60;
        int remaining_secods = (int) seconds % 60;
        if (minutes < 25)
            printf("TIME: %d minutes, %d seconds. Good timing!\n", minutes, remaining_secods);
        else
            printf("TIME: %d minutes, %d seconds. You exceeded the time limit over the %d.\n", minutes, remaining_secods, 25-minutes);
    }
    else
        printf("TIME: %d seconds. Too quick.\n", seconds);
    
    
    printf("\n");
    printf("Let's practice again!\n");
}

