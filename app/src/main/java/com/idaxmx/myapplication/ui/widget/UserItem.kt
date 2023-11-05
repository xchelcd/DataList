package com.idaxmx.myapplication.ui.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import com.idaxmx.myapplication.R
import com.idaxmx.myapplication.databinding.CellUserBinding
import com.idaxmx.myapplication.model.User

class UserItem(
    context: Context,
    attrs: AttributeSet?
) : LinearLayout(context, attrs) {

    private val binding: CellUserBinding = DataBindingUtil.inflate(
        LayoutInflater.from(context),
        R.layout.cell_user,
        this,
        true
    )

    var data: User? = null
        set(value) {
            field = value
            binding.user = field
        }

}