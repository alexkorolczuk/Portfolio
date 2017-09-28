//
//  Card.h
//  Makao
//
//  Created by Aleksandra Korolczuk on 2017-09-13.
//  Copyright © 2017 Aleksandra Korolczuk. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface Card : NSObject


@property (nonatomic) NSString * figure;
@property (nonatomic) NSString * suit;
@property (nonatomic) int  value;
@property (nonatomic) NSArray * card_repr;


- (instancetype)initWithFigure:(NSString*) figure andSuit:(NSString*)suit andValue:(int) value;


@end
