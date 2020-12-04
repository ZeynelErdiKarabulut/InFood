package id.zeynelerdi.infood.home.presenter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.zeynelerdi.infood.core.domain.model.FoodCategory
import id.zeynelerdi.infood.home.R
import id.zeynelerdi.infood.home.databinding.ItemSectionFoodCategoriesBinding
import id.zeynelerdi.infood.core.R as coreR

class HomeSectionAdapter(
    private val actionListener: HomeActionListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val foodCategories = ArrayList<FoodCategory>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return when (viewType) {
            R.layout.item_section_food_categories -> FoodCategoryViewHolder(
                inflater.inflate(viewType, parent, false)
            )
            else -> EmptyViewHolder(
                inflater.inflate(viewType, parent, false)
            )
        }
    }

    override fun getItemCount(): Int = 1

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> R.layout.item_section_food_categories
            else -> coreR.layout.item_empty
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is FoodCategoryViewHolder -> holder.onBind(
                actionListener,
                foodCategories,
            )
        }
    }

    fun setFoodCategories(foodCategories: List<FoodCategory>?) {
        foodCategories?.let {
            this.foodCategories.apply {
                clear()
                addAll(it)
            }

            notifyItemChanged(0)
        }
    }

    class FoodCategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding = ItemSectionFoodCategoriesBinding.bind(itemView)
        private lateinit var adapter: HomeFoodCategoryAdapter

        fun onBind(
            actionListener: HomeActionListener,
            foodCategories: List<FoodCategory>?,
        ) {
            if (!foodCategories.isNullOrEmpty()) {
                adapter = HomeFoodCategoryAdapter(actionListener).apply {
                    setFoodCategories(foodCategories)
                }
                binding.rvFoodCategories.adapter = adapter
                binding.root.visibility = View.VISIBLE
            }
        }
    }

    class EmptyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}