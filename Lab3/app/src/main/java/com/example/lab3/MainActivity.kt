package com.example.lab3

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.LinearLayout

import android.content.res.Resources
import android.graphics.Bitmap
import android.net.Uri
import android.provider.MediaStore
import android.util.TypedValue
import android.view.View
import android.widget.Button
import android.widget.HorizontalScrollView
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    private lateinit var imageView: ImageView
    private val REQUEST_IMAGE_CAPTURE = 1

    @SuppressLint("CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_main)

        imageView = findViewById(R.id.imageView)

        val scroll = findViewById<HorizontalScrollView>(R.id.horizontalView)
        val linearLayout1 = findViewById<LinearLayout>(R.id.layout1)
        val orientation = resources.configuration.orientation

        val numberTextView = findViewById<TextView>(R.id.numberTextView)

        var currentNumber = numberTextView.text.toString()


        val btnAC = findViewById<Button>(R.id.btn_AC)

        val btn7 = findViewById<Button>(R.id.btn_7)
        val btn8 = findViewById<Button>(R.id.btn_8)
        val btn9 = findViewById<Button>(R.id.btn_9)

        val btn4 = findViewById<Button>(R.id.btn_4)
        val btn5 = findViewById<Button>(R.id.btn_5)
        val btn6 = findViewById<Button>(R.id.btn_6)

        val btn1 = findViewById<Button>(R.id.btn_1)
        val btn2 = findViewById<Button>(R.id.btn_2)
        val btn3 = findViewById<Button>(R.id.btn_3)

        val btn0 = findViewById<Button>(R.id.btn_0)

        val btnEq_h = findViewById<Button>(R.id.btn_eq_h)
        val btnEq = findViewById<Button>(R.id.btn_eq)
        val btnSettings = findViewById<Button>(R.id.btn_set)
        val btnMap = findViewById<Button>(R.id.btn_map)
        val btnSettings_h = findViewById<Button>(R.id.btn_set_h)
        val btnMap_h = findViewById<Button>(R.id.btn_Map_h)
        val btn0_h = findViewById<Button>(R.id.btn_0_h)
        val btn1_h = findViewById<Button>(R.id.btn_1_h)
        val btn2_h = findViewById<Button>(R.id.btn_2_h)
        val btn3_h = findViewById<Button>(R.id.btn_3_h)
        val btnAparat = findViewById<Button>(R.id.btn_aparat)
        val btnAparat_h = findViewById<Button>(R.id.btn_aparat_h)

        val layoutParams1 = RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.MATCH_PARENT,
            RelativeLayout.LayoutParams.WRAP_CONTENT
        )

        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {

            layoutParams1.setMargins(0, resources.dpToPx(130), 0, 0)

            val layoutParams = scroll.layoutParams


            layoutParams.width = resources.dpToPx(650)
            scroll.layoutParams = layoutParams

            val layoutParams_img = imageView.layoutParams as RelativeLayout.LayoutParams


            layoutParams_img.marginStart = resources.dpToPx(670)


            imageView.layoutParams = layoutParams_img


            btn1.visibility = View.GONE
            btn2.visibility = View.GONE
            btn3.visibility = View.GONE

            btn0.visibility = View.GONE

            btnEq.visibility = View.GONE
            btnSettings.visibility = View.GONE
            btnMap.visibility = View.GONE

            btn1_h.visibility = View.VISIBLE
            btn2_h.visibility = View.VISIBLE
            btn3_h.visibility = View.VISIBLE
            btnEq_h.visibility = View.VISIBLE
            btnSettings_h.visibility = View.VISIBLE
            btnMap_h.visibility = View.VISIBLE
            btn0_h.visibility = View.VISIBLE
            btnAparat_h.visibility = View.VISIBLE
        } else {

            layoutParams1.setMargins(0, resources.dpToPx(200), 0, 0)

            val layoutParams = scroll.layoutParams


            layoutParams.width = resources.dpToPx(250)
            scroll.layoutParams = layoutParams

            val layoutParams_img = imageView.layoutParams as RelativeLayout.LayoutParams


            layoutParams_img.marginStart = resources.dpToPx(270)


            imageView.layoutParams = layoutParams_img

            btn1.visibility = View.VISIBLE
            btn2.visibility = View.VISIBLE
            btn3.visibility = View.VISIBLE

            btn0.visibility = View.VISIBLE

            btnEq.visibility = View.VISIBLE
            btnSettings.visibility = View.VISIBLE
            btnMap.visibility = View.VISIBLE

            btn1_h.visibility = View.GONE
            btn2_h.visibility = View.GONE
            btn3_h.visibility = View.GONE
            btnEq_h.visibility = View.GONE
            btnSettings_h.visibility = View.GONE
            btnMap_h.visibility = View.GONE
            btn0_h.visibility = View.GONE
            btnAparat_h.visibility = View.GONE
        }

        linearLayout1.layoutParams = layoutParams1

        btnMap.setOnClickListener {
            val address = "Janiszewskiego 7, 50-372 Wrocław"


            val geoUri = "geo:0,0?q=$address"
            val mapIntent = Intent(Intent.ACTION_VIEW, Uri.parse(geoUri))


            try {

                startActivity(mapIntent)
            } catch (e: Exception) {


                e.printStackTrace()

            }
        }


        btnSettings.setOnClickListener {

            val settingsIntent = Intent(android.provider.Settings.ACTION_SETTINGS)

            try {

                startActivity(settingsIntent)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }



        btnAparat.setOnClickListener {

            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
        }

        btnMap_h.setOnClickListener {
            val address = "Janiszewskiego 7, 50-372 Wrocław"


            val geoUri = "geo:0,0?q=$address"
            val mapIntent = Intent(Intent.ACTION_VIEW, Uri.parse(geoUri))


            try {

                startActivity(mapIntent)
            } catch (e: Exception) {


                e.printStackTrace()

            }
        }


        btnSettings_h.setOnClickListener {

            val settingsIntent = Intent(android.provider.Settings.ACTION_SETTINGS)

            try {

                startActivity(settingsIntent)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }




        btnAparat_h.setOnClickListener {

            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
        }

        btnEq.setOnClickListener {
            val callIntent: Intent = Uri.parse("tel:" + currentNumber).let { number ->
                Intent(Intent.ACTION_DIAL, number)
            }

            try {

                startActivity(callIntent)
            } catch (e: Exception) {


                e.printStackTrace()

            }
        }


        fun appendNumber(number: String) {
            val currentText = numberTextView.text.toString()
            numberTextView.text = currentText + number
        }


        btn0.setOnClickListener {
            appendNumber("0")
            currentNumber += "0"
        }

        btn0_h.setOnClickListener {
            appendNumber("0")
            currentNumber += "0"
        }

        btn1.setOnClickListener {
            appendNumber("1")
            currentNumber += "1"
        }

        btn1_h.setOnClickListener {
            appendNumber("1")
            currentNumber += "1"
        }

        btn2.setOnClickListener {
            appendNumber("2")
            currentNumber += "2"
        }

        btn2_h.setOnClickListener {
            appendNumber("2")
            currentNumber += "2"
        }

        btn3.setOnClickListener {
            appendNumber("3")
            currentNumber += "3"
        }

        btn3_h.setOnClickListener {
            appendNumber("3")
            currentNumber += "3"
        }

        btn4.setOnClickListener {
            appendNumber("4")
            currentNumber += "4"
        }

        btn5.setOnClickListener {
            appendNumber("5")
            currentNumber += "5"
        }

        btn6.setOnClickListener {
            appendNumber("6")
            currentNumber += "6"
        }

        btn7.setOnClickListener {
            appendNumber("7")
            currentNumber += "7"
        }

        btn8.setOnClickListener {
            appendNumber("8")
            currentNumber += "8"
        }

        btn9.setOnClickListener {
            appendNumber("9")
            currentNumber += "9"
        }

        btnAC.setOnClickListener {
            numberTextView.text = ""
            currentNumber = ""
        }


        


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK) {
            val imageBitmap = data?.extras?.get("data") as Bitmap
            imageView.setImageBitmap(imageBitmap)
        }

    }


}

fun Resources.dpToPx(dp: Int): Int {
    return TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        dp.toFloat(),
        this.displayMetrics
    ).toInt()
}
