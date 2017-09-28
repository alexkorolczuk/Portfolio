//
//  Player.h
//  Makao
//
//  Created by Aleksandra Korolczuk on 2017-09-13.
//  Copyright © 2017 Aleksandra Korolczuk. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "Deck.h"
#import "Player.h"
#import "Card.h"

@interface Player : NSObject



@property (nonatomic)  NSMutableArray* currentCards;
@property (nonatomic) NSString *name;
@property (nonatomic) Card *playingCard;


- (NSMutableArray *)handingOutCards:(int)number_of_cards fromDeck:(Deck *) deck;
- (int) currentNumberOfCards:(Deck *) deck;
//-(void)printCurrentCards:(int) cards;
// (BOOL) checkTheCard:(int)card withColor:(Deck *)deck;
- (void) play:(Card *) card withColor:(Deck *)deck andPlayer:(Player *)player;
- (BOOL) checkAllCardColors:(Deck *)deck;
- (void) checkWinnerOrLoser;
//- (void) displayAllWith;
//- (BOOL) checkUserInputforNumbers:(NSString *)input;


@end
