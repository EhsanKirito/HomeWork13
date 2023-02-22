package com.example.ticrowgame

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TicTacToeViewModel : ViewModel() {
    var selected: Int = 0
    var gameStatus = MutableLiveData(true)
    var turnCounter = MutableLiveData(1)
    var playerOne = mutableListOf<Int>()
    var playerTwo = mutableListOf<Int>()
    var statusA = checkWinner(playerOne)
    var statusB = checkWinner(playerTwo)

    fun resetGame() {
        gameStatus.value = true
        turnCounter.value = 1
        playerOne.removeAll(playerOne)
        playerTwo.removeAll(playerTwo)
    }

    fun nextTurn(selected: Int) {
        if (turnCounter.value?.rem(2)?.equals(1) == true) playerOne.add(selected)
        if (turnCounter.value?.rem(2)?.equals(0) == true) playerTwo.add(selected)
        turnCounter.value = turnCounter.value?.plus(1)
        if (turnCounter.value!! > 9) gameStatus.value = false
        statusA = checkWinner(playerOne)
        statusB = checkWinner(playerTwo)
    }

    fun checkWinner(playerList: List<Int>): Boolean {
        var result = false
        var num = 0
        val winCondition = mutableListOf<List<Int>>(
            listOf(1, 2, 3), listOf(4, 5, 6), listOf(7, 8, 9),
            listOf(1, 4, 7), listOf(2, 5, 8), listOf(3, 6, 9),
            listOf(1, 5, 9), listOf(3, 5, 7)
        )
        for (i in winCondition) {
            for (j in i) {
                if (playerList.contains(j)) {
                    num++
                }
            }
            if (num == 3) {
                result = true
                break
            } else {
                num = 0
            }
        }
        return result
    }
}