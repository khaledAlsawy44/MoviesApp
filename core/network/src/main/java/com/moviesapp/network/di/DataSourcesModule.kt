package com.moviesapp.network.di

import com.moviesapp.network.dataSources.MoviesDetailsDataSource
import com.moviesapp.network.dataSources.MoviesDetailsDataSourceImpl
import com.moviesapp.network.dataSources.MoviesListDataSource
import com.moviesapp.network.dataSources.MoviesListDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataSourcesModule {
    @Binds
    fun bindsMoviesRemoteDataSource(remoteDataSource: MoviesListDataSourceImpl): MoviesListDataSource

    @Binds
    fun bindsMovieDetailsRemoteDataSource(remoteDataSource: MoviesDetailsDataSourceImpl): MoviesDetailsDataSource
}