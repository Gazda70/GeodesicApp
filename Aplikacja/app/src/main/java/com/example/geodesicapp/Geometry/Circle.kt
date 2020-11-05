package com.example.geodesicapp.Geometry

import com.example.geodesicapp.Measurements.Point

class Circle(private var center:Point, private var radius:Int,
             color:Int, nextPrimitive: Primitive, style:Int, thickness:Int)
    :Primitive(color,nextPrimitive, style,thickness) {

    override fun drawShape() {
        TODO("Not yet implemented")
    }

    fun getCenter():Point{

        return this.center
    }

    fun getRadius():Int{

        return this.radius
    }

    fun setCenter(newCenter:Point):Unit{


    }

    fun setRadius(newRadius:Int):Unit{


    }
}