package com.example.geodesicapp.Geometry

import android.graphics.Path
import com.example.geodesicapp.Measurements.Line
import com.example.geodesicapp.Measurements.Point

class Polyline(private var lines: Line, color:Int,
               nextPrimitive: Primitive, style:Int, thickness:Int)
    :Primitive(color,nextPrimitive, style,thickness)
{

    override fun drawShape() {
    }

    fun getLines():Line{

        return this.lines
    }

    fun setLines(newLines:Line):Unit{

    }
}