package com.idaxmx.myapplication.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.idaxmx.myapplication.databinding.ActivityMainBinding
import com.idaxmx.myapplication.model.User
import com.idaxmx.myapplication.ui.secondary.SecondaryActivity
import com.idaxmx.myapplication.ui.test.TestActivity
import com.idaxmx.myapplication.ui.widget.UserStature
import kotlinx.coroutines.launch
import kotlin.random.Random


data class a(
    val a: String,
    val shinny:Int
) {
    var b: Boolean? = null
        get() {
            return if (field == null) {
                val random = Random.nextInt(10)
                random == 1
            } else {
                field!!
            }
    }
}
class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    private var viewModel: MainViewModel = MainViewModel(
        listOf(
            User("123", "Xchel", 1.73F),
            User("123", "Alonso", 1.80F),
            User("123", "Octavio", 1.64F),
            User("123", "Antonio", 1.60F),
            User("123", "Darios", 1.76F),
            User("123", "Isaac", 1.50F),
            User("123", "Eduardo", 1.94F),
            User("123", "Jose", 1.99F),
            User("123", "Ian", 1.45F),
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
        //startActivity(Intent(this, TestActivity::class.java))
    }

    private fun handleUserSelected(user: User) {
        //Toast.makeText(this, user.name, Toast.LENGTH_SHORT).show()

        val id = user.id
        val name = user.name
        //val stature = user.height
        val bundle = Bundle()
        bundle.putString("id", id)
        bundle.putString("name", name)
        //bundle.putDouble("stature", stature.toDouble())

        //val intent = Intent(this, TestActivity::class.java)
        val intent = Intent(this, SecondaryActivity::class.java)
        intent.putExtra("user", user)
        intent.putExtras(bundle)
        startActivity(intent)


        //val intentStature = Intent(this, UserStature::class.java)
        //intentStature.putExtras(bundle)
        //startActivity(intentStature)
    }

    private fun render(state: MainState) {
        binding.state = state
    }


}