//
//  main.m
//  Makao
//
//  Created by Aleksandra Korolczuk on 2017-09-13.
//  Copyright © 2017 Aleksandra Korolczuk. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "Deck.h"
#import "Player.h"
#import "InputHandler.h"
#import "PlayerManager.h"
#import "Table.h"


int main(int argc, const char * argv[]) {
    @autoreleasepool {
       
#define NSLog(FORMAT, ...) printf("%s\n", [[NSString stringWithFormat:FORMAT, ##__VA_ARGS__] UTF8String]);

        /*
         TODO:
         - printing methods move to 1 seperate class
         - Player can just play, checking cards and input methods move to Crupier class
         - secure input - different way
         - create 52 cards deck
         - more functional cards

         
         
         */
        
        
        Deck *cardDeck = [[Deck alloc]init];
        PlayerManager *playerManager = [[PlayerManager alloc]init];
        [playerManager createPlayers];
    
        [Table displayWelcome];
        [cardDeck createFullDeck];
        [cardDeck startTheGame];
        
        while (1){
            Player *player = [playerManager currentPlayer];
            Player *secondPlayer = [playerManager nextPlayer];
            [Table displayCurrentPlayer:player];
            [player handingOutCards:[player currentNumberOfCards:cardDeck] fromDeck:cardDeck];
            while (![player checkAllCardColors:cardDeck]){
                [InputHandler checkIfDeckIsFinished:cardDeck andUpdateDeck:player withPlayers: secondPlayer];
                [player handingOutCards:1 fromDeck:cardDeck];
            }
            [Table divideCardsIntoRows:player];
            [Table displayCommands:@"choose"];
            
            while(![InputHandler checkPlayerCard:player withSuit:cardDeck.currentSuit]) {
                [Table displayCommands:@"wrong"];

            }
            
            [player play:player.playingCard withColor:cardDeck andPlayer:secondPlayer];
            [player checkWinnerOrLoser];
            [Table displayCurrentColor:cardDeck.currentSuit];
        }
    }
    return 0;
}
