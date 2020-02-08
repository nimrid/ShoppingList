package com.gocheck.com.shoppinglist.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.gocheck.com.shoppinglist.R
import com.gocheck.com.shoppinglist.model.db.ShoppingDatabase
import com.gocheck.com.shoppinglist.model.db.ShoppingList
import com.gocheck.com.shoppinglist.model.repository.ShoppingRepository
import com.gocheck.com.shoppinglist.utils.Adapter
import com.gocheck.com.shoppinglist.viewModel.ShoppingVMFactory
import com.gocheck.com.shoppinglist.viewModel.ShoppingViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class ShoppingActivity : AppCompatActivity(), KodeinAware {

    override val kodein by kodein()
    private val factory : ShoppingVMFactory by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        regular method of constructor DI, not best practice
//        val database = ShoppingDatabase(this)
//        val repository = ShoppingRepository(database)
//        val factory = ShoppingVMFactory(repository)

        val viewModel = ViewModelProviders.of(this, factory).get(ShoppingViewModel::class.java)

        recycler_view.setHasFixedSize(true)
        recycler_view.layoutManager = LinearLayoutManager(this)
        val recyclerAdapter = Adapter(listOf(), viewModel)
        recycler_view.adapter = recyclerAdapter

        viewModel.getList().observe(this, Observer {
            recyclerAdapter.shoppingList = it
            recyclerAdapter.notifyDataSetChanged()
        })


        fab.setOnClickListener {
            ShoppingListDialog(this, object : ShoppingDialogListener {
                override fun onITemAdded(item: ShoppingList) {
                    viewModel.insert(item)
                }

            }).show()

        }

    }

}
