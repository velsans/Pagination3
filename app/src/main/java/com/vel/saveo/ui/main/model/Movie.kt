package com.vel.saveo.ui.main.model

import java.util.ArrayList

class Movie {
    var title: String? = null
    constructor(title: String?) {
        this.title = title
    }
    companion object {
        fun createMovies(itemCount: Int): List<Movie> {
            val movies: MutableList<Movie> = ArrayList()
            for (i in 0..9) {
                val movie = Movie("Movie " + if (itemCount == 0) itemCount + 1 + i else itemCount + i)
                movies.add(movie)
            }
            return movies
        }
    }
}