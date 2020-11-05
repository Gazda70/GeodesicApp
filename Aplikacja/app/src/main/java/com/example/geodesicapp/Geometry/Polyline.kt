package com.example.geodesicapp.Geometry

import com.example.geodesicapp.Measurements.Point
import javax.sound.sampled.Line

class Polyline(private var lines: Line, color:Int,
               nextPrimitive: Primitive, style:Int, thickness:Int)
    :Primitive(color,nextPrimitive, style,thickness)
{

    override fun drawShape() {
        TODO("Not yet implemented")
    }

    fun getLines():Line{

        return this.lines
    }

    fun setLines(newLines:Line):Unit{

    }
}