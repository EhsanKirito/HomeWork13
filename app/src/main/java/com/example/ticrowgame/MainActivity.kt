package com.example.ticrowgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.add
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.fourRow).setOnClickListener {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<FourRowFragment>(R.id.FragmentCont)
            }
        }
        findViewById<Button>(R.id.ticTacToe).setOnClickListener {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<TicTacToeFragment>(R.id.FragmentCont)
            }
        }
    }

}