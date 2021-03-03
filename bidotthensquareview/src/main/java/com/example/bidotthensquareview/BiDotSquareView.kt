package com.example.bidotthensquareview

import android.view.View
import android.view.MotionEvent
import android.content.Context
import android.graphics.Paint
import android.graphics.Canvas
import android.graphics.RectF
import android.graphics.Color
import android.app.Activity

val colors : Array<Int> = arrayOf(
    "#f44336",
    "#9C27B0",
    "#2196F3",
    "#004D40",
    "#b71c1c"
).map {
    Color.parseColor(it)
}.toTypedArray()
val strokeFactor : Float = 90f
val sizeFactor : Float = 5.8f
val delay : Long = 20
val backColor : Int = Color.parseColor("#BDBDBD")
val parts : Int = 4
val scGap : Float = 0.02f / parts
