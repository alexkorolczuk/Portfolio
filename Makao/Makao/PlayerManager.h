//
//  PlayerManager.h
//  Makao
//
//  Created by Aleksandra Korolczuk on 2017-09-14.
//  Copyright © 2017 Aleksandra Korolczuk. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "Player.h"


@interface PlayerManager : NSObject


@property (nonatomic) NSMutableArray *players;
@property (nonatomic) NSInteger currentIndex;



-(void)createPlayers;
- (Player *)currentPlayer;
- (Player *)nextPlayer;

@end
