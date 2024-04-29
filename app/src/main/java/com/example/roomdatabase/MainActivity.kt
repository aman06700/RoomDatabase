package com.example.roomdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings.Global
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var database: ContactsDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        database = Room.databaseBuilder(applicationContext,ContactsDatabase::class.java,"contactsDB").build()

        GlobalScope.launch {
            database.contactsDao().insertContacts(Contacts(0,"Aman","941536785"))
        }

    }

    fun getContacts(view: View) {
        database.contactsDao().getContacts().observe(this, Observer {
            Log.e("Contacts Data", it.toString())
        })
    }
}