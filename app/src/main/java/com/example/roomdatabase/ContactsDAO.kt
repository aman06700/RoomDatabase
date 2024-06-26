package com.example.roomdatabase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update


@Dao
interface ContactsDAO {
    @Insert
    suspend fun insertContacts(contacts: Contacts)

    @Update
    suspend fun updateContacts(contacts: Contacts)

    @Delete
    suspend fun deleteContacts(contacts: Contacts)

    @Query("SELECT * from contacts")
    fun getContacts(): LiveData<List<Contacts>>
}