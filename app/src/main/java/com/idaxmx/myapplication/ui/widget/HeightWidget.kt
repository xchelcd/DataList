package com.idaxmx.myapplication.ui.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
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
            } finally {
                recycle()
            }
        }
    }

    fun setHeight(heightPercentage: Float) {
        bind.userHeight = heightPercentage
        updateHeightTextView(heightPercentage)
    }

    private fun updateHeightTextView(heightPercentage: Float) {
        bind.heightTextView.text = heightPercentage.reverseHeightPercentageBase2m()
    }

}