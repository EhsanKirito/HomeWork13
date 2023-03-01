package com.example.ticrowgame

import androidx.lifecycle.ViewModel

class FourRowViewModel : ViewModel() {
    var counter = 1
    companion object {
        var rowCount = 5
    }
    val btnCount = rowCount * rowCount
    var playMatrix = Array(btnCount) { 0 }


    //int returned is the index if the button which should be colored
    fun turnPlayed(pos: Int) {
        val row = pos % rowCount
        for (i in btnCount - 1 downTo 0) {
            if (i % rowCount == row) {
                if (playMatrix[i] == 0) {
                    playMatrix[i] = (counter % 2) + 1
                    counter++
                    break
                }
            }
        }
    }

    fun seeIfWonHorizontal(): Boolean {
        var winCounter = 0
        for (i in 0 until rowCount) {

            for (j in 0 until rowCount - 1) {
                if (playMatrix[rowCount * i + j] == playMatrix[rowCount * i + j + 1] &&
                    playMatrix[rowCount * i + j] != 0
                ) {
                    winCounter++
                    if (winCounter >= 3) {
                        return true
                    }
                } else {
                    winCounter = 0
                }
            }
        }
        return false
    }

    fun seeIfWonVertical(): Boolean {
        var winCounter = 0
        for (i in 0 until rowCount) {
            for (j in 0 until rowCount - 1) {
                if (playMatrix[rowCount * j + i] == playMatrix[rowCount * (j + 1) + i] &&
                    playMatrix[rowCount * j + i] != 0
                ) {
                    winCounter++
                    if (winCounter >= 3) {
                        return true
                    }
                } else {
                    winCounter = 0
                }
            }
        }
        return false
    }

    fun seeIfWonDiagonalOne(): Boolean {
        var winCounter = 0
        for (i in 0..rowCount - 4) {
            var j = i
            while (j <= btnCount - rowCount - 2) {
                if (playMatrix[j] == playMatrix[rowCount + 1 + j] &&
                    playMatrix[j] != 0
                ) {
                    winCounter++
                    if (winCounter >= 3) {
                        return true
                    }
                } else {
                    winCounter = 0
                }
                j += rowCount + 1
            }
        }
        for (i in 1..rowCount - 4) {
            var j = i * rowCount
            while (j <= btnCount - rowCount - 2) {
                if (playMatrix[j] == playMatrix[rowCount + 1 + j] &&
                    playMatrix[j] != 0
                ) {
                    winCounter++
                    if (winCounter >= 3) {
                        return true
                    }
                } else {
                    winCounter = 0
                }
                j += rowCount + 1
            }
        }

        return false
    }

    fun seeIfWonDiagonalTwo(): Boolean {
        var winCounter = 0
        for (i in btnCount - rowCount..btnCount - 4) {
            var j = i
            while (j >= 2 * rowCount - 2) {
                if (playMatrix[j] == playMatrix[j - rowCount + 1] &&
                    playMatrix[j] != 0
                ) {
                    winCounter++
                    if (winCounter >= 3) {
                        return true
                    }
                } else {
                    winCounter = 0
                }
                j -= rowCount - 1
                if (j % rowCount == rowCount - 1) {
                    winCounter = 0
//                    break
                }
            }
        }
        winCounter = 0
        for (i in 3..rowCount - 2) {
            var j = i * rowCount
            while (j >= rowCount - 1) {
                if (playMatrix[j] == playMatrix[j - rowCount + 1] &&
                    playMatrix[j] != 0
                ) {
                    winCounter++
                    if (winCounter >= 3) {
                        return true
                    }
                } else {
                    winCounter = 0
                }
                j = j - rowCount + 1
                if (j % rowCount == rowCount - 1) { // break if it is on the right button
                    winCounter = 0
//                    break
                }
            }
        }
        return false
    }

    fun fetchData(num: Int): ArrayList<Int> {
        val item = ArrayList<Int>()
        for (i in 0..num) item.add(i)
        return item
    }
}