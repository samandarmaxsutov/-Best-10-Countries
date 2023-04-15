package com.example.best10countriesapp.feature1.ui.screens.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.best10countriesapp.R
import com.example.best10countriesapp.feature1.model.repository.local.room.entities.CountryEntity


class CityAdapter : RecyclerView.Adapter<CityAdapter.Holder>() {
    private val data: MutableList<CountryEntity> = ArrayList()
    private var onClickListener:((CountryEntity)->Unit)? = null
    @SuppressLint("NotifyDataSetChanged")
    fun submitItems(newItems: List<CountryEntity>) {
        data.clear()
        data.addAll(newItems)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(
            LayoutInflater.from(parent.context).inflate(R.layout.items_country, parent, false)
        )
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun onClick(l:(CountryEntity)->Unit) {
        onClickListener=l
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val name = itemView.findViewById<TextView>(R.id.country_name)
        private val capital = itemView.findViewById<TextView>(R.id.country_capital)
        private val image = itemView.findViewById<ImageView>(R.id.image_item)
        private val imageBtn = itemView.findViewById<ImageView>(R.id.btn_right)
        fun bind(postion: Int) {
            val item: CountryEntity = data[postion]
            name.text = item.name
            capital.text = item.capital
            image.setImageResource(item.image)
        }

        init {
            imageBtn.setOnClickListener {
                onClickListener?.invoke(
                    data[adapterPosition]
                )
            }
        }
    }
}
