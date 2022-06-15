package science.example.week5cat.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import science.example.week5cat.data.Cat
import com.facebook.drawee.backends.pipeline.Fresco
import science.example.week5cat.databinding.ItemFavoriteBinding

class FavoriteAdapter(private val cats: List<Cat>,private val context: Context) :
    RecyclerView.Adapter<FavoriteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemFavoriteBinding.inflate(layoutInflater, parent, false)
        Fresco.initialize(context)
        return FavoriteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        holder.bind(cats[position])
    }

    override fun getItemCount(): Int = cats.size
}

class FavoriteViewHolder(private val binding: ItemFavoriteBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: Cat) {
        binding.imageCatsFavorite.setImageURI(item.url)
    }
}