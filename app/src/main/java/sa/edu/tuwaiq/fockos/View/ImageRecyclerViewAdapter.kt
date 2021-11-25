package sa.edu.tuwaiq.fockos.View

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import sa.edu.tuwaiq.fockos.R
import sa.edu.tuwaiq.fockos.model.ImageModel
import sa.edu.tuwaiq.fockos.model.Photo

//@Hassan and Abdullah
class ImageRecyclerViewAdapter(val viewMode:MainViewModel) :
    RecyclerView.Adapter<ImageRecyclerViewAdapter.ImageViewHolder>() {

    val DIFF_CALBACK = object : DiffUtil.ItemCallback<Photo>() {
        override fun areItemsTheSame(oldItem: Photo, newItem: Photo): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Photo, newItem: Photo): Boolean {
            return oldItem == newItem
        }


    }
    private val differ = AsyncListDiffer(this, DIFF_CALBACK)


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ImageRecyclerViewAdapter.ImageViewHolder {
        return ImageViewHolder(

            LayoutInflater.from(parent.context).inflate(
                R.layout.item_layout,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val item = differ.currentList[position]
        TODO("bind view with data")
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    fun submitList(list:List<Photo>){
        differ.submitList(list)
    }

    class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}