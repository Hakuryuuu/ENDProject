package com.android.example.project.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DatabaseDAO {
    @Insert
    fun insert(contact: Contact)

    @Query("SELECT * from contact_table")
    fun get(): LiveData<List<Contact>>

    @Query("DELETE  FROM contact_table")
    fun clear()
}