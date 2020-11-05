package com.example.geodesicapp.MeasurementManager

import com.example.geodesicapp.Coordinates.Coordinates
import com.example.geodesicapp.Measurements.Measurement

class MeasurementManager(private var measurement:List<Measurement>
                        //currentMap:MapStorage
) {

    fun add(newMeasurement: Measurement):Boolean{

        return false
    }

    fun addOptionalInfo():Unit{

    }

    fun choosePointOrBlock():Boolean{

        return false
    }

    fun delete(toDelete: Coordinates):Unit{

    }

    fun drawData():Unit{

    }

    fun end():Boolean{

        return false
    }

    fun modify(toModify: Coordinates):Unit{

    }
}