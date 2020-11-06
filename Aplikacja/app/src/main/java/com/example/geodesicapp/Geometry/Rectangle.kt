package com.example.geodesicapp.Geometry

import com.example.geodesicapp.Measurements.Point

/**
 * Klasa prymitywu reprezentującego prostokąt.
 * @property points lista punktów pozwalająca na określenie początku i końca obszaru rysowania prostokąta.
 * @property color kolor, jaki ma zostać użyty do rysowania prostokąta.
 * @property nextPrimitive kolejny prymityw w łańcuchu zobowiązań.
 * @property style styl rysowania prostokąta.
 * @property thickness gruność rysowanego prostokąta.
 */
class Rectangle(private var points:List<Point>,
                color:Int, nextPrimitive: Primitive, style:Int, thickness:Int)
    :Primitive(color,nextPrimitive, style,thickness) {

    /**
     * Metoda rysująca prostokąt.
     */
    override fun drawShape() {
        TODO("Not yet implemented")
    }

    /**
     * Metoda udostępniająca punkty tworzące prostokąt.
     * @return lista punktów tworzących prostokąt.
     */
    fun getPoints():List<Point>{

        return this.points
    }

    /**
     * Metoda ustawiająca punkty tworzące prostokąt.
     * @param newPoints nowa lista punktów tworzących prostokąt.
     */
    fun setPoints(newPoints:Point){

    }
}