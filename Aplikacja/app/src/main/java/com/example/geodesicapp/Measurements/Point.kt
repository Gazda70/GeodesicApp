package com.example.geodesicapp.Measurements

import com.example.geodesicapp.Coordinates.Coordinates

class Point(comment:String, measurementType:String,
            photoPath:String,private var pairOfCoordinates: Coordinates)
    :Measurement(comment, measurementType, photoPath){

    override fun draw():Unit{

    }

    fun getCoordinates(): Coordinates {

        return this.pairOfCoordinates
    }

    fun setCoordinates(newCoords: Coordinates):Unit{

    }
}