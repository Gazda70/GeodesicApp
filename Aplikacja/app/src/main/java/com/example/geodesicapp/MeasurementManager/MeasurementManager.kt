package com.example.geodesicapp.MeasurementManager

import com.example.geodesicapp.Coordinates.Coordinates
import com.example.geodesicapp.FileLoading.MapStorage
import com.example.geodesicapp.Measurements.Measurement

/**
 * Klasa obsługująca pomiary.
 * @property measurement lista pomiarów obslugiwanych przez obiekt.
 */
class MeasurementManager(private var measurement:MutableList<Measurement>,
                        currentMap: MapStorage
) {

    /**
     * Metoda dodająca pomiar.
     * @param newMeasurement nowy pomiar do dodania.
     * @return true, gdy dodanie pomiaru powiodło się.
     */
    fun add(newMeasurement: Measurement):Boolean{
        var toReturn = true
        try {
            newMeasurement.draw()
            measurement.add(newMeasurement)
        }catch(e:Exception){
            toReturn = false
        }
        return toReturn
    }

    /**
     * Metoda dodająca dodatkowe informacje o pomiarze.
     */
    fun addOptionalInfo():Unit{

    }

    /**
     * Metoda pozwalająca wybrać pomiar.
     * @return true, gdy poprawnie wybrano pomiar.
     */
    fun choosePointOrBlock():Boolean{

        return false
    }

    /**
     * Metoda usuwająca pomiar znajdujący się w pobliżu podanych koordynatów.
     * @param toDelete koordynaty pomiaru do usunięcia.
     */
    fun delete(toDelete: Coordinates):Unit{

    }

    /**
     * Metoda wywołująca rysowanie przechowywanych pomiarów.
     */
    fun drawData():Unit{
        for(m in measurement){
            m.draw()
        }
    }

    /**
     * Funkcja obsługująca zakończenie pomiaru.
     * @return true, gdy poprawnie wykonano pomiar.
     * @return false, gdy wystąpił błąd przy pomiarze.
     */
    fun end():Boolean{

        return false
    }

    /**
     * Metoda modyfikująca pomiar znajdujący się w pobliżu podanych koordynatów.
     * @param toModify koordynaty pomiaru do modyfikacji.
     */
    fun modify(toModify: Coordinates):Unit{

    }
}
