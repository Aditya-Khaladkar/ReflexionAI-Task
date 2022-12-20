package com.example.reflexionai_task.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.RecyclerView
import com.example.reflexionai_task.repository.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MovieViewModel(private val repository: MovieRepository) : ViewModel() {

    fun getAllMovies(
        context: Context, recyclerView: RecyclerView
    ) {
        GlobalScope.launch(Dispatchers.IO) {
            repository.getAllMovies(context, recyclerView)
        }
    }
}