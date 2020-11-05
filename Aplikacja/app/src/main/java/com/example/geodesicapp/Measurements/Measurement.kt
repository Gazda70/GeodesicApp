package com.example.geodesicapp.Measurements

abstract class Measurement(private var comment:String, private var measurementType:String,
                    private var photoPath:String){

    abstract  fun draw():Unit

    fun getComment():String{

        return String()
    }

    fun getMeasurementType():String{

        return String()
    }

    fun getPhotoPath():String{

        return String()
    }

    fun obtainCoordinates():Unit{

    }

    fun setComment(comment:String):Unit{

    }

    fun setMeasurementType(type:String):Unit{

    }

    fun setPhotoPath(path:String):Unit{

    }
}