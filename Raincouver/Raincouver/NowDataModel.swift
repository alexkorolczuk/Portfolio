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
    // empty data model object:
    
    
    // data  seperated from API call
    
    //1 api class with 2 methods.->
    // results from 1 method  -> data model
    // first view controller -> api  -> data model -> view controller.
    
    //1 api, 2. data model, 3 view controller.
    
    
    private var _date: Double?
    private var _temp: String?
    private var _location: String?
    private var _weather: Int?
    var _lat: Double = 0
    var _long: Double = 0
    typealias JSONStandard  = Dictionary<String, AnyObject>
    // viewconteoller.location.coordiate.location
    
    
    // error handling in case nil:
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
        var address = "http://" + "api.openweathermap.org/data/2.5/weather?lat="
        address = address + String(describing: _lat)
        address = address + "&lon="
        address = address + String(describing: _long)
        address = address + "&APPID=2b4f4a5f48466e99d8a1f24f3a906eaf"
        print(address)
        
        //   + "api.openweathermap.org/data/2.5/forecast?lat={" + self._lat + "}&lon={" + self._long + "}"
        return address
    }
    var url:URL {
        return URL(string: address)!
    }
    
    //using pod to get jason data and put them into DataModel obj
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
    


