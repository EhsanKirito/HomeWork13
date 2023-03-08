package com.example.mytodolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.activityViewModels

class ToDoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_to_do)

    }
    companion object{
        const val tagUserName = "USERNAME"
        const val tagNumberOfTasks = "NUMBER_OF_TASKS"
    }
}