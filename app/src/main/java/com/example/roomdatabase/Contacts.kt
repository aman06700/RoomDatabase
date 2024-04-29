package com.example.roomdatabase

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("contacts")
data class Contacts(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val name: String,
    val phnNumber: String
)