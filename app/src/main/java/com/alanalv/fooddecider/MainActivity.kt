package com.alanalv.fooddecider

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    val foodList = arrayListOf("Burger", "Pollo",  "Barbacoa", "Kekas", "Liru")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        selectedFoodtxt.text = "Burger King"

        decideBtn.setOnClickListener {
            val random = Random()
            val randomFood = random.nextInt(foodList.count())

            selectedFoodtxt.text = foodList[randomFood]
        }

        addFoodBtn.setOnClickListener {
            val newFood = addFoodTxt.text.toString()
            foodList.add(newFood)
            addFoodTxt.text.clear()
            it.hideKeyboard()
        }
    }
    fun View.hideKeyboard(){
        val inputManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.hideSoftInputFromWindow(windowToken, 0)
    }
}
