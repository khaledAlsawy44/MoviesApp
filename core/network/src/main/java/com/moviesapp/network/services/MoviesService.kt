package com.moviesapp.network.services

import com.moviesapp.network.API_MOVIES_LIST
import com.moviesapp.network.API_MOVIE_DETAILS
import com.moviesapp.network.PARAMETER_MOVIE_ID
import com.moviesapp.network.entities.MovieDetailsResponse
import com.moviesapp.network.entities.MovieResponse
import com.moviesapp.network.entities.PaginationResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesService {
    @GET(API_MOVIES_LIST)
    suspend fun fetchMoviesList(
        @Query("page") page: Int? = null,
        @Query("sort_by") sort: String? = "title.asc"
    ): Response<PaginationResponse<MovieResponse>>

    @GET("$API_MOVIE_DETAILS/{$PARAMETER_MOVIE_ID}")
    suspend fun fetchMovieById(
        @Path(value = PARAMETER_MOVIE_ID) movieId: Int
    ): Response<MovieDetailsResponse>

}
