package com.example.geodesicapp.Geometry

import com.example.geodesicapp.Measurements.Point

class Ellipse(private var points:List<Point>,
              color:Int, nextPrimitive: Primitive, style:Int, thickness:Int)
    :Primitive(color,nextPrimitive, style,thickness) {

    override fun drawShape() {
        TODO("Not yet implemented")
    }

    fun getPoints():List<Point>{

        return this.points
    }

    fun setPoints(newPoints:Point){

    }
}