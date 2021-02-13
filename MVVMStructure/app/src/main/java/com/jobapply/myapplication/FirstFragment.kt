package com.jobapply.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.jobapply.myapplication.viewmodels.NewsViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class FirstFragment : Fragment() {

    lateinit var mViewModel: NewsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mViewModel = (activity as MainActivity).mViewModel
        val view = inflater.inflate(R.layout.fragment_first, container, false)

        var job: Job? = null
        view.findViewById<EditText>(R.id.et_first).addTextChangedListener { editTable ->
            job?.cancel()
            job = MainScope().launch {
                delay(5000)
                if (editTable.toString().isNotEmpty()) {

                }
            }
        }

        mViewModel.breakingNews.observe(viewLifecycleOwner, Observer { resultResponse ->
//            when(resultResponse) {
//                is Resource.Success ->
//
//            }

        })
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_first).setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }
}