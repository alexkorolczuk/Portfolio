//
//  InputHandler.h
//  Payments
//
//  Created by Aleksandra Korolczuk on 2017-08-29.
//  Copyright © 2017 Aleksandra Korolczuk. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "Deck.h"
#import "Player.h"


@interface InputHandler : NSObject



+ (NSString *) getUserInput;
+ (Deck*) checkIfDeckIsFinished:(Deck *) deck andUpdateDeck:(Player *)player withPlayers:(Player*) secondPlayer;
+ (BOOL) checkPlayerCard:(Player *)player withSuit:(NSMutableString *) suit;



@end
