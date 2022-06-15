package science.example.week5cat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import science.example.week5cat.data.Cat
import science.example.week5cat.adapter.FavoriteAdapter
import science.example.week5cat.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    private lateinit var adapter: FavoriteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val favoriteList = intent.getParcelableArrayListExtra<Cat>("favorite")

        adapter = FavoriteAdapter( favoriteList as List<Cat>,this)
        binding.recyclerView.layoutManager = GridLayoutManager(this, 2)
        binding.recyclerView.adapter = adapter
    }
}