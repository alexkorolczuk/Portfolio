//
//  FutureViewController.swift
//  Raincouver
//
//  Created by Aleksandra Korolczuk on 2017-10-03.
//  Copyright © 2017 Aleksandra Korolczuk & Momoko Nakada. All rights reserved.
//

import UIKit

class FutureViewController: UIViewController {
    
    @IBOutlet weak var rain3HoursImage: UIImageView!
    @IBOutlet weak var rain6HoursImage: UIImageView!
    @IBOutlet weak var rain9HoursImage: UIImageView!
    @IBOutlet weak var rain12HoursImage: UIImageView!
    
    @IBOutlet weak var time3HoursLabel: UILabel!
    @IBOutlet weak var time6HoursLabel: UILabel!
    @IBOutlet weak var time9HoursLabel: UILabel!
    @IBOutlet weak var time12HoursLabel: UILabel!
    
    var weather = FutureDataModel()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        let defaults:UserDefaults = UserDefaults.standard
        weather._lat  = defaults.double(forKey: "latitude")
        weather._long = defaults.double(forKey: "longitude")


        weather.downloadData {
            self.updateUI()
        }
        
        drawCircle()
        drawLine()
        
        self.view.bringSubview(toFront: rain3HoursImage)
        self.view.bringSubview(toFront: rain6HoursImage)
        self.view.bringSubview(toFront: rain9HoursImage)
        self.view.bringSubview(toFront: rain12HoursImage)
        
        self.view.bringSubview(toFront: time3HoursLabel)
        self.view.bringSubview(toFront: time6HoursLabel)
        self.view.bringSubview(toFront: time9HoursLabel)
        self.view.bringSubview(toFront: time12HoursLabel)
        
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }
    
    
    func checkIdForRain( id: Int) -> Bool {
        let arrayOfIds:[Int] = [900, 901, 902, 906, 960, 961]
        if id < 622 || arrayOfIds.contains(id) {
            return true
        } else {
            return false
        }
    }

    func updateUI() {
        let timeLabels:[UILabel] = [time3HoursLabel, time6HoursLabel,time9HoursLabel, time12HoursLabel]
        
        let weatherImages:[UIImageView] = [rain3HoursImage, rain6HoursImage,rain9HoursImage, rain12HoursImage]

        for (index, _) in weather.weatherConditions.enumerated() {
            if checkIdForRain(id: weather.weatherConditions[index]) == true {
                weatherImages[index].image = UIImage(named: "iconSmallOpenUmbrella.png")
            } else {
                weatherImages[index].image = UIImage(named: "iconSmallCloseUmbrella.png")
            }
        }
        
        
        for (index, _) in weather.timeFrames.enumerated() {
            let dateFormatter = DateFormatter()
                    dateFormatter.dateStyle = .none
                    dateFormatter.timeStyle = .short
                    let date = Date(timeIntervalSince1970: weather.timeFrames[index])
                    let dateToPrint =  (weather.timeFrames[index] != nil) ? "\(dateFormatter.string(from: date))" : "Date Invalid"
            timeLabels[index].text = dateToPrint
        }
        assignbackground()
    }
    
    func assignbackground(){
        var background: UIImage!
        
        for (index, _) in weather.weatherConditions.enumerated() {
            if checkIdForRain(id: weather.weatherConditions[index]) == true {
                background = UIImage(named: "bgRain.png")!
                break
            }
            else{
                background = UIImage(named: "bgNoRain.png")!
            }
        }
        
        var imageView : UIImageView!
        imageView = UIImageView(frame: view.bounds)
        imageView.contentMode =  UIViewContentMode.bottom
        imageView.clipsToBounds = true
        imageView.image = background
        imageView.center = view.center
        view.addSubview(imageView)
        self.view.sendSubview(toBack: imageView)
    }
    
    func drawCircle(){
        let circle = UIView(frame: CGRect(x: 0.0, y: 0.0, width: 300.0, height: 300.0))
        circle.center = self.view.center
        circle.layer.cornerRadius = 150
        circle.backgroundColor = UIColor.white
        circle.layer.borderWidth = 1
        circle.layer.borderColor = UIColor.lightGray.cgColor
        circle.clipsToBounds = true
        self.view.addSubview(circle)
        self.view.sendSubview(toBack: circle)
    }
    
    func drawLine(){
        let line1 = UIView(frame: CGRect(x: 0.0, y: 0.0, width: 300.0, height: 1.0))
        line1.center = self.view.center
        line1.transform = line1.transform.rotated(by: .pi/4)
        line1.backgroundColor = UIColor.white
        line1.layer.borderWidth = 1
        line1.layer.borderColor = UIColor.lightGray.cgColor
        line1.clipsToBounds = true
        self.view.addSubview(line1)
        
        let line2 = UIView(frame: CGRect(x: 0.0, y: 0.0, width: 1.0, height: 300.0))
        line2.center = self.view.center
        line2.transform = line2.transform.rotated(by: .pi/4)
        line2.backgroundColor = UIColor.white
        line2.layer.borderWidth = 1
        line2.layer.borderColor = UIColor.lightGray.cgColor
        line2.clipsToBounds = true
        self.view.addSubview(line2)
    }
}

