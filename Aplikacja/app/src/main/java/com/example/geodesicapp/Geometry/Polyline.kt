package com.example.geodesicapp.Geometry

import android.graphics.Path
import com.example.geodesicapp.Measurements.Line
import com.example.geodesicapp.Measurements.Point

/**
 * Klasa prymitywu reprezentującego polilinię.
 * @property lines linie tworzące polilinię.
 * @property color kolor, jaki ma zostać użyty do rysowania polilinii.
 * @property nextPrimitive kolejny prymityw w łańcuchu zobowiązań.
 * @property style styl rysowania polilinii.
 * @property thickness gruność rysowanej polilinii.
 */
class Polyline(private var lines: Line, color:Int,
               nextPrimitive: Primitive, style:Int, thickness:Int)
    :Primitive(color,nextPrimitive, style,thickness)
{

    /**
     * Metoda rysująca polilinię.
     */
    override fun drawShape() {
        TODO("Not yet implemented")
    }

    /**
     * Metoda udostępniająca linie tworzące polilinię.
     * @return linie tworzące polilinię.
     */
    fun getLines():Line{

        return this.lines
    }

    /**
     * Metoda ustawiająca linie tworzące polilinię.
     * @return nowe linie tworzące polilinię.
     */
    fun setLines(newLines:Line):Unit{

    }
}