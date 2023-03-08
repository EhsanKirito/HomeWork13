package com.example.mytodolist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mytodolist.databinding.FragmentToDoBinding


class ToDoFragment : Fragment(R.layout.fragment_to_do) {

    private lateinit var binding : FragmentToDoBinding
    private val viewModel : ToDoViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DataBindingUtil.bind(view)!!

        viewModel.username = activity?.intent?.getStringExtra(ToDoActivity.tagUserName).toString()
        val i = activity?.intent?.getStringExtra(ToDoActivity.tagNumberOfTasks)
        if (i != null) {
            viewModel.numberOfTasks.value = i.toInt()
        }

        viewModel.makeTasks()

        val recyclerView: RecyclerView = binding.toDoRecyclerView
        recyclerView.layoutManager = GridLayoutManager(view.context, 2)
        val adaptor = ToDoAdaptor(viewModel.taskList)
        recyclerView.adapter = adaptor

        binding.btnAddTask.setOnClickListener {
            viewModel.numberOfTasks.value = viewModel.numberOfTasks.value?.plus(1)
        }

        viewModel.numberOfTasks.observe(viewLifecycleOwner, Observer {
            viewModel.makeTasks()
            adaptor.notifyDataSetChanged()
            recyclerView.adapter = adaptor
        })
    }

}