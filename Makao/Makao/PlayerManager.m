//
//  PlayerManager.m
//  Makao
//
//  Created by Aleksandra Korolczuk on 2017-09-14.
//  Copyright © 2017 Aleksandra Korolczuk. All rights reserved.
//

#import "PlayerManager.h"
#import "Player.h"
#import "InputHandler.h"


@implementation PlayerManager


- (instancetype)init
{
    self = [super init];
    if (self) {
        _players = [[NSMutableArray alloc]init];
        _currentIndex = 0;

    }
    return self;
}

-(void)createPlayers
{
    for (int i=0; i<2;i++) {
        Player *player = [[Player alloc]init];
        player.name =[NSMutableString stringWithFormat:@"PLAYER: %d",i+1];
        [_players addObject:player];
    }
}

- (Player *)currentPlayer
{
    
    int count = (int) [_players count];
    int i = (int)_currentIndex;
    
    Player *player;
    
    while (i % count != 0 || i==0){
        Player *player = _players[i];
        return player;
    }
    if(i % count == 0)
        _currentIndex= 0;
    
    
    return player;
}

- (Player *)nextPlayer
{
    Player *player;

    if (_currentIndex == 0){
        _currentIndex= 1;
        Player *player = _players[1];
        return player;

    }
    else if (_currentIndex == 1){
        _currentIndex = 0;
        Player *player = _players[0];
        return player;

    }
    
    return player;
    
}



@end
