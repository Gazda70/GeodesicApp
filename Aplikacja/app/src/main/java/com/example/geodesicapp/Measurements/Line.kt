package com.example.geodesicapp.Measurements

import android.graphics.Color
import android.graphics.Paint
import com.example.geodesicapp.Coordinates.Coordinates
import com.example.geodesicapp.Coordinates.GeodesicCoordinates
import com.example.geodesicapp.Coordinates.GeographicCoordinates
import com.example.geodesicapp.FileLoading.MapStorage

/**
 * Klasa reprezentująca pomiar linii.
 * @property comment komentarz do pomiaru.
 * @property measurementType informacja o typie dokonanego pomiaru
 * @property photoPath ścieżka do pliku z obrazem dołączonym do pomiaru.
 * @property points lista punktów tworzących linię.
 */
class Line(comment:String, measurementType:String,
           photoPath:String, private var points:List<Point>)
            :Measurement(comment, measurementType, photoPath) {

    /**
     * Metoda rysująca linię.
     */
    override fun draw() {
        var paint = Paint()
        paint.color = Color.rgb(0,0,0)
        paint.strokeWidth =100F
        var canvas  = MapStorage.instance.getGraphics()

        setPoints(getPoints())

        canvas?.drawLine(points[0].getCoordinates().Geodesic.getCoordinates().second.toFloat(),
            points[0].getCoordinates().Geodesic.getCoordinates().third.toFloat(),
            points[1].getCoordinates().Geodesic.getCoordinates().second.toFloat(),
            points[1].getCoordinates().Geodesic.getCoordinates().third.toFloat(),
            paint
            )
        this.setComment("")
        this.setMeasurementType("Linia")
        this.setPhotoPath("MojeZdjęcia")
       // canvas?.drawLine(100.0F,100.0F,200.0F,200.0F, paint)

    }

    /**
     * Metoda udostępniająca punkty linii.
     * @return lista punktów tworzących linię.
     */
    fun getPoints():List<Point>{
        return this.points
    }

    /**
     * Metoda ustawiająca punkty linii.
     * @param newPoints nowa lista punktów tworzących linię.
     */
    fun setPoints(newPoints:List<Point>):Unit{
        this.points = newPoints
    }
}