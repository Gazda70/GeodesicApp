package com.example.geodesicapp.Measurements


/**
 * Abstrajcyjna klasa reprezentująca pomiar.
 * @property comment komentarz do pomiaru.
 * @property measurementType informacja o typie dokonanego pomiaru
 * @property photoPath ścieżka do pliku z obrazem dołączonym do pomiaru.
 */
abstract class Measurement(private var comment:String, private var measurementType:String,
                    private var photoPath:String){

    /**
     * Abstrakcyjna metoda pozwalająca klasie pochodnej na odpowiednie zdefiniowanie metody rysowania pomiaru.
     */
    abstract  fun draw():Unit

    /**
     * Metoda udostępniająca komentarz.
     * @return komentarz do pomiaru.
     */
    fun getComment():String{

        return String()
    }

    /**
     * Metoda udostępniająca typ pomiaru.
     * @return informacja o typie pomiaru.
     */
    fun getMeasurementType():String{

        return String()
    }

    /**
     * Metoda udostępniająca plik z obrazem.
     * @return ścieżka do pliku z obrazem dołączonym do pomiaru.
     */
    fun getPhotoPath():String{

        return String()
    }

    /**
     * Metoda pozwalająca uzyskać koordynaty pomiaru.
     */
    fun obtainCoordinates():Unit{

    }

    /**
     * Metoda ustawiająca komentarz.
     * @param comment nowy komentarz do pomiaru.
     */
    fun setComment(comment:String):Unit{

    }

    /**
     * Metoda ustawiająca typ pomiaru.
     * @param type nowy typ pomiaru.
     */
    fun setMeasurementType(type:String):Unit{

    }

    /**
     * Metoda ustawiająca plik z obrazem.
     * @param path nowa ścieżka do pliku z obrazem dołączonym do pomiaru.
     */
    fun setPhotoPath(path:String):Unit{

    }
}