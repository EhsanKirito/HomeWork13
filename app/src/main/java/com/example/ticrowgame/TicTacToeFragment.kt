package com.example.ticrowgame

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.ticrowgame.databinding.FragmentTicTacToeBinding

class TicTacToeFragment : Fragment(R.layout.fragment_tic_tac_toe) {
        val viewModel: TicTacToeViewModel by viewModels()
        lateinit var binding: FragmentTicTacToeBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DataBindingUtil.bind(view)!!
    }

}