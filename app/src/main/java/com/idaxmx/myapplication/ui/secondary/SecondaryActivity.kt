package com.idaxmx.myapplication.ui.secondary

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.idaxmx.myapplication.R
import com.idaxmx.myapplication.databinding.ActivitySecondaryBinding
import com.idaxmx.myapplication.model.User
import com.idaxmx.myapplication.ui.main.MainActivity
import com.idaxmx.myapplication.util.extension.MaxHeight
import com.idaxmx.myapplication.util.extension.convertHeightToPercentageBase2m

class SecondaryActivity : AppCompatActivity() {

    private var _binding: ActivitySecondaryBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivitySecondaryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras!!

        val user = bundle.getSerializable("user")as User


        binding.height = user.height.convertHeightToPercentageBase2m()
        binding.maxHeight = MaxHeight.THREE


        binding.returnButton.setOnClickListener() {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.tvSecondActivityName.setText(user.name)
        binding.tvSecondActivityId.setText(user.id)
    }
}