package com.gocheck.com.shoppinglist.view

import com.gocheck.com.shoppinglist.model.db.ShoppingList

interface ShoppingDialogListener {
    fun onITemAdded(item: ShoppingList)
}