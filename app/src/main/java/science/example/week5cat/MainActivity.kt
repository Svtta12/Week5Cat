package science.example.week5cat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import androidx.lifecycle.ViewModelProvider
import com.example.catsapp.ui.Cat
import com.facebook.drawee.backends.pipeline.Fresco
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import science.example.week5cat.databinding.ActivityMainBinding
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var vm: Cat

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Fresco.initialize(this)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        vm = ViewModelProvider(this)[Cat::class.java]

        initViews()
    }

    private fun initViews() {
        setImage()
        binding.apply {
            buttonYes.setOnClickListener {
                vm.onLike()
                setImage()
                vm.getFavoriteCats()
            }
            buttonNo.setOnClickListener {
                setImage()
                vm.getFavoriteCats()
            }
            buttonFavorite.setOnClickListener {
                val intent = Intent(this@MainActivity, SecondActivity::class.java)
                intent.putParcelableArrayListExtra(
                    "favorite", vm.getFavoriteCats() as ArrayList<out Parcelable>
                )
                startActivity(intent)
            }
        }
    }

    private fun setImage() {
        CoroutineScope(Job()).launch {
            binding.imageCat.setImageURI(vm.getCat().url)
        }
    }
}