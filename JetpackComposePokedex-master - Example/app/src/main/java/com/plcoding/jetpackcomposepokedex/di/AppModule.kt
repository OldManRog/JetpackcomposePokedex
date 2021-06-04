package com.plcoding.jetpackcomposepokedex.di

import com.plcoding.jetpackcomposepokedex.data.remote.PokeAPI
import com.plcoding.jetpackcomposepokedex.repository.PokemonRepository
import com.plcoding.jetpackcomposepokedex.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
/** Means it will live till our application is alive**/
@InstallIn(SingletonComponent::class)
object AppModule {

    /** Dependency that will provide us with the Repository that holds the API functions to be used**/
    @Singleton
    @Provides
    fun providePokemonRepository(api: PokeAPI) = PokemonRepository(api)

    /** Dependency that will provide us with the instance of the PokeAPI **/
    @Singleton
    @Provides
    fun providePokeApi(): PokeAPI {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(PokeAPI::class.java)
    }

}