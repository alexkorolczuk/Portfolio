//
//  FutureDataModel.swift
//  Raincouver
//
//  Created by Aleksandra Korolczuk on 2017-10-03.
//  Copyright © 2017 Aleksandra Korolczuk & Momoko Nakada. All rights reserved.
//

import Foundation
import Alamofire

class FutureDataModel {
    
    private var _weatherConditions: [Int] = []
    private var _timeFrames: [Double] = []
    var _lat: Double = 0
    var _long: Double = 0
    typealias JSONStandard  = Dictionary<String, AnyObject>
    

    var weatherConditions: [Int] {
        return _weatherConditions
    }
    var timeFrames:[Double] {
        return _timeFrames
    }

    var url: URL {
        let key = KeyAPI().key
        var address = "http://" + "api.openweathermap.org/data/2.5/forecast?lat=" + String(describing: _lat)
        address = address + "&lon=" + String(describing: _long)
        address =  address + "&APPID=" + key
        
        return URL(string: address)!
    }
  
    func downloadData(completed: @escaping ()-> ()) {
        
        Alamofire.request(url).responseJSON(completionHandler: {
            response in
            let result = response.result
            
            if let dict = result.value as? JSONStandard,
                let list = dict["list"] as? [JSONStandard], 
                let data_3hours = list[0] as? JSONStandard,
                let weather3hours = data_3hours["weather"] as? [JSONStandard],
                let id_3 = weather3hours[0]["id"] as? Int,
                let time_3 = data_3hours["dt"] as? Double,
                
                let data_6hours = list[1] as? JSONStandard,
                let weather6hours = data_6hours["weather"] as? [JSONStandard],
                let id_6 = weather6hours[0]["id"] as? Int,
                let time_6 = data_6hours["dt"] as? Double,
                
                let data_9hours = list[2] as? JSONStandard,
                let weather9hours = data_9hours["weather"] as? [JSONStandard],
                let id_9 = weather9hours[0]["id"] as? Int,
                let time_9 = data_9hours["dt"] as? Double,
                
                let data_12hours = list[3] as? JSONStandard,
                let weather12hours = data_12hours["weather"] as? [JSONStandard],
                let id_12 = weather12hours[0]["id"] as? Int,
                let time_12 = data_12hours["dt"] as? Double {
                
                self._weatherConditions.insert(id_3, at: 0)
                self._weatherConditions.insert(id_6, at: 1)
                self._weatherConditions.insert(id_9, at: 2)
                self._weatherConditions.insert(id_12, at: 3)
                
                self._timeFrames.insert(time_3, at: 0)
                self._timeFrames.insert(time_6, at: 1)
                self._timeFrames.insert(time_9, at: 2)
                self._timeFrames.insert(time_12, at: 3)

            }
            completed()
        })
    }
}




