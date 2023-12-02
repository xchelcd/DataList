package com.idaxmx.myapplication.ui.test

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.idaxmx.myapplication.databinding.ActivityTestBinding
import com.idaxmx.myapplication.model.User
import com.idaxmx.myapplication.util.extension.MaxHeight
import com.idaxmx.myapplication.util.extension.convertHeightToPercentage

class TestActivity : AppCompatActivity() {

    private var _binding: ActivityTestBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityTestBinding.inflate(layoutInflater)
        val user = User(
            id = "someId",
            name = "Xchel",
            height = 1.73f
        )
        val base = MaxHeight.TWO
        binding.height = user.height.convertHeightToPercentage(base)
        binding.maxHeight = base
        setContentView(binding.root)
    }
}