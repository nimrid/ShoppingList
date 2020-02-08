package com.gocheck.com.shoppinglist.viewModel

import androidx.lifecycle.ViewModel
import com.gocheck.com.shoppinglist.model.db.ShoppingList
import com.gocheck.com.shoppinglist.model.repository.ShoppingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShoppingViewModel(
    private val shoppingRepository: ShoppingRepository ) : ViewModel() {

    fun insert(item : ShoppingList) = CoroutineScope(Dispatchers.Main).launch {
        shoppingRepository.insert(item)
    }

    fun getList() = shoppingRepository.getShoppingList()

    fun delete(item: ShoppingList) = CoroutineScope(Dispatchers.Main).launch {
        shoppingRepository.deleteItem(item)
    }

    fun update(item : ShoppingList) = CoroutineScope(Dispatchers.Main).launch {
        shoppingRepository.updateItem(item)
    }

}