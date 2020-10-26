package com.android.example.project

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.example.project.database.DatabaseDAO

class ListsViewModelFactory (
    private val dataSource: DatabaseDAO,
) : ViewModelProvider.Factory{

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ListsViewModel::class.java)) {
            return ListsViewModel(dataSource,application = Application()) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}