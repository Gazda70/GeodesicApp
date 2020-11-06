package com.example.geodesicapp.Geometry

import com.example.geodesicapp.Measurements.Point

/**
 * Klasa prymitywu reprezentującego elipsę.
 * @property points lista punktów pozwalająca na określenie początku i końca obszaru rysowania elipsy.
 * @property color kolor, jaki ma zostać użyty do rysowania elipsy.
 * @property nextPrimitive kolejny prymityw w łańcuchu zobowiązań.
 * @property style styl rysowania elipsy.
 * @property thickness gruność rysowanej elipsy.
 */
class Ellipse(private var points:List<Point>,
              color:Int, nextPrimitive: Primitive, style:Int, thickness:Int)
    :Primitive(color,nextPrimitive, style,thickness) {

    /**
     * Metoda rysująca elipsę.
     */
    override fun drawShape() {
        TODO("Not yet implemented")
    }

    /**
     * Metoda udostępniająca punkty tworzące elipsę.
     * @return lista punktów tworzących elipsę.
     */
    fun getPoints():List<Point>{

        return this.points
    }

    /**
     * Metoda ustawiająca punkty tworzące elipsę.
     * @param newPoints nowa lista punktów tworzących elipsę.
     */
    fun setPoints(newPoints:Point){

    }
}