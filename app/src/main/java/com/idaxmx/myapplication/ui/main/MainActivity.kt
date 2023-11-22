package com.idaxmx.myapplication.ui.main

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.idaxmx.myapplication.databinding.ActivityMainBinding
import com.idaxmx.myapplication.model.User
import com.idaxmx.myapplication.ui.secondary.SecondaryActivity
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    private var viewModel: MainViewModel = MainViewModel(
        listOf(
            User("123", "Xchel"),
            User("123", "Alonso"),
            User("123", "Octavio"),
            User("123", "Antonio"),
            User("123", "Darios"),
            User("123", "Isaac"),
            User("123", "Eduardo"),
            User("123", "Jose"),
            User("123", "Ian"),
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding) {
            setHandleUserSelected(::handleUserSelected)
            setHandleFilter(viewModel::setFilter)
        }
        lifecycleScope.launch {
            viewModel.state.collect(::render)
        }
    }

    private fun handleUserSelected(user: User) {
        //Toast.makeText(this, user.name, Toast.LENGTH_SHORT).show()

        val id = user.id
        val name = user.name
        val bundle = Bundle()
        bundle.putString("id", id)
        bundle.putString("name", name)

        val intent = Intent(this, SecondaryActivity::class.java)
        intent.putExtras(bundle)
        startActivity(intent)
    }

    private fun render(state: MainState) {
        binding.state = state
    }
}