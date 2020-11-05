package com.example.geodesicapp.Measurements

class ClosedArea(comment:String, measurementType:String,
                 photoPath:String, private var points:List<Point>)
                :Measurement(comment, measurementType, photoPath){

    override fun draw() {
        TODO("Not yet implemented")
    }

    fun getPoints():List<Point>{

        return this.points
    }

    fun setPoints(newPoints:List<Point>):Unit{

    }
}