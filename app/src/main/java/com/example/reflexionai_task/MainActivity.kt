package com.example.reflexionai_task

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.reflexionai_task.databinding.ActivityMainBinding
import com.example.reflexionai_task.repository.MovieRepository
import com.example.reflexionai_task.util.ViewModelFactory
import com.example.reflexionai_task.viewmodel.MovieViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityMainBinding
    private val repository = MovieRepository()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        val view = _binding.root
        setContentView(view)

        _binding.recyclerView.layoutManager = LinearLayoutManager(this)
        _binding.recyclerView.setHasFixedSize(true)

        val factory = ViewModelFactory(repository)
        val viewModel: MovieViewModel = ViewModelProvider(this, factory)[MovieViewModel::class.java]
        viewModel.getAllMovies(
            context = this,
            recyclerView = _binding.recyclerView
        )
    }
}