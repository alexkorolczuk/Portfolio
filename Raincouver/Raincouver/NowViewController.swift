//
//  ViewController.swift
//  Raincouver
//
//  Created by Aleksandra Korolczuk on 2017-09-28.
//  Copyright © 2017 Aleksandra Korolczuk & Momoko Nakada. All rights reserved.
//

import UIKit
import CoreLocation

class NowViewController: UIViewController, CLLocationManagerDelegate {

    @IBOutlet weak var showFutureButton: UIButton!
    @IBOutlet weak var weatherImage: UIImageView!
    @IBOutlet weak var tempLabel: UILabel!
    @IBOutlet weak var locationLabel: UILabel!
    
    
    var weather = NowDataModel()
    let locationManager = CLLocationManager()
    func locationManager(_ manager: CLLocationManager, didChangeAuthorization status: CLAuthorizationStatus) {
        if status == .authorizedWhenInUse || status == .authorizedAlways {
            manager.requestLocation()
            loadDatatoModel(locationManager.location!)
        }
    }
    func locationManager(_ manager: CLLocationManager, didUpdateLocations locations: [CLLocation]) {
        if let userLocation = locations.first {
            loadDatatoModel(userLocation)
        }
    }
    
    func loadDatatoModel(_ userLocation: CLLocation){
        let defaultLocation: UserDefaults = UserDefaults.standard
        defaultLocation.set(userLocation.coordinate.latitude, forKey: "latitude")
        defaultLocation.set(userLocation.coordinate.longitude, forKey: "longitude")
        weather._lat  = defaultLocation.double(forKey: "latitude")
        weather._long = defaultLocation.double(forKey: "longitude")
     
        weather.downloadData {
            self.updateUI()
        }
    }
    
    func locationManager(_ manager: CLLocationManager, didFailWithError error: Error) {
        
    }
    func putCoordinatesIntoDataModel(location: CLLocation) {
        
    }

    
    override func viewDidLoad() {
        super.viewDidLoad()
        locationManager.delegate = self
        locationManager.desiredAccuracy = kCLLocationAccuracyBest
        locationManager.requestWhenInUseAuthorization()
        

        drawCircle()
        
        self.view.bringSubview(toFront: weatherImage)
        self.view.bringSubview(toFront: tempLabel)
    }
    
    func assignbackground(){
        var background: UIImage!
        
        if checkIdForRain(id: weather.weather) == true {
            background = UIImage(named: "bgRain.png")!
        } else{
            background = UIImage(named: "bgNoRain.png")!
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
    
    func checkIdForRain( id: Int) -> Bool {
        let arrayOfIds:[Int] = [900, 901, 902, 906, 960, 961]
        if id < 622 || arrayOfIds.contains(id) {
            return true
        } else {
            return false
        }
    }

    func updateUI() {
        tempLabel.text = "\(weather.temp)"
        locationLabel.text = weather.location
        
        if checkIdForRain(id: weather.weather) == true {
            weatherImage.image =  UIImage(named: "iconOpenUmbrella.png")
        } else{
            weatherImage.image =  UIImage(named: "iconCloseUmbrella.png")
        }
        assignbackground()
        
    }
    
    func drawCircle(){
        let circle = UIView(frame: CGRect(x: 0.0, y: 0.0, width: 150.0, height: 150.0))
        circle.center = self.view.center
        circle.layer.cornerRadius = 75
        circle.backgroundColor = UIColor.white
        circle.layer.borderWidth = 1
        circle.layer.borderColor = UIColor.lightGray.cgColor
        circle.clipsToBounds = true
        self.view.addSubview(circle)
    }
    
}


