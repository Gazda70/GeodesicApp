package com.example.geodesicapp

import com.example.geodesicapp.FileLoading.FileLoaderKabeja
import com.example.geodesicapp.FileLoading.MapStorage
import com.example.geodesicapp.MapShowing.ShowMap
import com.example.geodesicapp.MeasurementManager.MeasurementManager

class Geodesist(private var measurementManager: MeasurementManager, private var mapStorage: MapStorage,
                private var fileLoader: FileLoaderKabeja, private var mapShow:ShowMap) {

    fun addMeasure():Boolean{

        return false
    }

    fun loadMap():Boolean{

        return false
    }

    fun useMap():Unit{
        this.mapShow.showCurrentLocation()
    }
}