package com.example.ticrowgame

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ticrowgame.databinding.FragmentFourRowBinding

class FourRowFragment : Fragment(R.layout.fragment_four_row) {

    val viewModel: FourRowViewModel by viewModels()
    private lateinit var binding:FragmentFourRowBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DataBindingUtil.bind(view)!!
        val numberOfColumns = FourRowViewModel.rowCount  // in order to change dimension this variable needs to be changed as well
        val rcView: RecyclerView = binding.recyclerView
        val adaptor = Adaptor(viewModel.fetchData(numberOfColumns*numberOfColumns-1))
        rcView.layoutManager = GridLayoutManager(context, numberOfColumns)
        rcView.adapter = adaptor

    }

}