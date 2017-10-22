//
//  showForecastButton.swift
//  Raincouver
//
//  Created by Momoko Nakada on 2017-10-10.
//  Copyright © 2017 Aleksandra Korolczuk & Momoko Nakada. All rights reserved.
//

import UIKit

class showForecastButton: UIButton {
    var selectView: UIView! = nil
    
    required init?(coder aDecoder: NSCoder) {
        super.init(coder: aDecoder)
        
        myInit()
    }
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        
        myInit()
    }
    
    func myInit() {
        
        // Round
        self.layer.cornerRadius = 5
        self.clipsToBounds = true
        
        // View for getting durk during press a button
        selectView = UIView(frame: self.bounds)
        selectView.backgroundColor = UIColor.black
        selectView.alpha = 0.0
        self.addSubview(selectView)
    }
    
    override func layoutSubviews() {
        super.layoutSubviews()
        
        selectView.frame = self.bounds
    }
    
    // Start toughting
    override func touchesBegan(_ touches: Set<UITouch>, with event: UIEvent?) {
        super.touchesBegan(touches, with: event)
        
        UIView.animate(withDuration: 0.1, delay: 0.0, options: UIViewAnimationOptions.curveLinear, animations: {() -> Void in
            
            self.selectView.alpha = 0.5
            
        }, completion: {(finished: Bool) -> Void in
        })
    }
    
    // Finish toughting
    override func touchesEnded(_ touches: Set<UITouch>, with event: UIEvent?) {
        super.touchesEnded(touches, with: event)
        
        UIView.animate(withDuration: 0.1, delay: 0.0, options: UIViewAnimationOptions.curveLinear, animations: {() -> Void in
            
            self.selectView.alpha = 0.0
            
        }, completion: {(finished: Bool) -> Void in
        })
    }

}
