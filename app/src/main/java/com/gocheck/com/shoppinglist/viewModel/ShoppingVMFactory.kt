package com.gocheck.com.shoppinglist.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gocheck.com.shoppinglist.model.repository.ShoppingRepository

@Suppress("UNCHECKED_CAST")
class ShoppingVMFactory(private val shoppingRepository: ShoppingRepository) :
    ViewModelProvider.NewInstanceFactory()  {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ShoppingViewModel(shoppingRepository) as T
    }
}