package com.example.geodesicapp



import com.example.geodesicapp.Coordinates.Coordinates
import com.example.geodesicapp.Coordinates.GeodesicCoordinates
import com.example.geodesicapp.Coordinates.GeographicCoordinates
import com.example.geodesicapp.FileLoading.FileLoaderKabeja
import com.example.geodesicapp.FileLoading.MapStorage
import com.example.geodesicapp.MapShowing.ShowMap
import com.example.geodesicapp.MeasurementManager.MeasurementManager
import com.example.geodesicapp.Measurements.Line
import com.example.geodesicapp.Measurements.Measurement
import com.example.geodesicapp.Measurements.Point

/**
 * Klasa obsługująca główny interfejs modelu aplikacji geodezyjnej.
 * @param fileLoader obiekt obsługujący dokumenty biblioteki Kabeja.
 * @param mapShow obiekt obsługujący wyświetlanie mapy.
 * @param measurementManager obiekt obsługujący pomiary.
 */
class Geodesist(private var measurementManager: MeasurementManager,
                private var fileLoader: FileLoaderKabeja, private var mapShow:ShowMap) {

    /**
     * Metoda obsługująca dodawanie pomiaru przez użytkownika.
     * @return true, gdy użytkownik poprawnie dokonał pomiaru.
     */
    fun addMeasure():Boolean{
        //Testowy pomiar.
        val startX = 6548214.0
        val startY = 5573136.0
        val endX = 6548240.0
        val endY = 5572998.0
        measurementManager.add(Line("", "", "",  listOf(Point("", "", "", Coordinates(
            GeodesicCoordinates(0.0, startX, startY),
            GeographicCoordinates(100.0, 600.0)
        )
        ),
            Point("", "", "", Coordinates(
                GeodesicCoordinates(0.0, endX, endY),
                GeographicCoordinates(600.0, 600.0)
            )
            )))
        )
        return true
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
        this.mapShow.showCurrentLocation()
    }
}
