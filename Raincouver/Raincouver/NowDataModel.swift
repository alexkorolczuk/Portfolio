//
//  WeatherDataModel.swift
//  Raincouver
//
//  Created by Aleksandra Korolczuk on 2017-09-30.
//  Copyright © 2017 Aleksandra Korolczuk & Momoko Nakada. All rights reserved.
//

import Foundation
import Alamofire


class NowDataModel {
    
    private var _date: Double?
    private var _temp: String?
    private var _location: String?
    private var _weather: Int?
    var _lat: Double = 0
    var _long: Double = 0
    typealias JSONStandard  = Dictionary<String, AnyObject>
   

    
    
    var date: String {
        let dateFormatter = DateFormatter()
        dateFormatter.dateFormat = .none
        dateFormatter.timeStyle = .short
        let date = Date(timeIntervalSince1970: _date!)
        return (_date != nil) ? "\(dateFormatter.string(from: date))" : "Date Invalid"
    }
    
    var temp: String {
        return _temp ?? "0 °C"
    }
    
    var location: String {
        return _location ?? "Location Invalid"
    }
    
    var weather: Int {
        return _weather ?? 0
    }
    
    var address: String {
        let key = KeyAPI().key
        var address = "http://" + "api.openweathermap.org/data/2.5/weather?lat=" + String(describing: _lat)
        address = address + "&lon=" + String(describing: _long)
        address = address + "&APPID=" + key
        print(address)
        return address
    }
    var url:URL {
        return URL(string: address)!
    }
    
    func downloadData(completed: @escaping ()-> ()) {
        
        Alamofire.request(url).responseJSON(completionHandler: {
            response in
            let result = response.result
            
            if let dict = result.value as? JSONStandard,
                let main = dict["main"] as? JSONStandard,
                let temp = main["temp"] as? Double,
                let weatherArray = dict["weather"] as? [JSONStandard],
                let weather = weatherArray[0]["id"] as? Int,
                let name = dict["name"] as? String,
                let sys = dict["sys"] as? JSONStandard,
                let country = sys["country"] as? String,
                let dt = dict["dt"] as? Double {
                
                self._temp = String(format: "%.0f °C", temp - 273.15)
                self._weather = weather
                self._location = "\(name), \(country)"
                self._date = dt

            }
            
            completed()
        })
    }
}
    


