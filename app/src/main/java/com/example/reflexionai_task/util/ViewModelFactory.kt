package com.example.reflexionai_task.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.reflexionai_task.repository.MovieRepository
import com.example.reflexionai_task.viewmodel.MovieViewModel

class ViewModelFactory(private val repository: MovieRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MovieViewModel(repository = repository) as T
    }
}