package com.example.daggertest

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.daggertest.databinding.FragmentFirstBinding
import javax.inject.Inject


class Factory @Inject constructor() {

    @Inject
    lateinit var db: DBHelper
//    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//        @Suppress("UNCHECKED_CAST")
//        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//            if (modelClass == FirstViewModel::class.java) {
//                return FirstViewModel(db) as T
//            }
//            throw IllegalArgumentException("Bad ViewModel class")
//        }
//    }
}


class FirstFragment : Fragment(R.layout.fragment_first) {

    private val binding by viewBinding(FragmentFirstBinding::bind)
    //private val viewModel: FirstViewModel by viewModels()

    @Inject
    lateinit var factory: Factory

    override fun onAttach(context: Context) {
        super.onAttach(context)

    }

    override fun onViewCreated(view: View, state: Bundle?) {
        super.onViewCreated(view, state)
        requireContext().appComponent.inject(this)
        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
        //val student = factory.db.getStudent(100)
        binding.textviewFirst.text = "test" //student.name
    }
}