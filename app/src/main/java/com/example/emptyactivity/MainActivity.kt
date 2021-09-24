package com.example.emptyactivity

import android.content.Intent
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.TextureView
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    lateinit var dnb: TextView
    lateinit var mtv: TextView
    lateinit var mtv2: TextView
    lateinit var mtv3: TextView
    lateinit var mtv4: TextView
    lateinit var btnp: Button
    lateinit var btnm: Button
    lateinit var dnbtext: String
    var v: Int = 0
    var clickcnt=0
    lateinit var imgone: ImageView
    lateinit var imgtwo: ImageView
    lateinit var imgthree: ImageView
    lateinit var imgfour: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnSecAct=findViewById<Button>(R.id.btnSecActivity)
        btnSecAct.setOnClickListener{
            val Intent = Intent(this,MainActivity2::class.java)
            startActivity(Intent)
        }

        dnb= findViewById<TextView>(R.id.numberDice)
        /*mtv = findViewById<TextView>(R.id.msgTextView)
        mtv2 = findViewById<TextView>(R.id.msgTextView2)
        mtv3 = findViewById<TextView>(R.id.msgTextView3)
        mtv4 = findViewById<TextView>(R.id.msgTextView4)*/
        btnm=findViewById<Button>(R.id.buttonMinus)
        btnp=findViewById<Button>(R.id.buttonPlus)
        dnbtext=dnb.text as String
        v= dnbtext.toInt()

        imgone=findViewById<ImageView>(R.id.imageView1)
        imgtwo=findViewById<ImageView>(R.id.imageView2)
        imgthree=findViewById<ImageView>(R.id.imageView3)
        imgfour=findViewById<ImageView>(R.id.imageView4)

        imgone.setImageResource(R.drawable.dice0)
        imgtwo.setImageResource(R.drawable.dice0)
        imgthree.setImageResource(R.drawable.dice0)
        imgfour.setImageResource(R.drawable.dice0)

        imgtwo.isVisible=false
        imgthree.isVisible=false
        imgfour.isVisible=false
    }

    fun btnSetClicked(sender: View){
        var rand=(1..6).random()
        var resources: Resources= resources
        var resourceId: Int=0
        when(rand){
            1 -> resourceId = resources.getIdentifier("n1",
                    "drawable", packageName)

            2 -> resourceId = resources.getIdentifier("n2",
                    "drawable", packageName)

            3 -> resourceId = resources.getIdentifier("n3",
                    "drawable", packageName)

            4 -> resourceId=resources.getIdentifier("n4",
                "drawable", packageName)

            5 -> resourceId=resources.getIdentifier("n5",
                "drawable", packageName)

            6 -> resourceId=resources.getIdentifier("n6",
                "drawable", packageName)

        }
        if(v==1) {
            clickcnt=0
            imgone.setImageResource(resourceId)
            clickcnt++
            imgtwo.setImageResource(R.drawable.dice0)
            imgthree.setImageResource(R.drawable.dice0)
            imgfour.setImageResource(R.drawable.dice0)
        }
        else if(v==2) {
            if (clickcnt == 0) {
                imgone.setImageResource(resourceId)
                clickcnt++
                imgtwo.setImageResource(R.drawable.dice0)
                imgthree.setImageResource(R.drawable.dice0)
                imgfour.setImageResource(R.drawable.dice0)
            }
            else if (clickcnt == 1) {
                imgtwo.setImageResource(resourceId)
                clickcnt++
            }
            else {
                imgone.setImageResource(resourceId)
                imgtwo.setImageResource(R.drawable.dice0)
                clickcnt=1
            }
        }
        else if(v==3) {
            if (clickcnt == 0) {
                imgone.setImageResource(resourceId)
                clickcnt++
                imgtwo.setImageResource(R.drawable.dice0)
                imgthree.setImageResource(R.drawable.dice0)
                imgfour.setImageResource(R.drawable.dice0)
            }
            else if (clickcnt == 1) {
                imgtwo.setImageResource(resourceId)
                clickcnt++
            }
            else if (clickcnt == 2) {
                imgthree.setImageResource(resourceId)
                clickcnt++
            }
            else{
                imgone.setImageResource(resourceId)
                imgtwo.setImageResource(R.drawable.dice0)
                imgthree.setImageResource(R.drawable.dice0)
                clickcnt=1
            }
        }
        else {
            if (clickcnt == 0) {
                imgone.setImageResource(resourceId)
                clickcnt++
                imgtwo.setImageResource(R.drawable.dice0)
                imgthree.setImageResource(R.drawable.dice0)
                imgfour.setImageResource(R.drawable.dice0)
            }
            else if (clickcnt == 1) {
                imgtwo.setImageResource(resourceId)
                clickcnt++
            }
            else if (clickcnt == 2) {
                imgthree.setImageResource(resourceId)
                clickcnt++
            }
            else{
                imgfour.setImageResource(resourceId)
                clickcnt = 0
            }
        }
        DataResults.AddOne(rand, v)
    }

    fun btnSet2Clicked(sender: View){
        clickcnt=0
        val list: MutableList<Int> = mutableListOf()
        for(i in 1..4)
        {
            var rand=(1..6).random()
            var resources: Resources= resources
            var resourceId: Int=0
            when(rand){
                1 -> resourceId=resources.getIdentifier("n1",
                    "drawable", packageName)
                2 -> resourceId=resources.getIdentifier("n2",
                    "drawable", packageName)
                3 -> resourceId=resources.getIdentifier("n3",
                    "drawable", packageName)
                4 -> resourceId=resources.getIdentifier("n4",
                    "drawable", packageName)
                5 -> resourceId=resources.getIdentifier("n5",
                    "drawable", packageName)
                6 -> resourceId=resources.getIdentifier("n6",
                    "drawable", packageName)
            }

            if(v==1){
                imgone.setImageResource(resourceId)
                imgtwo.setImageResource(R.drawable.dice0)
                imgthree.setImageResource(R.drawable.dice0)
                imgfour.setImageResource(R.drawable.dice0)
            }
            else if (v==2) {
                imgthree.setImageResource(R.drawable.dice0)
                imgfour.setImageResource(R.drawable.dice0)
                when (i) {
                    1 -> imgone.setImageResource(resourceId)
                    2 -> imgtwo.setImageResource(resourceId)
                }
            }
            else if (v==3) {
                imgfour.setImageResource(R.drawable.dice0)
                when (i) {
                    1 -> imgone.setImageResource(resourceId)
                    2 -> imgtwo.setImageResource(resourceId)
                    3 -> imgthree.setImageResource(resourceId)
                }
            }
            else{
                when(i){
                    1 -> imgone.setImageResource(resourceId)
                    2 -> imgtwo.setImageResource(resourceId)
                    3 -> imgthree.setImageResource(resourceId)
                    4 -> imgfour.setImageResource(resourceId)
                }
            }
        }
        DataResults.AddResults(Results(list,v))
    }

    fun ShowImg(x: Int){
        if(x==1){
            imgtwo.isVisible=false
            imgthree.isVisible=false
            imgfour.isVisible=false
        }
        else if(x==2){
            imgtwo.isVisible=true
            imgthree.isVisible=false
            imgfour.isVisible=false
        }
        else if(x==3){
            imgthree.isVisible=true
            imgfour.isVisible=false
        }
        else imgfour.isVisible=true
    }

    fun btnPlusClicked(sender: View) {
        btnm.isEnabled=true
        if (v==4){
            btnp.isEnabled=false
        } else{
            v++
            var i=v.toString()
            dnb.setText(i)
        }
        ShowImg(v)
    }

    fun btnMinusClicked(sender: View) {
        btnp.isEnabled=true
        if (v==1){
            btnm.isEnabled=false
        } else{
            v--
            var i=v.toString()
            dnb.setText(i)
        }
        ShowImg(v)
    }
}