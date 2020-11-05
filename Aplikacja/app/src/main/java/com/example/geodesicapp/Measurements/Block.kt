package com.example.geodesicapp.Measurements

import com.example.geodesicapp.Geometry.Primitive

class Block(comment:String, measurementType:String,
            photoPath:String, private var pivot:Point, private var primitive:List<Primitive>)
    :Measurement(comment, measurementType, photoPath) {

    override fun draw():Unit{

    }

    fun getPivot():Point{

        return this.pivot
    }

    fun getPrimitive():List<Primitive>{

        return this.primitive
    }

    fun setPivot(newPivot:Point):Unit{

    }

    fun setPrimitive(newPrimitive:List<Primitive>):Unit{


    }
}