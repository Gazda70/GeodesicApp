package com.example.geodesicapp.FileLoading

import org.kabeja.dxf.DXFDocument
import org.kabeja.parser.DXFParser
import org.kabeja.parser.Parser
import org.kabeja.parser.ParserBuilder
import java.io.FileInputStream
import java.io.InputStream

/**
 * Klasa ładująca i zapisująca plik DXF korzystając dokumentu biblioteki Kabeja.
 * @property FileName nazwa pliku, z którego będzie ładowana mapa.
 * @property imageHeight wysokość ładowanego obrazu.
 * @property imageWidth szerokość ładowanego obrazu.
 * @property mapSave obiekt przechowujący odczytaną z pliku mapę.
 */
class FileLoaderKabeja(private var FileName:String, private var imageHeight:Int,
                        private var imageWidth:Int,
                       private var mapSave:MapStorage?)
{
    /**
     * Metoda ustawiająca ścieżkę pliku wejściowego.
     * @param fileURL nowa ścieżka.
     */
    fun choseFileSource(fileURL:String){
        this.FileName = fileURL
    }

    /**
     * Metoda odczytująca dane z ustawioengo pliku wejściowego.
     * @param source Strumień źródłowy. Z niego będą odczytane dane.
     */
    fun loadFileFromSource(source:InputStream){
        val parser: Parser = ParserBuilder.createDefaultParser()
        parser.parse(source, DXFParser.DEFAULT_ENCODING)
        val doc: DXFDocument = parser.document
        mapSave?.setKabejaDocument(doc)
    }

    /**
     * Metoda zapisująca mape w podanej lokalizacji.
     * @param saveURL ścieżka zapisu pliku.
     * @return true, gdy zapis się udał.
     */
    fun saveFile(saveURL:String):Boolean{

        return false
    }

    /**
     * Metoda ustawiająca wybrany plik jako aktywną mapę.
     * @return true, gdy zapis się udał.
     */
    fun setAsCurrentMap():Boolean{

        return false
    }

    /**
     * Metoda informująca o pozycji wybranej przez użytkownika mapy
     * @return Pozycja mapy w polu wyboru.
     */
    fun userChoiceMap():Int{

        return 0
    }

}