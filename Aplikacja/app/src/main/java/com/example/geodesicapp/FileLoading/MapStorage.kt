package com.example.geodesicapp.FileLoading

import android.graphics.*
import org.kabeja.dxf.DXFDocument
import java.awt.Graphics
import java.awt.Graphics2D
import java.awt.Image
import java.awt.image.BufferedImage


class MapStorage(private var graphics:Graphics, private var KabejaDocument: DXFDocument) {

companion object{
    var instanc : MapStorage? = null

    var Instance:MapStorage
        get() {
            return instanc!!
        }
        set(value) {}

}

    fun getDX():Unit{

    }

    fun getGraphics(): Graphics {

        return this.graphics
    }

    fun getKabejaDocument():DXFDocument{
        return DXFDocument()
    }

    fun setKabejaDocument(document:DXFDocument):Unit{

    }

}