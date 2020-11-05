package com.example.geodesicapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.geodesicapp.FileLoading.FileLoaderKabeja
import com.example.geodesicapp.FileLoading.MapStorage
import java.io.FileInputStream
import java.io.InputStream
import java.nio.charset.StandardCharsets

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var docu = FileLoaderKabeja("",50,50, null )
        docu.loadFileFromSource(resources.openRawResource(R.raw.mapa))
    }

}