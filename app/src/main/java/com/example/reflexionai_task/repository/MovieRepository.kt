package com.example.reflexionai_task.repository

import android.content.Context
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.reflexionai_task.adapter.MovieAdapter
import com.example.reflexionai_task.model.MovieModel

class MovieRepository {
    fun getAllMovies(context: Context, recyclerView: RecyclerView) {
        val queue = Volley.newRequestQueue(context)
        val url = "https://task.auditflo.in/1.json"

        // default
        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url, null,
            { response ->
                val movieJsonArray = response.getJSONArray("Movie List")
                val movieArray = ArrayList<MovieModel>()
                for (i in 0 until movieJsonArray.length()) {
                    val movieJsonObject = movieJsonArray.getJSONObject(i)
                    val movieModel = MovieModel(
                        movieJsonObject.getString("Title"),
                        movieJsonObject.getString("Movie Poster"),
                        movieJsonObject.getString("Year"),
                        movieJsonObject.getString("Rating"),
                        movieJsonObject.getString("Summary")
                    )
                    movieArray.add(movieModel)
                }
                val adapter = MovieAdapter(movieArray)
                recyclerView.adapter = adapter
            },
            {
                Toast.makeText(context, "getRespond() : false", Toast.LENGTH_LONG).show()
            })

        queue.add(jsonObjectRequest)
    }
}