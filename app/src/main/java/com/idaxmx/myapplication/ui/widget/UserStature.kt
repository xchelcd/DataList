package com.idaxmx.myapplication.ui.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.appcompat.widget.AppCompatImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.idaxmx.myapplication.R
import com.idaxmx.myapplication.databinding.CellUserBinding
import com.idaxmx.myapplication.databinding.StatureUserBinding
import org.w3c.dom.Attr


class UserStature @JvmOverloads constructor (
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val binding: ViewDataBinding = DataBindingUtil.inflate(
        LayoutInflater.from(context),
        R.layout.stature_user,
        this,
        true
    )

    init {
        context.theme.obtainStyledAttributes(attrs, R.styleable.HeightWidget, 0, 0).apply {
            try {
            } finally {
                recycle()
            }
    //val bundle = intentStature.extras!!

}}}