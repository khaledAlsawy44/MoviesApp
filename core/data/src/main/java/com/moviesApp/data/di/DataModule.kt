package com.moviesApp.data.di

import com.moviesApp.data.repos.MovieDetailsRepository
import com.moviesApp.data.repos.MovieDetailsRepositoryImp
import com.moviesApp.data.repos.MoviesListRepository
import com.moviesApp.data.repos.MoviesListRepositoryImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    fun bindsMoviesListRepo(repo: MoviesListRepositoryImp): MoviesListRepository

    @Binds
    fun bindsMovieDetailsRepo(repo: MovieDetailsRepositoryImp): MovieDetailsRepository

}

