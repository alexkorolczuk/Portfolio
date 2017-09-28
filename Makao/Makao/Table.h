//
//  Table.h
//  Makao
//
//  Created by Aleksandra Korolczuk on 2017-09-20.
//  Copyright © 2017 Aleksandra Korolczuk. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "Player.h"

@interface Table : NSObject


+ (void)divideCardsIntoRows:(Player *) player;
+ (void) displayWelcome;
+ (void) displayCurrentColor:(NSMutableString *)suit;
+ (void) displayCurrentPlayer:(Player *)player;
+ (void) displayCommands:(NSString *)key;




@end
