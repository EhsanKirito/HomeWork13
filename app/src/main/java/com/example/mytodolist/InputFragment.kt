package com.example.mytodolist

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.mytodolist.databinding.FragmentInputBinding


class InputFragment : Fragment(R.layout.fragment_input) {

    private lateinit var binding: FragmentInputBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DataBindingUtil.bind(view)!!



        binding.button.setOnClickListener {
            val goToNextActivityIntent = Intent(this.context, ToDoActivity::class.java).apply {
                putExtra(ToDoActivity.tagUserName, binding.txtName.text.toString())
                putExtra(ToDoActivity.tagNumberOfTasks, binding.txtNumberOfTasks.text.toString())
            }
            startActivity(goToNextActivityIntent)
        }


    }
}