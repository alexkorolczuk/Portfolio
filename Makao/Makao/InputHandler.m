//
//  InputHandler.m
//  Payments
//
//  Created by Aleksandra Korolczuk on 2017-08-29.
//  Copyright © 2017 Aleksandra Korolczuk. All rights reserved.
//

#import "InputHandler.h"
#import "Deck.h"
#import "Player.h"
#import "Table.h"
#import "PlayerManager.h"
#import "Card.h"


@implementation InputHandler

+ (Deck*) checkIfDeckIsFinished:(Deck *) deck andUpdateDeck:(Player *)player withPlayers:(Player*) secondPlayer
{
    if ([deck.currentDeck count] < 10) {
        [deck.currentDeck removeAllObjects];
        [Table displayCommands:@"newDeck"];
        deck.currentDeck = [deck createFullDeck];
        NSLog(@"NEW DECK numer of cards: %d", (int)[deck.currentDeck count]);
        for (int i=0;i< [deck.currentDeck count];i++) {
            for (int j=0;j<[player.currentCards count];j++){
                if ([[deck.currentDeck[i] valueForKey:@"figure"] isEqualToString: [player.currentCards[j] valueForKey:@"figure"]] && [[deck.currentDeck[i] valueForKey:@"suit"] isEqualToString: [player.currentCards[j] valueForKey:@"suit"]]){
                    NSLog(@"CARDS FOUND in the first player!: %@, %@", [deck.currentDeck[i] valueForKey:@"suit"], [deck.currentDeck[i] valueForKey:@"figure"]);
                    [deck.currentDeck removeObject:deck.currentDeck[i]];
                    NSLog(@"%d", (int)[deck.currentDeck count]);
                }
            }
        }
        for (int i=0;i< [deck.currentDeck count];i++) {
            for (int j=0;j<[secondPlayer.currentCards count];j++){
                if ([[deck.currentDeck[i] valueForKey:@"figure"] isEqualToString: [secondPlayer.currentCards[j] valueForKey:@"figure"]] && [[deck.currentDeck[i] valueForKey:@"suit"] isEqualToString: [secondPlayer.currentCards[j] valueForKey:@"suit"]]){
                    NSLog(@"CARDS FOUND second player: %@, %@", [deck.currentDeck[i] valueForKey:@"suit"], [deck.currentDeck[i] valueForKey:@"figure"]);
                    [deck.currentDeck removeObject:deck.currentDeck[i]];
                    NSLog(@"%d", (int)[deck.currentDeck count]);
                }
            }
        }
    }
    
    return deck;
}

+ (NSString *) getUserInput {
    char myStr[256];
    fgets(myStr, 256, stdin);
    NSString *input = [[NSString stringWithCString: myStr encoding: NSUTF8StringEncoding] stringByTrimmingCharactersInSet: [NSCharacterSet whitespaceAndNewlineCharacterSet]];
    return input;
}

+ (BOOL) checkPlayerCard:(Player *)player withSuit:(NSMutableString *) suit
{
    int count = (int) [player.currentCards count];
    NSString *card = [InputHandler getUserInput];
    if ([card intValue] == 0){
        return false;
    } else if ([card intValue] > count){
        return false;
    } else if ([[player.currentCards[[card intValue]-1] valueForKey:@"suit"] isNotEqualTo:suit]){
        return false;
    } else {
        player.playingCard = player.currentCards[[card intValue] - 1];
        return true;
    }
    
    
    
}
@end
