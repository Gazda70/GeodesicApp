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

class ShowMap(private var currentUserLocation: Coordinates,
              private var mapLocation: Coordinates,
                private var currentMap: MapStorage
                ) {

    lateinit var manager: MeasurementManager
    var measurements:MutableList<Measurement> = mutableListOf()
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

    fun isUserOutsideMap(): Boolean {

        return false
    }

    fun moveMap(first: Coordinates, second: Coordinates): Unit {

    }

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
                                GeodesicCoordinates(0.0, line.startPoint.x.toFloat().toDouble() / 100.0F, line.startPoint.y.toFloat().toDouble() / 100.0F),
                                GeographicCoordinates(0.0, 0.0)
                            )
                        )
                    )
                    ourList.add(
                        Point(
                            "", "", "",
                            Coordinates(
                                GeodesicCoordinates(0.0, line.endPoint.x.toFloat().toDouble() / 100.0F, line.endPoint.y.toFloat().toDouble() / 100.0F),
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

        fun showMeasurementData(): String {

            return String()
        }

        fun userChoiceMap(): Unit {

        }

        fun zoomInOrOut(first: Coordinates, second: Coordinates): Unit {

        }
    }
}