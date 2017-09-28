//
//  Card.m
//  Makao
//
//  Created by Aleksandra Korolczuk on 2017-09-13.
//  Copyright © 2017 Aleksandra Korolczuk. All rights reserved.
//

#import "Card.h"

@implementation Card


- (instancetype)initWithFigure:(NSString*) figure andSuit:(NSString*)suit andValue:(int) value
{
    self = [super init];
    if (self) {
        _figure = figure;
        _suit = suit;
        _value = value;
        _card_repr = [NSArray arrayWithObjects:@"+--------+",[NSString stringWithFormat:@"|%@    %@|", suit, figure],[NSString stringWithFormat:@"|  %@    |",suit],[NSString stringWithFormat:@"|    %@  |", suit],[NSString stringWithFormat:@"|%@    %@|",figure, suit],@"+--------+", nil];
    }
    return self;
}



@end
