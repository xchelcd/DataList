package com.idaxmx.myapplication.ui.secondary

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.idaxmx.myapplication.R
import com.idaxmx.myapplication.databinding.ActivitySecondaryBinding
import com.idaxmx.myapplication.ui.main.MainActivity

class SecondaryActivity : AppCompatActivity() {

    private var _binding: ActivitySecondaryBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivitySecondaryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras!!
        val textIdUserBundle = bundle.getString("id")
        val textUserNameBundle = bundle.getString("name")

        binding.returnButton.setOnClickListener() {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.tvSecondActivityName.setText(textUserNameBundle)
        binding.tvSecondActivityId.setText(textIdUserBundle)
    }
}