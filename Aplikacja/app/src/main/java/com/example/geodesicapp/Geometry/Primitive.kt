package com.example.geodesicapp.Geometry

/**
 * Abstrakcyjna klasa prymitywu.
 * @property color kolor, jaki ma zostać użyty do rysowania prymitywu.
 * @property nextPrimitive kolejny prymityw w łańcuchu zobowiązań.
 * @property style styl rysowania prymitywu.
 * @property thickness gruność rysowanego prymitywu.
 */
abstract class Primitive(protected var color:Int, protected var nextPrimitive: Primitive,
                protected var style:Int, protected var thickness:Int) {

    /**
     * Abstrakcyjna metoda pozwalająca klasie pochodnej na odpowiednie zdefiniowanie metody rysowania.
     */
    abstract fun drawShape():Unit

    /**
     * Metoda ustawiająca kolejny prymityw łańcucha prymitywów.
     */
    fun setNextShape():Unit{

    }
}