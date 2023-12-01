package com.idaxmx.myapplication.ui.widget

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.constraintlayout.widget.Guideline
import androidx.databinding.DataBindingUtil
import com.idaxmx.myapplication.R
import com.idaxmx.myapplication.databinding.WidgetHeightBinding
import com.idaxmx.myapplication.util.extension.reverseHeightPercentageBase2m

class HeightWidget(
    context: Context,
    attrs: AttributeSet
): LinearLayout(context, attrs) {

    private val bind: WidgetHeightBinding = DataBindingUtil
        .inflate(
            LayoutInflater.from(context),
            R.layout.widget_height,
            this,
            true
        )

    init {
        context.theme.obtainStyledAttributes(attrs, R.styleable.HeightWidget, 0, 0).apply {
            try {
                getFloat(R.styleable.HeightWidget_userHeight, 0.5f).let(::setHeight)
                getFloat(R.styleable.HeightWidget_maxUserHeight, 2f).let(::maxUserHeight)
            } finally {
                recycle()
            }
        }
    }

    fun setHeight(heightPercentage: Float) {
        bind.userHeight = heightPercentage
    }

    fun updateHeightTextView(heightPercentage: Float) {
        bind.heightTextView.text = heightPercentage.reverseHeightPercentageBase2m()
    }

    /**
     * @param max: values from 1f to nf
     */
    fun maxUserHeight(max: Float) {
        val aux = bind.heightTextView
        val maxIntValue: Int = max.toInt() * 10
        val constraintSet = ConstraintSet()
        val constraintLayout = bind.mainConstraintLayout


        //

        /*
        for (i in 0..maxIntValue step 1) { // i = 1 -> 10cm
            val text = "${1 * 10}cm"
            val textView = TextView(context)
            textView.id = View.generateViewId()
            textView.textSize = 22f
            textView.setBackgroundColor(Color.CYAN)
            textView.text = text
            val guideline = Guideline(context)
            guideline.id = View.generateViewId()
            guideline.setGuidelinePercent((i / 10).toFloat())
            guideline.layoutParams = ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.WRAP_CONTENT,
                ConstraintLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                orientation = ConstraintLayout.LayoutParams.HORIZONTAL
            }

            bind.mainConstraintLayout.addView(guideline)

            //textView.textSize = if (1 % 5 == 0) 22f else 16f


            constraintLayout.addView(textView)
        }
        constraintSet.clone(constraintLayout)
        //constraintSet.connect(
        //    textView.id, // startId
        //    ConstraintSet.TOP, // startSide ***
        //    aux.id, // endId
        //    ConstraintSet.BOTTOM, // endSide ***
        //)

        constraintSet.applyTo(constraintLayout)

         */
    }

}