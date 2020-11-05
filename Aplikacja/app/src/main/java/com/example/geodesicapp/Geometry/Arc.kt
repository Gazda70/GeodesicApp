package com.example.geodesicapp.Geometry

import com.example.geodesicapp.Measurements.Point

class Arc(private var angle:Double, private var points:List<Point>,
          color:Int, nextPrimitive: Primitive, style:Int, thickness:Int)
            :Primitive(color,nextPrimitive, style,thickness) {

    override fun drawShape():Unit{

    }

    fun getAngle():Double{

        return 0.0
    }

    fun getPoints():List<Point>{

        return this.points
    }

    fun setAngle(newAngle:Double):Unit{


    }

    fun setPoints(newPoints:List<Point>):Unit{


    }
}