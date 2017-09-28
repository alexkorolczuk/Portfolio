//
//  Deck.h
//  Makao
//
//  Created by Aleksandra Korolczuk on 2017-09-13.
//  Copyright © 2017 Aleksandra Korolczuk. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface Deck : NSObject


@property (nonatomic) NSMutableArray *currentDeck;
@property (nonatomic) NSMutableString * currentSuit;


- (NSMutableArray *)createFullDeck;
- (NSMutableArray *) startTheGame;
- (void)updateDeck:(int) card_index;

@end
