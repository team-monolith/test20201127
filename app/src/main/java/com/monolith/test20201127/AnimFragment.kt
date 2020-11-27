package com.monolith.test20201127

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.os.Bundle
import android.os.Handler
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import kotlin.random.Random

class AnimFragment : Fragment() {

    var _clickListener: OnClickListener? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {


        val view = inflater.inflate(R.layout.fragment_anim, container, false)
        val layout = view.findViewById<LinearLayout>(R.id.anim_fragment_body)
        val animView = AnimView(this.activity)
        layout.addView(animView)

        val handler = Handler()
        return view
    }

    class AnimView : View {

        constructor(context: Context?) : super(context)
        constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
        constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

        override fun onDraw(canvas: Canvas?) {
            super.onDraw(canvas)

            val paint = Paint()
            paint.color = Color.BLACK
            val rect = Rect(400+ Random.nextInt(300), 600+ Random.nextInt(300), 700+ Random.nextInt(300), 900+ Random.nextInt(300))

            canvas!!.drawRect(rect, paint)

        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.btnAnim).setOnClickListener(View.OnClickListener {
            //_clickListener!!.onClick_Anim()
            AnimView(this.activity).invalidate()
        })
    }

    //Activityにイベントを通知
    interface OnClickListener {
        fun onClick_Anim()
    }
}