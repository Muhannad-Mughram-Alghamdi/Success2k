package sa.edu.tuwaiq.fockos.View

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ToggleButton
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import com.bumptech.glide.Glide
import sa.edu.tuwaiq.fockos.R
import sa.edu.tuwaiq.fockos.model.Photo

/**
 * This our Image recycler View class where connect our data to the recycler View. This class
 * contains multiple functions including, areItemsTheSame,areContentsTheSame, onCreateViewHolder,
 * onBindViewHolder, getItemCount. In addition, this class contains another class ImageViewHolder
 */
//@Hassan and Abdullah Alfaraj, Abdulaziz Alrajeh
class ImageRecyclerViewAdapter(val viewMode:MainViewModel, var fileContext: Context) :
    RecyclerView.Adapter<ImageRecyclerViewAdapter.ImageViewHolder>() {

    /**
     * below we  used Diff until which solves the issue of multiple selection of photos and animate
     * the view. The diffUtil requires the two function below
     */
    val DIFF_CALBACK = object : DiffUtil.ItemCallback<Photo>() {
        /**
         * The function below is to check the photos id are the same or not
         */
        override fun areItemsTheSame(oldItem: Photo, newItem: Photo): Boolean {
            return oldItem.id == newItem.id
        }

        /**
         * The function below is to check old photos are same as the new photos
         */
        override fun areContentsTheSame(oldItem: Photo, newItem: Photo): Boolean {
            return oldItem == newItem
        }


    }

    private val differ = AsyncListDiffer(this, DIFF_CALBACK)

    /**
     *In the function below we create the view of the recyclerView by connecting it to the
     * item_layout
     */
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

    /**
     * In the function below we bind the view using the ideas from our  ImageViewHolder
     */
    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val item = differ.currentList[position]

        holder.favoriteToggleButton.isChecked = item.isFavorite

        Glide.with(fileContext)
            .load(item.urlS)
            .into(holder.image)

    }

    /**
     * in the function below we return the count of the list
     */
    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    /**
     * The function below is add the photos to the list
     */
    fun submitList(list:List<Photo>){
        differ.submitList(list)
    }

    /**
     * The class below is to hold the image view ids
     */
    class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.TestImageView)
        val favoriteToggleButton: ToggleButton = itemView.findViewById(R.id.toggleButtonFav)


    }
}