package com.example.geodesicapp.MapShowing

import com.example.geodesicapp.Coordinates.Coordinates
import com.example.geodesicapp.Coordinates.GeodesicCoordinates
import com.example.geodesicapp.Coordinates.GeographicCoordinates

class ShowMap(private var currentUserLocation: Coordinates, private var mapLocation: Coordinates
                //private var currentMap:MapStorage
                ) {

    fun checkCurrentUserLocation(): Coordinates {

        return Coordinates(
            GeodesicCoordinates(
                0.0,
                0.0,
                0.0
            ),
            GeographicCoordinates(0.0, 0.0)
        )
    }

    fun isUserOutsideMap():Boolean{

        return false
    }

    fun moveMap(first: Coordinates, second: Coordinates):Unit{

    }

    fun showCurrentLocation():Unit{

    }

    fun showMeasurementData():String{

        return String()
    }

    fun userChoiceMap():Unit{

    }

    fun zoomInOrOut(first: Coordinates, second: Coordinates):Unit{

    }
}