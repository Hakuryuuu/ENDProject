package com.android.example.project

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.android.example.project.database.Database
import com.android.example.project.databinding.FragmentAddBinding

class AddFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var binding = DataBindingUtil.inflate<FragmentAddBinding>(
            inflater,
            R.layout.fragment_add,
            container,
            false
        )


        val application = requireNotNull(this.activity).application
        val dataSource = Database.getInstance(application).databaseDao
        val addViewModelFactory = AddViewModelFactory(dataSource,binding,application)
        val addViewModel =
            ViewModelProvider(this, addViewModelFactory).get(AddViewModel::class.java)
        binding.addViewModel = addViewModel
        binding.lifecycleOwner = this

        return binding.root
    }

}
