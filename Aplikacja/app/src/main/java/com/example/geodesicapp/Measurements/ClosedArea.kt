package com.example.geodesicapp.Measurements

/**
 * Klasa reprezentująca pomiar zamknętego obszaru.
 * @property comment komentarz do pomiaru.
 * @property measurementType informacja o typie dokonanego pomiaru
 * @property photoPath ścieżka do pliku z obrazem dołączonym do pomiaru.
 * @property points lista punktów tworzących obszar zamknięty.
 */
class ClosedArea(comment:String, measurementType:String,
                 photoPath:String, private var points:List<Point>)
                :Measurement(comment, measurementType, photoPath){

    /**
     * Metoda rysująca obszar zamknięty.
     */
    override fun draw() {
        TODO("Not yet implemented")
    }

    /**
     * Metoda udostępniająca punkty obszaru.
     * @return lista punktów tworzących obszar zamknięty.
     */
    fun getPoints():List<Point>{

        return this.points
    }

    /**
     * Metoda ustawiająca punkty obszaru.
     * @param newPoints nowa lista punktów tworzących obszar zamknięty.
     */
    fun setPoints(newPoints:List<Point>):Unit{

    }
}