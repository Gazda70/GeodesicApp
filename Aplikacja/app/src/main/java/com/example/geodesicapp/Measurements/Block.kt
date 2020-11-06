package com.example.geodesicapp.Measurements

import com.example.geodesicapp.Geometry.Primitive

/**
 * Klasa reprezentująca pomiar bloku.
 * @property comment komentarz do pomiaru.
 * @property measurementType informacja o typie dokonanego pomiaru
 * @property photoPath ścieżka do pliku z obrazem dołączonym do pomiaru.
 * @property pivot punkt piwotalny danego pomiaru.
 * @property primitive lista prymitywów potrzebnych do graficznego przedstawienia pomiaru.
 */
class Block(comment:String, measurementType:String,
            photoPath:String, private var pivot:Point, private var primitive:List<Primitive>)
    :Measurement(comment, measurementType, photoPath) {

    /**
     * Metoda rysująca blok
     */
    override fun draw():Unit{

    }

    /**
     * Metoda udostępniająca punkt piwotalny.
     * @return punkt piwotalny pomiaru.
     */
    fun getPivot():Point{

        return this.pivot
    }

    /**
     * Metoda udostępniająca prymitywy pomiaru.
     * @return lista prymitywów potrzebnych do graficznego przedstawienia pomiaru.
     */
    fun getPrimitive():List<Primitive>{

        return this.primitive
    }

    /**
     * Metoda ustawiająca punkt piwotalny.
     * @param newPivot nowy punkt piwotalny pomiaru.
     */
    fun setPivot(newPivot:Point):Unit{

    }

    /**
     * Metoda ustawiająca prymitywy pomiaru.
     * @param newPrimitive nowa lista prymitywów potrzebnych do graficznego przedstawienia pomiaru.
     */
    fun setPrimitive(newPrimitive:List<Primitive>):Unit{


    }
}