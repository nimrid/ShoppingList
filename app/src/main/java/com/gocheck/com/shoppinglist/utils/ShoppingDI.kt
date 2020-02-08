package com.gocheck.com.shoppinglist.utils

import android.app.Application
import com.gocheck.com.shoppinglist.model.db.ShoppingDatabase
import com.gocheck.com.shoppinglist.model.repository.ShoppingRepository
import com.gocheck.com.shoppinglist.viewModel.ShoppingVMFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class ShoppingDI() : Application(), KodeinAware {

    override val kodein: Kodein = Kodein.lazy {
        import(androidXModule(this@ShoppingDI))
        bind() from singleton{ ShoppingDatabase(instance())}
        bind() from singleton { ShoppingRepository(instance()) }
        bind() from provider { ShoppingVMFactory(instance()) }
    }

}