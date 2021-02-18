package com.jobapply.myapplication

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.jobapply.myapplication.adapters.MyRecyclerViewAdapter
import com.jobapply.myapplication.databinding.FragmentFirstBinding
import com.jobapply.myapplication.db.AppDatabase
import com.jobapply.myapplication.factories.NewsFactoryCls
import com.jobapply.myapplication.model.Article
import com.jobapply.myapplication.repositories.NewsRepository
import com.jobapply.myapplication.viewmodels.NewsViewModel
import javax.inject.Inject

class FirstFragment : Fragment() {

    lateinit var mViewModel: NewsViewModel
    lateinit var mBinding: FragmentFirstBinding

    @Inject
    lateinit var database: AppDatabase

    @Inject
    lateinit var repository: NewsRepository

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        MyApplication.appComponent.inject(this)
        val factory = NewsFactoryCls(repository)

        // ViewModel
        mViewModel = ViewModelProvider(this, factory).get(NewsViewModel::class.java)

        mBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_first, container, false
        )
        mBinding.myViewmodel = mViewModel
        mBinding.lifecycleOwner = activity
        initView()
        return mBinding.root
    }

    fun initView() {
        mBinding.rvListDetails.layoutManager = LinearLayoutManager(activity)
        displayRecycleData()

    }

    /**
     * Get Data from Api and Display.
     */
    private fun displayRecycleData() {
        mViewModel.dbBreakingNewsResp.observe(viewLifecycleOwner, Observer { resultResponse ->
            resultResponse.data?.let {
                for (i in 0 until it.size) {
                    Log.e("testing::", "$i =" + it[i].author)
                }
                mBinding.rvListDetails.adapter =
                    MyRecyclerViewAdapter(
                        it,
                        { selectedItem: Article -> listItemClicked(selectedItem) })
            }

        })
    }

    private fun listItemClicked(selectedItem: Article) {
        Log.e("listener Clicked", "" + selectedItem.author)
    }


//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        view.findViewById<Button>(R.id.button_first).setOnClickListener {
//            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
//        }
//    }

// Todo check how MainScope work.
//        var job: Job? = null
//        view.findViewById<EditText>(R.id.et_first).addTextChangedListener { editTable ->
//            job?.cancel()
//            job = MainScope().launch {
//                delay(1000)
//                if (editTable.toString().isNotEmpty()) {
//                    Log.e("editField", editTable.toString())
//                }
//            }
//        }
}