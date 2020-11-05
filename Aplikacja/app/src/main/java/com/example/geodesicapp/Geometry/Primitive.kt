package com.example.geodesicapp.Geometry

abstract class Primitive(protected var color:Int, protected var nextPrimitive: Primitive,
                protected var style:Int, protected var thickness:Int) {

    abstract fun drawShape():Unit

    fun setNextShape():Unit{

    }
}