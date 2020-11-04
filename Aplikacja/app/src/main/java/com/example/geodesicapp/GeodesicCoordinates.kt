package com.example.geodesicapp

class GeodesicCoordinates(private var heigthH:Double, private var lengthL:Double,
                            private var widthB:Double)
{

    fun getCoordinates() : Triple<Double, Double, Double>{

        return Triple<Double, Double, Double>(0.0, 0.0, 0.0)
    }

    fun setCoordinates(newHeigthH:Double, newLengthL:Double, newWidthB:Double):Unit{

    }
}