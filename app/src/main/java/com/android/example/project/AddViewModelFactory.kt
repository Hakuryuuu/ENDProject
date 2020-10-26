package com.android.example.project

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.example.project.database.DatabaseDAO
import com.android.example.project.databinding.FragmentAddBinding

class AddViewModelFactory (
    private val dataSource: DatabaseDAO,
    private val binding: FragmentAddBinding,
    val application: Application
) : ViewModelProvider.Factory{

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AddViewModel::class.java)) {
            return AddViewModel(dataSource,binding,application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}