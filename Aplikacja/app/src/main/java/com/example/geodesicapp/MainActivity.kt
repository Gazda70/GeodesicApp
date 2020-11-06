package com.example.geodesicapp

import android.app.Activity
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import android.util.DisplayMetrics
import android.widget.ImageView
import com.example.geodesicapp.Coordinates.Coordinates
import com.example.geodesicapp.Coordinates.GeodesicCoordinates
import com.example.geodesicapp.Coordinates.GeographicCoordinates
import com.example.geodesicapp.FileLoading.FileLoaderKabeja
import com.example.geodesicapp.FileLoading.MapStorage
import com.example.geodesicapp.MapShowing.ShowMap
import com.example.geodesicapp.MeasurementManager.MeasurementManager
import com.example.geodesicapp.Measurements.Measurement

/**
 * Główna aktywność aplikacji.
 */
class MainActivity : Activity() {
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

        var geodesist = Geodesist(docu, ShowMap(Coordinates(GeodesicCoordinates(0.0,0.0,0.0), GeographicCoordinates()),
            Coordinates(GeodesicCoordinates(0.0,0.0,0.0), GeographicCoordinates()),
            MapStorage.instance), MeasurementManager(emptyList<Measurement>() ))
        geodesist.loadMap()

    }

}