package com.example.todolist

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.core.content.getSystemService
import kotlinx.android.synthetic.main.color_selector.view.*

class ColorSelector @JvmOverloads
constructor(context: Context, attributeSet: AttributeSet? = null,
            defStyle:Int = 0, defRes:Int = 0)
    : LinearLayout(context, attributeSet, defStyle, defRes) {

    private var listOfColors = listOf(Color.BLUE, Color.RED, Color.GREEN)
    private var selectedColorIndex = 0
    init{
        orientation = LinearLayout.HORIZONTAL
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)
                as LayoutInflater
        inflater.inflate(R.layout.color_selector, this)

        vSelectedColor.setBackgroundColor(listOfColors[selectedColorIndex])

        vaBackArrow.setOnClickListener {
            selectPreviousColor()
        }

        vaFrontArrow.setOnClickListener {
            selectNextColor()
        }


    }

    private fun selectNextColor() {
        if(selectedColorIndex == listOfColors.lastIndex) {
            selectedColorIndex = 0
        }else{
            selectedColorIndex++
        }
        vSelectedColor.setBackgroundColor(listOfColors[selectedColorIndex])
    }

    private fun selectPreviousColor() {
        if(selectedColorIndex == 0) {
            selectedColorIndex = listOfColors.lastIndex
        }else{
            selectedColorIndex--
        }
        vSelectedColor.setBackgroundColor(listOfColors[selectedColorIndex])
    }
}