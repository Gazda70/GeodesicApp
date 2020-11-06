package com.example.geodesicapp

import android.app.Activity
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import android.util.DisplayMetrics
import android.widget.Button
import android.widget.ImageView
import com.example.geodesicapp.Coordinates.Coordinates
import com.example.geodesicapp.Coordinates.GeodesicCoordinates
import com.example.geodesicapp.Coordinates.GeographicCoordinates
import com.example.geodesicapp.FileLoading.FileLoaderKabeja
import com.example.geodesicapp.FileLoading.MapStorage
import com.example.geodesicapp.MapShowing.ShowMap
import com.example.geodesicapp.MeasurementManager.MeasurementManager
import com.example.geodesicapp.Measurements.Measurement


class MainActivity : Activity() {

    lateinit var myGeodesist:Geodesist
    var measurements:MutableList<Measurement> = mutableListOf()
    var showMap:ShowMap = ShowMap(Coordinates(GeodesicCoordinates(0.0, 0.0, 0.0), GeographicCoordinates(0.0,0.0)),
        Coordinates(GeodesicCoordinates(0.0, 0.0, 0.0), GeographicCoordinates(0.0,0.0)), MapStorage.instance
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var docu = FileLoaderKabeja("",50,50, MapStorage.instance )
        docu.loadFileFromSource(resources.openRawResource(R.raw.mapa))
        var imageView = findViewById<ImageView>(R.id.imageView)
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)

        var width = displayMetrics.widthPixels
        var height = displayMetrics.heightPixels
        var drawer = Bitmap.createBitmap(width,height,Bitmap.Config.ARGB_8888)
        var canvas = Canvas(drawer)
        MapStorage.instance.setGraphics(canvas)
        imageView.setImageBitmap(drawer)

        myGeodesist = Geodesist(MeasurementManager(measurements, MapStorage.instance),
            MapStorage.instance, docu, showMap)

        var useMapButton: Button = this.findViewById(R.id.button)

        useMapButton.setOnClickListener {
            myGeodesist.useMap()
        }
    }

}