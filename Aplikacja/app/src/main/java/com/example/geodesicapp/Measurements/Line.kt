package com.example.geodesicapp.Measurements

import android.graphics.Color
import android.graphics.Paint
import com.example.geodesicapp.FileLoading.MapStorage

class Line(comment:String, measurementType:String,
           photoPath:String,private var points:List<Point>)
            :Measurement(comment, measurementType, photoPath) {

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

    fun getPoints():List<Point>{

        return this.points
    }

    fun setPoints(newPoints:List<Point>):Unit{

    }
}