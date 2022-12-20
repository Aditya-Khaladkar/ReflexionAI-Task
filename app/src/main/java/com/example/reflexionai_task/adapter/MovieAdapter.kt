package com.example.reflexionai_task.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.reflexionai_task.R
import com.example.reflexionai_task.model.MovieModel
import com.example.reflexionai_task.view.MovieDetails

class MovieAdapter(private val movieList: List<MovieModel>) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val movie_poster = itemView.findViewById<ImageView>(R.id.movie_poster)
        val movie_title = itemView.findViewById<TextView>(R.id.movie_title)
        val movie_release_date = itemView.findViewById<TextView>(R.id.movie_release_date)
        val movieLayout = itemView.findViewById<ConstraintLayout>(R.id.movieLayout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_list, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val item = movieList[position]
        holder.movie_title.text = item.title
        holder.movie_release_date.text = item.year
        Glide.with(holder.movie_poster.context)
            .load(item.moviePoster)
            .into(holder.movie_poster)
        holder.movieLayout.setOnClickListener {
            val intent = Intent(holder.movieLayout.context, MovieDetails::class.java)
            intent.putExtra("movieImg", item.moviePoster)
            intent.putExtra("rating", item.rating)
            intent.putExtra("summary", item.summery)
            holder.movieLayout.context.startActivity(intent)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        }
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

}