package com.example.geodesicapp.Coordinates

/**
 * Klasa przechowująca koordynaty geograficzne.
 * @property length Długość geograficzna.
 * @property width Szerokość geograficzna.
 * @constructor Tworzy nowe współrzędne geograficzne. Gdy nie podano wartości są ustawiane na 0.0
 */
class GeographicCoordinates(private var length : Double = 0.0, private var width : Double = 0.0 ) {

    /**
     * Metoda zwracająca koordynaty geograficzne w postaci pary.
     * @return Para zawierająca długość na pierwszej pozycji i szerokość na drugiej.
     */
    fun getCoordinates() : Pair<Double, Double>{
        return Pair<Double,Double>(0.0, 0.0)
    }

    /**
     * Metoda ustawiająca nowe koordynaty geograficzne.
     * @param newLength nowa długość.
     * @param newWidth nowa szerokość.
     */
    fun setCoordinates(newLength:Double, newWidth:Double){

    }
}