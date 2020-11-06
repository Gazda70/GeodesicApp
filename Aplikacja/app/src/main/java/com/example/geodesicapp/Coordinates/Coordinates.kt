package com.example.geodesicapp.Coordinates

/**
 * Klasa łącząca informacje o koordynatach geograficznych i geodezyjnych.
 * @property Geodesic koordynaty geodezyjne.
 * @property Geographic koordynaty geograficzne.
 * @constructor Ustawia oba rodzaje koordynatów bez przeliczania ich wzajemnie.
 */
class Coordinates(var Geodesic : GeodesicCoordinates,
                  var Geographic : GeographicCoordinates
) {

    /**
     * Metoda przeliczająca przechowywane koordynaty geodezyjne na geograficzne.
     */
    fun geodToGeogr():Unit{

    }
    /**
     * Metoda przeliczająca przechowywane koordynaty geograficzne na geodezyjne.
     */
    fun geogrToGeod():Unit{

    }
}