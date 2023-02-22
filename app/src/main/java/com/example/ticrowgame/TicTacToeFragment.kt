package com.example.ticrowgame

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.ticrowgame.databinding.FragmentTicTacToeBinding

class TicTacToeFragment : Fragment(R.layout.fragment_tic_tac_toe) {
        val viewModel: TicTacToeViewModel by viewModels()
        lateinit var binding: FragmentTicTacToeBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DataBindingUtil.bind(view)!!


        val ehsan = "Blue"
        val ali = "Red"
        val btnList = listOf<Button>(
            binding.btn1, binding.btn2, binding.btn3, binding.btn4, binding.btn5,
            binding.btn6, binding.btn7, binding.btn8, binding.btn9
        )

        fun stopClicks() {
            for (i in btnList) i.isClickable = false
        }
        fun startClicks() {
            for (i in btnList) i.isClickable = true
        }

        binding.btnReset.setOnClickListener {
            viewModel.resetGame()
            startClicks()
            for (i in btnList) i.text = " "
            binding.txtTurnWinner.text = "$ehsan's turn"
        }
        fun playTheGame(selected: Int, btn: Button) {
            viewModel.selected = selected
            if (viewModel.turnCounter.value?.rem(2)?.equals(1) == true) btn.text = "X"
            if (viewModel.turnCounter.value?.rem(2)?.equals(0) == true) btn.text = "O"
            btn.isClickable = false
            viewModel.nextTurn(viewModel.selected)

        }

        for (i in btnList) {
            i.setOnClickListener {
                playTheGame(btnList.indexOf(i) + 1, i)
                if (viewModel.statusA){
                    stopClicks()
                    binding.txtTurnWinner.text = "Winner is $ehsan"
                } else if (viewModel.statusB) {
                    stopClicks()
                    binding.txtTurnWinner.text = "Winner is $ali"
                }
            }
        }



        viewModel.turnCounter.observe(viewLifecycleOwner) {
            viewModel.gameStatus.observe(viewLifecycleOwner) {
                if (it) {
                    if (viewModel.turnCounter.value?.rem(2)?.equals(1) == true) {
                        binding.txtTurnWinner.text = "$ehsan's turn"
                    } else {
                        binding.txtTurnWinner.text = "$ali's turn"
                    }
                } else {
                    binding.txtTurnWinner.text = "Game is Draw"
                    stopClicks()
                }
            }
        }


    }

}