package com.plcoding.jetpackcomposepokedex.repository

import com.plcoding.jetpackcomposepokedex.data.remote.PokeAPI
import com.plcoding.jetpackcomposepokedex.data.remote.responses.Pokemon
import com.plcoding.jetpackcomposepokedex.data.remote.responses.PokemonList
import com.plcoding.jetpackcomposepokedex.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class PokemonRepository @Inject constructor(
    /** We injected the API to be used in the repository**/
    private val api: PokeAPI

) {

    /** invocation of getPokemonList with an try/catch using a Resource defined in our util package for error handling
     *
     * The Resource comes from a sealed class with 3 different classes inheriting for successes, error, loading
     * **/
    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList> {
        val response = try {
            api.getPokemonList(limit, offset)
        } catch (e: Exception) {
            return Resource.Error("An unknown error occurred")
        }
        return Resource.Success(response)
    }

    /** invocation of getPokemonList with an try/catch using a Resource defined in our util package for error handling
     *
     * The Resource comes from a sealed class with 3 different classes inheriting for successes, error, loading
     * **/
    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {
        val response = try {
            api.getPokemonInfo(pokemonName)
        } catch (e: Exception) {
            return Resource.Error("An unknown error occurred")
        }
        return Resource.Success(response)
    }

}