package com.android.example.project

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.android.example.project.database.Database
import com.android.example.project.databinding.FragmentListsBinding

class ListsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var binding = DataBindingUtil.inflate<FragmentListsBinding>(
            inflater,
            R.layout.fragment_lists,
            container,
            false
        )

        setHasOptionsMenu(true)

        val application = requireNotNull(this.activity).application
        val dataSource = Database.getInstance(application).databaseDao
        val viewModelFactory = ListsViewModelFactory(dataSource)
        val listsViewModel =
            ViewModelProvider(
                this, viewModelFactory
            ).get(ListsViewModel::class.java)
        binding.listsViewModel = listsViewModel
        binding.lifecycleOwner = this
        return binding.root
    }
}