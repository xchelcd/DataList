package com.idaxmx.myapplication.ui.test

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.idaxmx.myapplication.databinding.ActivityTestBinding
import com.idaxmx.myapplication.model.User
import com.idaxmx.myapplication.util.extension.MaxHeight
import com.idaxmx.myapplication.util.extension.convertHeightToPercentageBase2m

class TestActivity : AppCompatActivity() {

    private var _binding: ActivityTestBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val user = User(
            id = "someId",
            name = "Xchel",
            height = 0.53f
        )

        binding.height = user.height.convertHeightToPercentageBase2m()
        binding.maxHeight = MaxHeight.THREE
    }
}