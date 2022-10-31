package com.hs1121.deligetsexample.canvas

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.hs1121.deligetsexample.R

class CustomShapes(context: Context, attributeSet: AttributeSet?):View(context,attributeSet) {

    private val paint= Paint().apply {
        color=Color.RED
        isAntiAlias=true
    }
    init {
        this.setBackgroundColor(resources.getColor(R.color.teal_700))
    }



    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawRect(50f,50f,500f,500f,paint)
        canvas?.drawCircle(250f,800f,200f,paint)

        canvas?.drawArc(RectF(600f,100f,900f,400f),0f,180f,false,paint)



        val p1=Point(800,600)
        val p2=Point(600,800)
        val p3=Point(1000,800)
        val path = Path()
        path.fillType = Path.FillType.EVEN_ODD
        path.moveTo(p1.x.toFloat(), p1.y.toFloat())
        path.lineTo(p2.x.toFloat(), p2.y.toFloat())
        path.lineTo(p3.x.toFloat(), p3.y.toFloat())
        path.close()
        canvas?.drawPath(path, paint);
    }
}