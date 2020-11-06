package com.example.geodesicapp.Geometry

import com.example.geodesicapp.Measurements.Point


/**
 * Klasa prymitywu reprezentującego okrąg.
 * @property center Punkt położenia środka okręgu.
 * @property radius Promień okręgu.
 * @property color kolor, jaki ma zostać użyty do rysowania okrąg.
 * @property nextPrimitive kolejny prymityw w łańcuchu zobowiązań.
 * @property style styl rysowania okręgu.
 * @property thickness gruność rysowanego okręgu.
 */
class Circle(private var center:Point, private var radius:Int,
             color:Int, nextPrimitive: Primitive, style:Int, thickness:Int)
    :Primitive(color,nextPrimitive, style,thickness) {

    /**
     * Metoda rysująca okrąg.
     */
    override fun drawShape() {
        TODO("Not yet implemented")
    }

    /**
     * Metoda udostępniająca ustawiony środek okręgu.
     * @return ustawiony środek okręgu.
     */
    fun getCenter():Point{

        return this.center
    }

    /**
     * Metoda udostępniająca ustawiony promień okręgu.
     * @return ustawiony promień okręgu.
     */
    fun getRadius():Int{

        return this.radius
    }

    /**
     * Metoda ustawiająca środek okręgu.
     * @param newCenter nowy środek okręgu.
     */
    fun setCenter(newCenter:Point):Unit{


    }

    /**
     * Metoda ustawiająca promień okręgu.
     * @param newRadius nowy promień okręgu.
     */
    fun setRadius(newRadius:Int):Unit{


    }
}