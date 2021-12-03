package ru.ndevelop.mechetapp.ui.mechet

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

import ru.ndevelop.mechetapp.R
import ru.ndevelop.mechetapp.tools.MechetType


class MechetInfoActivity : AppCompatActivity(), View.OnClickListener {
    private var mechetId = 0
    private lateinit var mechetImage: ImageView
    private lateinit var mechetName: TextView
    private lateinit var mechetDescription: TextView
    private lateinit var videoView: VideoView
    private lateinit var startButton: Button
    private lateinit var stopButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_mechet_info)
        val b = intent.extras
        if (b != null) mechetId = b.getInt("mechetId")
        mechetImage = findViewById(R.id.iv_mechet)
        startButton = findViewById(R.id.btn_start)
        stopButton = findViewById(R.id.btn_pause)
        videoView = findViewById(R.id.vv_mechet)
        startButton.setOnClickListener(this)
        stopButton.setOnClickListener(this)
        mechetImage.setImageResource(MechetType.values()[mechetId].image)
        mechetName = findViewById(R.id.tv_mechet_name)
        mechetName.text = MechetType.values()[mechetId].mechetName
        mechetDescription = findViewById(R.id.tv_mechet_description)
        mechetDescription.text = resources.getText(MechetType.values()[mechetId].decription)
        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)
        if(MechetType.values()[mechetId]!=MechetType.KUL_SHARIF)  {
            videoView.setVideoPath(MechetType.values()[mechetId].link)
            videoView.setMediaController(mediaController)
            videoView.requestFocus()
            videoView.setOnPreparedListener {
                Toast.makeText(this,"Видео загружено!",Toast.LENGTH_LONG).show()
                //  it.isLooping = true
            }
            videoView.setOnCompletionListener {
                // videoView.pause()
                videoView.seekTo(0)
            }
        }
        else{
            videoView.visibility = View.GONE
            startButton.visibility = View.GONE
            stopButton.visibility = View.GONE
        }




    }

    override fun onClick(view: View) {
        when (view) {
            startButton -> {
              videoView.start()



            }
            stopButton -> videoView.pause()
        }
    }
}