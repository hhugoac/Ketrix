package com.example.ketrix

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.view.View
import android.widget.RelativeLayout

class Ketrix(context: Context, mainContentLayout: RelativeLayout) : View(context){

    lateinit var ketrix : Ketrix

    val painter: Paint = Paint(Paint.ANTI_ALIAS_FLAG).apply{
        strokeWidth = 10f
        style = Paint.Style.FILL
    }

    val screenHeight = mainContentLayout.height
    val screenWidth = mainContentLayout.width

    val block = Rect(screenWidth / 2 - 75 ,50,screenWidth / 2 + 75,200);

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        painter.color = Color.RED
        canvas?.drawRect(block, painter)
    }

    fun loop(){
        render()
    }

    fun render(){
        if( (block.top + 200) != screenHeight) {
            block.top += 15
            block.bottom += 15
        }

        invalidate()
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
    }
}