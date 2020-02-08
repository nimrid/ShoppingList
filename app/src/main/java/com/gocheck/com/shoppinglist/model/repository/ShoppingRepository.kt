package com.gocheck.com.shoppinglist.model.repository

import com.gocheck.com.shoppinglist.model.db.ShoppingDatabase
import com.gocheck.com.shoppinglist.model.db.ShoppingList

class ShoppingRepository(
    private val shoppingDb: ShoppingDatabase
) {

    suspend fun insert(item : ShoppingList) = shoppingDb.getShoppingDao().insert(item)

    fun getShoppingList() = shoppingDb.getShoppingDao().getShopList()

    suspend fun deleteItem(item: ShoppingList) = shoppingDb.getShoppingDao().delete(item)

    suspend fun updateItem(item: ShoppingList) = shoppingDb.getShoppingDao().update(item)

}


