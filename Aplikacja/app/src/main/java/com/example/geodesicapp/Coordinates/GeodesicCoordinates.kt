package com.example.geodesicapp.Coordinates

class GeodesicCoordinates(private var heigthH:Double, private var lengthL:Double,
                            private var widthB:Double)
{

    fun getCoordinates() : Triple<Double, Double, Double>{

        return Triple<Double, Double, Double>(heigthH, lengthL, widthB)
    }

    fun setCoordinates(newHeigthH:Double, newLengthL:Double, newWidthB:Double):Unit{

    }
}