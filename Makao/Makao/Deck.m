//
//  Deck.m
//  Makao
//
//  Created by Aleksandra Korolczuk on 2017-09-13.
//  Copyright © 2017 Aleksandra Korolczuk. All rights reserved.
//

#import "Deck.h"
#import "Card.h"


@implementation Deck

#define NSLog(FORMAT, ...) printf("%s\n", [[NSString stringWithFormat:FORMAT, ##__VA_ARGS__] UTF8String]);


- (instancetype)init
{
    self = [super init];
    if (self) {
        _currentDeck = [[NSMutableArray alloc]init];
        _currentSuit = [[NSMutableString alloc]init];
                         
    }
    return self;
}


-(NSMutableArray *)createFullDeck
{
    for(int i = 0; i < 52; i++) {
        NSString *suit = @"";
        int value = 0;
        NSString *figure =@"";
        
        
        //diamonds (♦), clubs (♣), hearts (♥) and spades (♠)
        
        /*
        \*
        ♤ = 0x2664 = 0xE2 0x99 0xA4
        ♡ = 0x2661 = 0xE2 0x99 0xA1
        ♢ = 0x2662 = 0xE2 0x99 0xA2
        ♧ = 0x2667 = 0xE2 0x99 0xA7
         ♠️♣️♥️♦️
        */
        
        if (i % 4 == 0) {
            suit = @"♦️";
        } else if (i % 4 == 1) {
            suit = @"♣️";;
        } else if (i % 4 == 2) {
            suit = @"♥️";;
        } else if (i % 4 == 3) {
            suit = @"♠️";
        }
        
        if (i< 4) {
            value = 1;
            figure = @"A ";
        } else if (i>=4 && i< 8) {
            value = 2;
            figure = @"K ";
        } else if (i>=8 && i< 12) {
            value = 3;
            figure = @"Q ";
        } else if (i>=12 && i< 16) {
            value = 4;
            figure = @"J ";
        } else if (i>=16 && i< 20) {
            value = 5;
            figure = @"10";
        } else if (i>=20 && i< 24) {
            value = 6;
            figure = @"9 ";
        }else if (i>=24 && i< 28) {
            value = 7;
            figure = @"8 ";
        }else if (i>=28 && i< 32) {
            value = 8;
            figure = @"7 ";
        }else if (i>=32 && i< 36) {
            value = 9;
            figure = @"6 ";
        }else if (i>=36 && i< 40) {
            value = 10;
            figure = @"5 ";
        }else if (i>=40 && i< 44) {
            value = 11;
            figure = @"4 ";
        } else if (i>=44 && i< 48) {
            value = 12;
            figure = @"3 ";
        }else if (i>=48 && i< 52) {
            value = 13;
            figure = @"2 ";
        }
        
        
        Card *card = [[Card alloc] initWithFigure:figure andSuit:suit andValue:value];
        [_currentDeck addObject: card];
    }
   
    return _currentDeck;
}

- (NSMutableArray *) startTheGame
{
    int number_of_cards = (int)_currentDeck.count;
    int random_card = arc4random() % number_of_cards;
    
    NSString *c =  [_currentDeck[random_card] valueForKey:@"suit"];
    NSString *f =  [_currentDeck[random_card] valueForKey:@"figure"];
    NSString * card = [NSString stringWithFormat:
                       @"\n+--------+\n|%@    %@|\n|  %@    |\n|    %@  |\n|%@    %@|\n+--------+\n",c,f,c,c,f,c];
    NSLog(@"%@", card);
    [_currentSuit setString:[_currentDeck[random_card] valueForKey:@"suit"]];
    NSLog(@"CURRENT SUIT: %@", _currentSuit);
    [self updateDeck:random_card];
    return _currentDeck;
}

- (void)updateDeck:(int) card_index
{
    [_currentDeck removeObjectAtIndex:card_index];
 
}

@end
