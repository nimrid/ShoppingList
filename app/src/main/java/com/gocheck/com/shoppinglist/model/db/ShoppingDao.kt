package com.gocheck.com.shoppinglist.model.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ShoppingDao {

    @Insert
    suspend fun insert(items : ShoppingList)

    @Query("SELECT * FROM ShoppingList")
    fun getShopList() : LiveData<List<ShoppingList>>

    @Delete
    suspend fun delete(item : ShoppingList)

    @Update
    suspend fun update(item: ShoppingList)
}