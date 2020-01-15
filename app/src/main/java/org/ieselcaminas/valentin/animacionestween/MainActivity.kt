package org.ieselcaminas.valentin.animacionestween

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button_dontTouch: Button = findViewById(R.id.button_DoNotTouch) as Button
        val text_translate: TextView = findViewById(R.id.textView3) as TextView
        var dontTouchBool = true
        var translateUp = false

        button_dontTouch.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {

                if (dontTouchBool) {
                    val animation: Animation = AnimationUtils.loadAnimation(this@MainActivity, R.anim.temblor)
                    button_dontTouch.startAnimation(animation)
                    button_dontTouch.text = "AHORA YA PUEDES TOCAR !"
                    dontTouchBool = false
                } else if (!dontTouchBool) {

                    if (translateUp) {
                        button_dontTouch.text = "ESTRELLA Y BARRAS DE PROGRESO!!!"
                        val animation: Animation = AnimationUtils.loadAnimation(this@MainActivity, R.anim.translateabajo)
                        text_translate.startAnimation(animation)
                        text_translate.visibility = View.INVISIBLE
                        translateUp = false

                    } else if(!translateUp) {
                        val animation: Animation = AnimationUtils.loadAnimation(this@MainActivity, R.anim.translate)
                        text_translate.startAnimation(animation)
                        text_translate.visibility = View.VISIBLE

                    }
                }
            }
        })
    }
}
