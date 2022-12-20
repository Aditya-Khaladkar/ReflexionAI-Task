package com.example.reflexionai_task.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.reflexionai_task.R
import com.example.reflexionai_task.databinding.ActivityMovieDetailsBinding

class MovieDetails : AppCompatActivity() {
    private lateinit var _binding: ActivityMovieDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMovieDetailsBinding.inflate(layoutInflater)
        val view = _binding.root
        setContentView(view)

        // GET INTENT
        val movieImg = intent.getStringExtra("movieImg")
        val rating = intent.getStringExtra("rating")
        val summary = intent.getStringExtra("summary")

        Glide.with(_binding.movieImg)
            .load(movieImg)
            .into(_binding.movieImg)

        _binding.movieRating.text = "Rating: $rating"
        _binding.movieSummary.text = summary
    }
}