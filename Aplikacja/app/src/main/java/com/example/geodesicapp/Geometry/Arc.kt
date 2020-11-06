package com.example.geodesicapp.Geometry

import com.example.geodesicapp.FileLoading.MapStorage
import com.example.geodesicapp.Measurements.Point

/**
 * Klasa prymitywu reprezentującego łuk.
 * @property angle kąt w stopniach określający jak długi jest łuk.
 * @property points lista punktów zawierających dane o położeniu łuku.
 * @property color kolor, jaki ma zostać użyty do rysowania łuku.
 * @property nextPrimitive kolejny prymityw w łańcuchu zobowiązań.
 * @property style styl rysowania łuku.
 * @property thickness gruność rysowanego łuku.
 */
class Arc(private var angle:Double, private var points:List<Point>,
          color:Int, nextPrimitive: Primitive, style:Int, thickness:Int)
            :Primitive(color,nextPrimitive, style,thickness) {

    /**
     * Metoda rysująca łuk.
     */
    override fun drawShape():Unit{
        TODO("Not yet implemented")
    }

    /**
     * Metoda udostępniająca ustawiony kąt rysowania danego łuku.
     * @return kąt w stopniach, określający aktualną długość łuku.
     */
    fun getAngle():Double{

        return 0.0
    }

    /**
     * Metoda zwracająca liste punktów tworzących łuk.
     * @return lista punktów.
     */
    fun getPoints():List<Point>{

        return this.points
    }

    /**
     * Metoda ustawiająca kąt rysowania danego łuku.
     * @param newAngle kąt w stopniach, określający nową długość łuku.
     */
    fun setAngle(newAngle:Double):Unit{


    }

    /**
     * Metoda ustawiająca liste punktów tworzących łuk.
     * @param newPoints nowa lista punktów tworzących łuk.
     */
    fun setPoints(newPoints:List<Point>):Unit{


    }
}