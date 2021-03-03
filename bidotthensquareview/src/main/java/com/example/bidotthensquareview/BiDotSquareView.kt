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

fun Int.inverse() : Float = 1f / this
fun Float.maxScale(i : Int, n : Int) : Float = Math.max(0f, this - i * n.inverse())
fun Float.divideScale(i : Int, n : Int) : Float = Math.min(n.inverse(), maxScale(i, n)) * n
fun Float.sinify() : Float = Math.sin(this * Math.PI).toFloat()

fun Canvas.drawBiDotSquare(scale : Float, w : Float, h : Float, paint : Paint) {
    val sf : Float = scale.sinify()
    val sf1 : Float = sf.divideScale(0, parts)
    val sf2 : Float = sf.divideScale(1, parts)
    val sf3 : Float = sf.divideScale(2, parts)
    val sf4 : Float = sf.divideScale(3, parts)
    val size : Float = Math.min(w, h) / sizeFactor
    save()
    translate(w / 2, h / 2)
    for (j in 0..1) {
        val rSize : Float = size * sf1
        save()
        scale(1f - 2 * j, 1f)
        save()
        translate((w / 2 - size / 2) * sf2, 0f)
        drawRect(RectF(-rSize, -rSize, rSize, rSize), paint)
        restore()
        save()
        drawCircle((w / 2 - size / 2 - size) * sf4, 0f, size * sf3, paint)
        restore()
        restore()
    }
    restore()
}

fun Canvas.drawBDSNode(i : Int, scale : Float, paint : Paint) {
    val w : Float = width.toFloat()
    val h : Float = height.toFloat()
    paint.color = colors[i]
    paint.strokeCap = Paint.Cap.ROUND
    paint.strokeWidth = Math.min(w, h) / strokeFactor
    drawBiDotSquare(scale, w, h, paint)
}
