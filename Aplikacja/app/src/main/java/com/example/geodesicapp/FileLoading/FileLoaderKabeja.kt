package com.example.geodesicapp.FileLoading

import org.kabeja.dxf.DXFDocument
import org.kabeja.parser.DXFParser
import org.kabeja.parser.Parser
import org.kabeja.parser.ParserBuilder
import java.io.FileInputStream
import java.io.InputStream

class FileLoaderKabeja(private var FileName:String, private var imageHeight:Int,
                        private var imageWidth:Int,
                       private var mapSave:MapStorage?)
{

    fun choseFileSource(fileURL:String){
        this.FileName = fileURL
    }

    fun loadFileFromSource(source:InputStream){
        val parser: Parser = ParserBuilder.createDefaultParser()
        parser.parse(source, DXFParser.DEFAULT_ENCODING)
        val doc: DXFDocument = parser.document
        mapSave?.setKabejaDocument(doc)
    }

    fun saveFile(saveURL:String):Boolean{

        return false
    }

    fun setAsCurrentMap():Boolean{

        return false
    }

    fun userChoiceMap():Int{

        return 0
    }

}