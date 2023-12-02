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
import com.idaxmx.myapplication.util.extension.reverseHeightPercentage

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

    private var heightPercentage = 0f
    private var base = 0
    init {
        context.theme.obtainStyledAttributes(attrs, R.styleable.HeightWidget, 0, 0).apply {
            try {
                getFloat(R.styleable.HeightWidget_userHeight, 0.5f).let(::setHeight)
                getFloat(R.styleable.HeightWidget_maxUserHeight, 0f).let(::maxUserHeight)
            } finally {
                recycle()
            }
        }
    }

    fun setHeight(heightPercentage: Float) {
        bind.userHeight = heightPercentage
    }

    fun updateHeightTextView(heightPercentage: Float) {
        this.heightPercentage = heightPercentage
        bind.heightTextView.text = heightPercentage.reverseHeightPercentage(base)
    }

    /**
     * @param max: values from 1f to nf
     */
    fun maxUserHeight(max: Float) {
        if (max == 0f) return
        base = max.toInt()
        updateHeightTextView(this.heightPercentage)
        val maxIntValue: Int = max.toInt() * 10
        val constraintSet = ConstraintSet()

        for(i in 1..maxIntValue) {
            val textView = TextView(context)
            val cm = i * 10f
            textView.text = "${cm.toInt()}cm"
            textView.id = View.generateViewId()

            val guideline = Guideline(context)
            guideline.id = View.generateViewId()
            guideline.layoutParams = ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.WRAP_CONTENT, ConstraintLayout.LayoutParams.WRAP_CONTENT).apply {
                orientation = ConstraintLayout.LayoutParams.HORIZONTAL
            }
            val percentage: Float = 1 - (cm / (maxIntValue * 10))
            guideline.setGuidelinePercent(percentage)

            val auxView = View(context)
            auxView.id = View.generateViewId()
            auxView.setBackgroundColor(Color.DKGRAY)
            auxView.layoutParams = LayoutParams(0, 1)

            bind.mainConstraintLayout.apply {
                addView(guideline)
                addView(textView)
                addView(auxView)
                constraintSet.clone(this)
            }

            // top-top
            constraintSet.connect(
                textView.id,
                ConstraintSet.TOP,
                guideline.id, //
                ConstraintSet.TOP,
            )
            //bottom-bottom
            constraintSet.connect(
                textView.id,
                ConstraintSet.BOTTOM,
                guideline.id,
                ConstraintSet.BOTTOM,
            )
            // start text view to end fiftyVerticalGuideline
            constraintSet.connect(
                textView.id,
                ConstraintSet.START,
                bind.fiftyVerticalGuideline.id,
                ConstraintSet.END,
            )

            constraintSet.connect(
                auxView.id,
                ConstraintSet.START,
                ConstraintSet.PARENT_ID,
                ConstraintSet.START
            )
            constraintSet.connect(
                auxView.id,
                ConstraintSet.END,
                bind.fiftyVerticalGuideline.id,
                ConstraintSet.END
            )
            // top-top
            constraintSet.connect(
                auxView.id,
                ConstraintSet.TOP,
                guideline.id, //
                ConstraintSet.TOP,
            )
            //bottom-bottom
            constraintSet.connect(
                auxView.id,
                ConstraintSet.BOTTOM,
                guideline.id,
                ConstraintSet.BOTTOM,
            )
            constraintSet.applyTo(bind.mainConstraintLayout)
        }

    }

}