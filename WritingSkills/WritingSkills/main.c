//
//  main.c
//  WritingSkills
//
//  Created by Aleksandra Korolczuk on 2017-09-05.
//  Copyright © 2017 Aleksandra Korolczuk. All rights reserved.
//

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#import <ctype.h>
#include "UserInput.h"
#include "Instructions.h"
#include "Result.h"




int main(int argc, const char * argv[]) {
   
    printHeadline();
    while(1) {
    int option = examOptions();
    showInstructions(option);
        if (startWriting(option) == 1)
            break;
    }
    
    
    return 0;
}
