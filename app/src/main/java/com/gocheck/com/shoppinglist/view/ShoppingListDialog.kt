package com.gocheck.com.shoppinglist.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.gocheck.com.shoppinglist.R
import com.gocheck.com.shoppinglist.model.db.ShoppingList
import kotlinx.android.synthetic.main.dialog_shopping_list.*

class ShoppingListDialog(context: Context, private val shoppingDialogListener: ShoppingDialogListener)
    : AppCompatDialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_shopping_list)

        add_item.setOnClickListener {
            val itemName = dialog_item_name.text.toString()
            val itemQuantity = dialog_item_quantity.text.toString()
            val itemPrice = dialog_item_price.text.toString()
            val totalPrice = itemPrice.toDouble() * itemQuantity.toInt()

            if (itemName.isEmpty() or itemQuantity.isEmpty() or itemPrice.isEmpty()){
                Toast.makeText(context, "Enter all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val item = ShoppingList(itemName, itemQuantity.toInt(), totalPrice)
            shoppingDialogListener.onITemAdded(item)
            Toast.makeText(context, "Shopping Item Added", Toast.LENGTH_SHORT).show()
            cancel()
        }

        cancel_item.setOnClickListener {
            cancel()
        }
    }
}