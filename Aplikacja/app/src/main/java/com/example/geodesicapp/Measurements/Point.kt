package com.example.geodesicapp.Measurements

import com.example.geodesicapp.Coordinates.Coordinates

/**
 * Klasa reprezentująca pomiar punktu.
 * @property comment komentarz do pomiaru.
 * @property measurementType informacja o typie dokonanego pomiaru
 * @property photoPath ścieżka do pliku z obrazem dołączonym do pomiaru.
 * @property pairOfCoordinates koordynaty określające położenie punktu.
 */
class Point(comment:String, measurementType:String,
            photoPath:String,private var pairOfCoordinates: Coordinates)
    :Measurement(comment, measurementType, photoPath){

    /**
     * Metoda rysująca punkt.
     */
    override fun draw():Unit{

    }

    /**
     * Metoda udostępniająca koordynaty punktu.
     * @return koordynaty określające położenie punktu.
     */
    fun getCoordinates(): Coordinates {

        return this.pairOfCoordinates
    }

    /**
     * Metoda ustawiająca koordynaty punktu.
     * @param newCoords nowe koordynaty określające położenie punktu.
     */
    fun setCoordinates(newCoords: Coordinates):Unit{

    }
}