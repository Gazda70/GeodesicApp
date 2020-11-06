package com.example.geodesicapp.Coordinates


/**
 * Klasa przechowująca koordynaty geodezyjne.
 * @property heigthH Wysokość geodezyjna.
 * @property lengthL Długość geodezyjna.
 * @property widthB Szerokość geodezyjna.
 */
class GeodesicCoordinates(private var heigthH:Double, private var lengthL:Double,
                            private var widthB:Double)
{
    /**
     * Metoda zwracająca koordynaty w postaci krotki.
     * @return Krotka zawierająca na kolejnych pozycjach wysokość, długość, szerokość
     */
    fun getCoordinates() : Triple<Double, Double, Double>{

        return Triple<Double, Double, Double>(heigthH, lengthL, widthB)
    }

    /**
     * Metoda ustawiająca nowe koordynaty
     * @param newHeigthH nowa wysokość.
     * @param newLengthL nowa długość.
     * @param newWidthB nowa szerokość.
     */
    fun setCoordinates(newHeigthH:Double, newLengthL:Double, newWidthB:Double):Unit{

    }
}