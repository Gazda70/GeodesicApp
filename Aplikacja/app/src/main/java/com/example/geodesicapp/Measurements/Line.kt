package com.example.geodesicapp.Measurements

import android.graphics.Color
import android.graphics.Paint
import com.example.geodesicapp.FileLoading.MapStorage

/**
 * Klasa reprezentująca pomiar linii.
 * @property comment komentarz do pomiaru.
 * @property measurementType informacja o typie dokonanego pomiaru
 * @property photoPath ścieżka do pliku z obrazem dołączonym do pomiaru.
 * @property points lista punktów tworzących linię.
 */
class Line(comment:String, measurementType:String,
           photoPath:String,private var points:List<Point>)
            :Measurement(comment, measurementType, photoPath) {


    /**
     * Metoda rysująca linię.
     */
    override fun draw() {
        var paint = Paint()
        paint.color = Color.rgb(255,255,255)
        paint.strokeWidth =10F
        var canvas  = MapStorage.instance.getGraphics()
        canvas?.drawLine(points[0].getCoordinates().Geodesic.getCoordinates().third.toFloat(),
            points[0].getCoordinates().Geodesic.getCoordinates().second.toFloat(),
            points[1].getCoordinates().Geodesic.getCoordinates().third.toFloat(),
            points[1].getCoordinates().Geodesic.getCoordinates().second.toFloat(),
            paint
            )

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

    }
}