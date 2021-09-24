package com.example.emptyactivity

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.cardview.widget.CardView

lateinit var txt_results: TextView

class MainActivity2 : AppCompatActivity() {

    lateinit var ResultsLayout: LinearLayout

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?)
    {
        ResultsLayout= findViewById(R.id.ResultsLayout)
        val dices = DataResults.Get()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        for (i in dices)
        {
            val t= TextView(this)
            t.textSize= 40f
            t.text= i.toString()

            val card = CardView(this)
            card.addView(t)
            card.setCardBackgroundColor(getColor(R.color.white))
            card.radius = 20F
            card.useCompatPadding = true

            ResultsLayout.addView(card)
        }
    }

    fun DeleteBtn(sender: View){
        DataResults.Remove()
        ResultsLayout.removeAllViews()
    }
}