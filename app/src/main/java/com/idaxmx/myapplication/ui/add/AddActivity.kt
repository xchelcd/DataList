package com.idaxmx.myapplication.ui.add

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.idaxmx.myapplication.databinding.ActivityAddBinding

class AddActivity : AppCompatActivity() {

    private var _binding: ActivityAddBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}