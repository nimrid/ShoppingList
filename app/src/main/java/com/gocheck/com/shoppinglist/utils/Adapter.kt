package com.gocheck.com.shoppinglist.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gocheck.com.shoppinglist.R
import com.gocheck.com.shoppinglist.model.db.ShoppingList
import com.gocheck.com.shoppinglist.viewModel.ShoppingViewModel
import kotlinx.android.synthetic.main.shopping_list_item.view.*

class Adapter(var shoppingList: List<ShoppingList>,
              private val shoppingViewModel: ShoppingViewModel) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder( LayoutInflater.from(parent.context)
            .inflate(R.layout.shopping_list_item, parent, false) )
    }

    override fun getItemCount(): Int = shoppingList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val list = shoppingList[position]

        holder.itemView.item_name.text = list.itemName
        holder.itemView.item_quantity.text = "${list.quantity}"
        holder.itemView.item_price.text = "${list.price}"

        var quantity : Int = holder.itemView.item_quantity.text.toString().toInt()

        holder.itemView.item_add.setOnClickListener {
            quantity++
            list.quantity = quantity
            holder.itemView.item_quantity.text = "$quantity"
            shoppingViewModel.update(list)
        }

        holder.itemView.item_subtract.setOnClickListener {
            if ( list.quantity!! > 0) {
                quantity--
                list.quantity = quantity
                holder.itemView.item_quantity.text = "$quantity"
                shoppingViewModel.update(list)
//                shoppingViewModel.insert(list)
            }
        }

        holder.itemView.item_delete.setOnClickListener {
            shoppingViewModel.delete(list)
        }
    }
}