package br.com.yuriduarte.viagens

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.MediaController
import android.widget.VideoView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class TelaVamosViajar : AppCompatActivity() {

    lateinit var videoTransporte : VideoView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tela_vamos_viajar)

        videoTransporte = findViewById(R.id.videoView)

        val transporte = intent.getStringExtra("transporte").toString()

        var packageName = "android.resource://" + getPackageName() + "/"

        if(transporte == "Ônibus"){
            packageName += R.raw.saida_busao

        }
        else{
            packageName += R.raw.decolagem_aviao
        }

        val uri = Uri.parse(packageName)

        videoTransporte.setVideoURI(uri)

        val mediaController = MediaController(this)

        videoTransporte.setMediaController(mediaController)

        videoTransporte.setOnPreparedListener {
            videoTransporte.start()
        }

        videoTransporte.setOnCompletionListener {
            finishAndRemoveTask()
        }

    }
}