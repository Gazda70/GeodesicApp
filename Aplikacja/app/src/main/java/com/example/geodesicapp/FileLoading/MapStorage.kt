package com.example.geodesicapp.FileLoading

import android.graphics.*
import android.widget.ImageView
import org.kabeja.dxf.DXFDocument

/**
 * Klasa typu singleton przechowująca mapę w postaci dokumentu biblioteki Kabeja i odpowiedni cel na którym będzie rysowana.
 * @property graphics Obraz, na którym może zostać narysowana mapa, tak by została wyświetlona.
 * @property KabejaDocument Dokument biblioteki Kabeja przechowujący dane z pliku DXF.
 * @constructor Tworzy obiekt przechowujący mapę, który będzie statycznie przechowywany. Początkowo wartości mogą być puste.
 */
class MapStorage(private var graphics:Canvas?, private var KabejaDocument: DXFDocument?) {

companion object{
    /**
     * Pole przechowujące instancję singletonu.
     */
    private var _instance : MapStorage? = null

    /**
     * Własność pozwalająca na dostęp do instancji tak by zachować zachowanie singletonu.
     */
    var instance:MapStorage
        get() {
            if(_instance==null){
                _instance = MapStorage(null, null)
            }
            return _instance!!
        }
        set(value) {}

}

    /**
     * Ponownie ładuje dane z pliku DXF. Pozwala to na odświeżenie już otwartego pliku.
     */
    fun getDX():Unit{

    }

    /**
     *  Metoda udostępniająca miejsce do rysowania mapy.
     *  @return Obraz, na którym może zostać narysowana mapa, tak by została wyświetlona.
     *  @return null, gdy nie miejsce nie zostało ustawione.
     */
    fun getGraphics(): Canvas? {

        return this.graphics
    }

    /**
     * Metoda udostępniająca dokument biblioteki Kabeja.
     * @return Dokument biblioteki Kabeja.
     * @return null, gdy dokument nie został ustawiony.
     */
    fun getKabejaDocument():DXFDocument?{
        return KabejaDocument
    }

    /**
     * Metoda ustawiająca dokument biblioteki Kabeja.
     * @param document dokument biblioteki Kabeja, który ma zostać ustawiony jako używany.
     */
    fun setKabejaDocument(document:DXFDocument):Unit{
        KabejaDocument = document
    }

    /**
     * Metoda ustawiająca miejsce do rysowania mapy.
     * @param newTargetGraphics Obraz, na którym może zostać narysowana mapa, który ma zostać ustawiony jako używany.
     */
    fun setGraphics(newTargetGraphics: Canvas){
        graphics = newTargetGraphics
    }

}