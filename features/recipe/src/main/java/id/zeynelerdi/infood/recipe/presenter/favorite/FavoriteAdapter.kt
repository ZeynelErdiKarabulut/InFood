package id.zeynelerdi.infood.recipe.presenter.favorite

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.zeynelerdi.infood.core.domain.model.Recipe
import id.zeynelerdi.infood.core.util.UrlHelper
import id.zeynelerdi.infood.core.util.loadRecipeImage
import id.zeynelerdi.infood.recipe.R
import id.zeynelerdi.infood.recipe.databinding.ItemRecipeBinding
import id.zeynelerdi.infood.core.R as coreR

class FavoriteAdapter : RecyclerView.Adapter<FavoriteAdapter.FavoriteViewHolder>() {

    var onOpenRecipeDetail: ((recipe: Recipe) -> Unit)? = null
    var onUpdateArchivedRecipe: ((archive: Boolean, recipe: Recipe) -> Unit)? = null

    private val recipes = ArrayList<Recipe>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder =
        FavoriteViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_recipe, parent, false)
        )

    override fun getItemCount(): Int = recipes.size

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) =
        holder.onBind(recipes[position])

    fun setRecipeList(recipes: List<Recipe>?) {
        recipes?.let {
            this.recipes.apply {
                clear()
                addAll(it)
            }
        }

        notifyDataSetChanged()
    }

    inner class FavoriteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding = ItemRecipeBinding.bind(itemView)
        private var isFavorite = false

        fun onBind(recipe: Recipe) {
            isFavorite = recipe.isFavorite

            binding.layoutRecipe.setOnClickListener { onOpenRecipeDetail?.invoke(recipe) }
            binding.imgCover.loadRecipeImage(
                UrlHelper.getThumbnailUrl(
                    id = recipe.id.toString(),
                    imageType = recipe.imageType
                )
            )
            binding.imgCover.contentDescription = recipe.title
            binding.tvTitle.text = recipe.title
            binding.tvAuthor.text = recipe.sourceName
            binding.btnFavorite.apply {
                setIconResource(getArchiveIcon(isFavorite))
                setIconTintResource(getArchiveIconTint(isFavorite))
                setOnClickListener {
                    isFavorite = !isFavorite
                    onUpdateArchivedRecipe?.invoke(isFavorite, recipe)
                    setIconResource(getArchiveIcon(isFavorite))
                    setIconTintResource(getArchiveIconTint(isFavorite))
                }
            }
        }

        private fun getArchiveIcon(isFavorite: Boolean): Int {
            return if (isFavorite) coreR.drawable.ic_baseline_favorite_24
            else coreR.drawable.ic_outline_favorite_24
        }

        private fun getArchiveIconTint(isFavorite: Boolean): Int {
            return if (isFavorite) coreR.color.colorPrimary
            else coreR.color.colorBoulder
        }
    }
}