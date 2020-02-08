package com.gocheck.com.shoppinglist.model.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ShoppingList(
    var itemName: String? = null,
    var quantity: Int? = null,
    var price: Double? = null
    ) {

    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}