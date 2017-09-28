//
//  Table.m
//  Makao
//
//  Created by Aleksandra Korolczuk on 2017-09-20.
//  Copyright © 2017 Aleksandra Korolczuk. All rights reserved.
//

#import "Table.h"
#import "Player.h"
#import "Card.h"


// class responsible for printing output to the user. 


@implementation Table

#define NSLog(FORMAT, ...) printf("%s\n", [[NSString stringWithFormat:FORMAT, ##__VA_ARGS__] UTF8String]);


+ (void) displayWelcome
{
    NSLog(@"♠️♠️♠️♠️♠️♠️♠️♠️♠️♠️♠️♠️♠️♠️ WELCOME TO MAKAO!!!♥️♥️♥️♥️♥️♥️♥️♥️♥️♥️♥️♥️♥️♥️♥️");
    NSLog(@"\n");
    NSLog(@"\n");
    NSLog(@"INSTRUCTIONS: Your goal is to get rid of all your cards ass quickly as you can.");
    NSLog(@"Change color with Ace.");
    NSLog(@"The card you can put on the table has to have te same suit");
    NSLog(@"as the suit of the last card on the table.");
    NSLog(@"\n");
    NSLog(@"\n");
    NSLog(@"-------------Your starting card is:------------");

}


+ (void) displayCommands:(NSString *)key
{
    NSDictionary *commands = @{
                               @"ace" : @"You can change color now. Please type: 1 for ♦️, 2 for ♣️, 3 for ♥️, 4 for ♠️",
                               @"wrong" : @"Wrong input. Please try again",
                               @"choose": @"Choose one card you want to play now:",
                               @"newDeck": @"♠️♣️♥️♦️♠️♣️♥️♦️♠️♣️♥️♦️♠️♣️♥️♦️♠️♣️♥️♦️♠️♣️♥️♦️♠️♣️♥️♦️ Playing with next deck ♠️♣️♥️♦️♠️♣️♥️♦️♠️♣️♥️♦️♠️♣️♥️♦️♠️♣️♥️♦️♠️♣️♥️♦️"
                           };
    NSLog(@"%@", [commands valueForKey:key]);
}
                         
+ (void) displayCurrentPlayer:(Player *)player
{
    NSLog(@"%@, YOUR MOVE!", player.name);
}


+ (void) displayCurrentColor:(NSMutableString *)suit
{
    NSLog(@"Current suit on the table: %@", suit);
}


+(void)divideCardsIntoRows:(Player *) player
{
    int cardsNumber = (int)[player.currentCards count];
    
    NSInteger index = 0;
    NSInteger lenght = 5;
    while (index < cardsNumber) {
        NSArray *five;
        if (index + lenght <= cardsNumber){
            five = [player.currentCards subarrayWithRange:NSMakeRange(index, lenght)];
        } else {
            lenght = cardsNumber - index;
            five = [player.currentCards subarrayWithRange:NSMakeRange(index, lenght)];
            
        }
        [self displayCards: five];
        index += 5;
    }
}


+ (void) displayCards:(NSArray *) cards
{
    for(int cardRow = 0; cardRow < 6; cardRow++){
        NSMutableArray *row = [NSMutableArray array];
        for (Card *card in cards) {
            [row addObject:[[card card_repr] objectAtIndex:cardRow] ];
        }
        NSLog(@"%@", [row componentsJoinedByString:@"   "]);
    }
}



@end
