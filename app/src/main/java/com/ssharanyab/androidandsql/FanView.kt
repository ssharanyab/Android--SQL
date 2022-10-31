package com.hs1121.deligetsexample.canvas

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlin.coroutines.coroutineContext

class FanView(context:Context,attributeSet: AttributeSet?): View(context,attributeSet) {
    private lateinit var onMotionEvent: OnMotionEvent
    private var paint:Paint = Paint()
    var startVal=0f
    val sweepAngle=30f
    val diff=90f
    private  val rectf:RectF
    val center=true


    init {
        paint.color=Color.RED
        rectf=RectF(400f,400f,800f,800f)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.apply {
            drawArc(rectf,startVal,sweepAngle,center,paint)
            drawArc(rectf,startVal+diff,sweepAngle,center,paint)
            drawArc(rectf,startVal+2*diff,sweepAngle,center,paint)
            drawArc(rectf,startVal+3*diff,sweepAngle,center,paint)
        }
    }


    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when(event?.action){
            MotionEvent.ACTION_DOWN->{
                onMotionEvent.actionDown(this)
            }
            MotionEvent.ACTION_UP->{
                onMotionEvent.actionUp(this)
            }
        }

        return super.onTouchEvent(event)
    }

    interface OnMotionEvent {
        fun actionDown(view: FanView)
        fun actionUp(view: FanView)
    }
    fun setOnMotionEvent(onMotionEvent: OnMotionEvent) {
        this.onMotionEvent=onMotionEvent
    }

}