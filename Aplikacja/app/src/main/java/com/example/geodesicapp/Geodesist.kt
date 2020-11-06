package com.example.geodesicapp

import com.example.geodesicapp.FileLoading.FileLoaderKabeja
import com.example.geodesicapp.MapShowing.ShowMap
import com.example.geodesicapp.MeasurementManager.MeasurementManager

/**
 * Klasa obsługująca główny interfejs modelu aplikacji geodezyjnej.
 * @param kabeja obiekt obsługujący dokumenty biblioteki Kabeja.
 * @param showMap obiekt obsługujący wyświetlanie mapy.
 * @param measurementManager obiekt obsługujący pomiary.
 */
class Geodesist(kabeja: FileLoaderKabeja, showMap: ShowMap, measurementManager: MeasurementManager) {

    /**
     * Metoda obsługująca dodawanie pomiaru przez użytkownika.
     * @return true, gdy użytkownik poprawnie dokonał pomiaru.
     */
    fun addMeasure():Boolean{

        return false
    }

    /**
     * Metoda obsługująca ładowanie mapy.
     * @return true, gdy mapa została poprawnie załadowana.
     */
    fun loadMap():Boolean{

        return false
    }

    /**
     * Metoda obsługująca wbieranie używanej mapy.
     */
    fun useMap():Unit{

    }
}