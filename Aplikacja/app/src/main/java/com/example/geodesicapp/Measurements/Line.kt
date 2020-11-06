package com.example.geodesicapp.Measurements

import android.graphics.Color
import android.graphics.Paint
import com.example.geodesicapp.FileLoading.MapStorage

class Line(comment:String, measurementType:String,
           photoPath:String,private var points:List<Point>)
            :Measurement(comment, measurementType, photoPath) {

    override fun draw() {
        var paint = Paint()
        paint.color = Color.rgb(0,0,0)
        paint.strokeWidth =100F
        var canvas  = MapStorage.instance.getGraphics()

        canvas?.drawLine(points[0].getCoordinates().Geodesic.getCoordinates().second.toFloat(),
            points[0].getCoordinates().Geodesic.getCoordinates().third.toFloat(),
            points[1].getCoordinates().Geodesic.getCoordinates().second.toFloat(),
            points[1].getCoordinates().Geodesic.getCoordinates().third.toFloat(),
            paint
            )
       // canvas?.drawLine(100.0F,100.0F,200.0F,200.0F, paint)

    }

    fun getPoints():List<Point>{

        return this.points
    }

    fun setPoints(newPoints:List<Point>):Unit{

    }
}