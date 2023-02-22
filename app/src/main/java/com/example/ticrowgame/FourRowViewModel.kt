package com.example.ticrowgame

import androidx.lifecycle.ViewModel

class FourRowViewModel : ViewModel() {
    var counter = 1
    val rowCount = 5
    val btnCount = rowCount*rowCount
    var playMatrix = Array(rowCount*rowCount){0}
    var gameState = ""


//int returned is the index if the button which should be colored
    fun turnPlayed(pos:Int){
        val row = pos%rowCount
        for (i in btnCount-1 downTo 0){
            if (i%rowCount == row){
                if (playMatrix[i]==0) {
                    playMatrix[i]= (counter%2)+1
                    counter++
                    break
                }
            }
        }
    }

    fun seeIfWonHorizontal():Boolean {
        var winCounter = 0
        for (i in 0 until rowCount) {

            for (j in 0 until rowCount - 1) {
                if (playMatrix[rowCount * i + j] == playMatrix[rowCount * i + j + 1] &&
                    playMatrix[rowCount * i + j] != 0 && playMatrix[rowCount * i + j + 1] != 0
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

    fun seeIfWonVertical():Boolean {
        var winCounter = 0
        for (i in 0 until rowCount) {
            for (j in 0 until rowCount - 1) {
                if(playMatrix[rowCount*j+i]== playMatrix[rowCount*(j+1)+i] &&
                    playMatrix[rowCount*j+i]!=0 && playMatrix[rowCount*(j+1)+i]!=0){
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

    fun seeIfWonDiagonalOne():Boolean {
        var winCounter = 0
        for (i in 0..rowCount - 4) {
            for (j in 1 until rowCount - 4) {
                if(playMatrix[rowCount*j+i]== playMatrix[rowCount*(j+1)+i] &&
                    playMatrix[rowCount*j+i]!=0 && playMatrix[rowCount*(j+1)+i]!=0){
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

    fun fetchData(num:Int):ArrayList<Int>{
        val item = ArrayList<Int>()
        for (i in 0..num) item.add(i)
        return item
    }
}