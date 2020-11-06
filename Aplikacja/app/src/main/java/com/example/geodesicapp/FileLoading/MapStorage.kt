package com.example.geodesicapp.FileLoading

import android.graphics.*
import android.widget.ImageView
import org.kabeja.dxf.DXFDocument
import java.awt.Graphics
import java.awt.Graphics2D
import java.awt.Image
import java.awt.image.BufferedImage


class MapStorage(private var graphics:Canvas?, private var KabejaDocument: DXFDocument?) {

companion object{
    private var _instance : MapStorage? = null

    var instance:MapStorage
        get() {
            if(_instance==null){
                _instance = MapStorage(null, null)
            }
            return _instance!!
        }
        set(value) {}

}

    fun getDX():Unit{

    }

    fun getGraphics(): Canvas? {

        return this.graphics
    }

    fun getKabejaDocument():DXFDocument?{
        return KabejaDocument
    }

    fun setKabejaDocument(document:DXFDocument):Unit{
        KabejaDocument = document
    }

    fun setGraphics(newTargetGraphics: Canvas){
        graphics = newTargetGraphics
    }

}