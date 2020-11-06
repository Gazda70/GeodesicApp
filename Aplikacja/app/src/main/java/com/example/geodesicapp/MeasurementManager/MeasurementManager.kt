package com.example.geodesicapp.MeasurementManager

import com.example.geodesicapp.Coordinates.Coordinates
import com.example.geodesicapp.FileLoading.MapStorage
import com.example.geodesicapp.Measurements.Measurement

class MeasurementManager(private var measurement:MutableList<Measurement>,
                        currentMap: MapStorage
) {

    fun add(newMeasurement: Measurement):Boolean{
        var toReturn = true
        try {
            newMeasurement.draw()
            measurement.add(newMeasurement)
        }catch(e:Exception){
            toReturn = false
        }
        return toReturn
    }

    fun addOptionalInfo():Unit{

    }

    fun choosePointOrBlock():Boolean{

        return false
    }

    fun delete(toDelete: Coordinates):Unit{

    }

    fun drawData():Unit{
        for(m in measurement){
            m.draw()
        }
    }

    fun end():Boolean{

        return false
    }

    fun modify(toModify: Coordinates):Unit{

    }
}