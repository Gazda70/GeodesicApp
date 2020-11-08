package com.example.geodesicapp.MapShowing

import com.example.geodesicapp.Coordinates.Coordinates
import com.example.geodesicapp.Coordinates.GeodesicCoordinates
import com.example.geodesicapp.Coordinates.GeographicCoordinates
import com.example.geodesicapp.FileLoading.MapStorage
import com.example.geodesicapp.MeasurementManager.MeasurementManager
import com.example.geodesicapp.Measurements.Line
import com.example.geodesicapp.Measurements.Measurement
import com.example.geodesicapp.Measurements.Point
import org.kabeja.dxf.DXFConstants
import org.kabeja.dxf.DXFLayer
import org.kabeja.dxf.DXFLine

/**
 * Klasa odpowiedzialna za odpowiednie przetworzenie danych użytkownika, by mapa była odpowiednio wyświetlana.
 * @property currentUserLocation koordynaty użytkownika.
 * @property mapLocation koordynaty położenia mapy.
 * @property currentMap akturalnie przetwarzana mapa.
 */
class ShowMap(private var currentUserLocation: Coordinates,
              private var mapLocation: Coordinates,
                private var currentMap: MapStorage
                ) {

    lateinit var manager: MeasurementManager
    var measurements:MutableList<Measurement> = mutableListOf()
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
     * Metoda pokazująca aktualną lokalizację użytkownika na ekranie.
     */
     fun showCurrentLocation(): Unit {
        currentMap.getKabejaDocument()
        currentMap.getGraphics()
        manager = MeasurementManager(measurements, currentMap)

        val i = MapStorage.instance.getKabejaDocument()?.dxfLayerIterator;
        val ourList = mutableListOf<Point>()
        while (i?.hasNext()!!) {
            val layer: DXFLayer = i.next() as DXFLayer;
            // check the lines
            if (layer.hasDXFEntities(DXFConstants.ENTITY_TYPE_LINE)) {
                val l = layer.getDXFEntities(DXFConstants.ENTITY_TYPE_LINE);
                val i = l.iterator();

                while (i.hasNext()) {
                    val line: DXFLine = i.next() as DXFLine;
                    ourList.add(
                        Point(
                            "", "", "",
                            Coordinates(
                                // GeodesicCoordinates(0.0, 0.0, 600.0),
                                GeodesicCoordinates(0.0, (line.startPoint.x-6548159)*10, (line.startPoint.y-5573020)*10),
                                GeographicCoordinates(0.0, 0.0)
                            )
                        )
                    )
                    ourList.add(
                        Point(
                            "", "", "",
                            Coordinates(
                                //   GeodesicCoordinates(0.0, 2500.0, 600.0),
                                GeodesicCoordinates(0.0, (line.endPoint.x-6548159)*10, (line.endPoint.y-5573020)*10),
                                GeographicCoordinates(0.0, 0.0)
                            )
                        )
                    )

                    //dodanie pomiaru do listy Managera
                    manager.add(Line("", "", "", ourList))

                    ourList.clear()
                }
            }
        }
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
