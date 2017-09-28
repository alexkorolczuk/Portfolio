//
//  Player.m
//  Makao
//
//  Created by Aleksandra Korolczuk on 2017-09-13.
//  Copyright © 2017 Aleksandra Korolczuk. All rights reserved.
//

#import "Player.h"
#import "Deck.h"
#import "InputHandler.h"
#import "Card.h"
#import "PlayerManager.h"
#import "Table.h"

@implementation Player



- (instancetype)init
{
    self = [super init];
    if (self) {
        _currentCards = [[NSMutableArray alloc]init];
    }
    return self;
}

- (int) currentNumberOfCards:(Deck *) deck
{
    if (_currentCards == NULL || _currentCards.count == 0 ){
        return 5;
    }
        else return 0;
}

-(NSMutableArray *)handingOutCards:(int)number_of_cards fromDeck:(Deck *) deck
{
    
//            if ([deck.currentDeck count] < 2) {
//                [deck.currentDeck removeAllObjects];
//                NSLog(@"\n");
//                NSLog(@"♠️♣️♥️♦️♠️♣️♥️♦️♠️♣️♥️♦️♠️♣️♥️♦️♠️♣️♥️♦️♠️♣️♥️♦️♠️♣️♥️♦️ Playing with next deck ♠️♣️♥️♦️♠️♣️♥️♦️♠️♣️♥️♦️♠️♣️♥️♦️♠️♣️♥️♦️♠️♣️♥️♦️");
//                NSLog(@"\n");
//                deck.currentDeck = [deck createFullDeck];
//                NSLog(@"%d", (int)[deck.currentDeck count]);
//          
//                for (int i=0;i< [deck.currentDeck count];i++) {
//                    for (int j=0;j< [self.currentCard count];j++){
//                        if ([[deck.currentDeck[i] valueForKey:@"figure"] isEqualToString: [self.currentCard[j] valueForKey:@"figure"]] && [[deck.currentDeck[i] valueForKey:@"suit"] isEqualToString: [self.currentCard[j] valueForKey:@"suit"]]){
//                            NSLog(@"CARDS FOUND!: %@, %@", [deck.currentDeck[i] valueForKey:@"suit"], [deck.currentDeck[i] valueForKey:@"figure"]);
//                            [deck.currentDeck removeObject:deck.currentDeck[i]];
//                            NSLog(@"%d", (int)[deck.currentDeck count]);
//
//                            
//                    }
//                    }
//                }
//            }
    
            for (int i=0; i< number_of_cards; i++){
                NSLog(@"3. count: %lu", (unsigned long)[deck.currentDeck count]);
            int random_card = arc4random() % [deck.currentDeck count];
            [self.currentCards addObject:(deck.currentDeck[random_card])];
            [deck updateDeck:random_card];


    }
    return _currentCards;
}

    


- (BOOL) checkAllCardColors:(Deck *)deck
{
    int without_color = 0;
    int good  = 0;
    for (int i=0;i<_currentCards.count;i++){
        if([[_currentCards[i] valueForKey:@"suit"] isNotEqualTo:deck.currentSuit]){
            without_color++;
        }
        else
            good++;
    }
    if (good >= 1)
        return TRUE;
    else
        return false;
}
- (void) play:(Card *) card withColor:(Deck *)deck andPlayer:(Player *)player
{
    [deck.currentSuit setString:card.suit];
    
    //if ([[_currentCard[card] valueForKey:@"value"] intValue] == 2 ||  [[_currentCard[card] valueForKey:@"value"] intValue] == 3 ) {
       // player.currentCard = [player handingOutCards:[player currentNumberOfCards:deck] +2 fromDeck:deck];
   // }
     if ( card.value == 1 || card.value == 6) {
         [Table displayCommands:@"ace"];
         NSString *change_color = [InputHandler getUserInput];
             if([change_color  isEqual: @"1"])
                 [deck.currentSuit setString:@"♦️"];
             else if([change_color  isEqual: @"2"])
                [deck.currentSuit setString:@"♣️"];
             else if([change_color  isEqual: @"3"])
                 [deck.currentSuit setString:@"♥️"];
             else if([change_color  isEqual: @"4"])
                 [deck.currentSuit setString:@"♠️"];
         }

    [_currentCards removeObject:card];
   
}

- (void) checkWinnerOrLoser
{
    if ([_currentCards count] < 1){
        NSLog(@"YOU WON!!!!");
        exit(0);
    } else if ([_currentCards count] > 30) {
        NSLog(@"You've got more that 30 cards! You lost!");
        exit(0);
    }
}


@end

