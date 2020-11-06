package com.example.geodesicapp.MapShowing

import com.example.geodesicapp.Coordinates.Coordinates
import com.example.geodesicapp.Coordinates.GeodesicCoordinates
import com.example.geodesicapp.Coordinates.GeographicCoordinates
import com.example.geodesicapp.FileLoading.MapStorage

/**
 * Klasa odpowiedzialna za odpowiednie przetworzenie danych użytkownika, by mapa była odpowiednio wyświetlana.
 * @property currentMap koordynaty użytkownika.
 * @property mapLocation koordynaty położenia mapy.
 * @property currentMap akturalnie przetwarzana mapa.
 */
class ShowMap(private var currentUserLocation: Coordinates,
              private var mapLocation: Coordinates,
                private var currentMap: MapStorage
                ) {

    /**
     * Metoda udostępniająca aktualne koordynaty użytkownika.
     * @return aktualnie ustawione koordynaty użytkownika.
     */
    fun checkCurrentUserLocation(): Coordinates {

        return Coordinates(
            GeodesicCoordinates(
                0.0,
                0.0,
                0.0
            ),
            GeographicCoordinates(0.0, 0.0)
        )
    }

    /**
     * Metoda sprawdzająca czy użytkownik wyszedł poza obszary określany przez mapę.
     * @return true, gdy użytkownik jest poza mapą.
     */
    fun isUserOutsideMap():Boolean{

        return false
    }

    /**
     * Przesunięcie mapy
     * @param first koordynaty, względem, których zostanie wykonane przesunięcie.
     * @param second koordynaty, do których zostanie przesunięta mapa.
     */
    fun moveMap(first: Coordinates, second: Coordinates):Unit{

    }

    /**
     * Metoda wywołująca pokazanie aktualnej pozycji użytkownika na ekranie.
     */
    fun showCurrentLocation():Unit{

    }

    /**
     * Zwraca i pokazuje dane o aktualnych pomiarach.
     * @return informacje o aktualnie przeprowadzonych pomiarach.
     */
    fun showMeasurementData():String{

        return String()
    }

    /**
     * Metoda obsługująca wybór mapy przez użytkownika.
     */
    fun userChoiceMap():Unit{

    }

    /**
     * Metoda przybliżająca i oddalająca mapę zgodnie z podanymi koordynatami
     * @param first koordynaty, względem, których zostanie wykonane przybliżenie lub oddalenie.
     * @param second koordynaty, określające jak bardzo mapa zostania przybliżona lub oddalona.
     */
    fun zoomInOrOut(first: Coordinates, second: Coordinates):Unit{

    }
}