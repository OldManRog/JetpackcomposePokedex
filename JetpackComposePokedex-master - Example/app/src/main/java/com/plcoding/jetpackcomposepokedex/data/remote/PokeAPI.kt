package com.plcoding.jetpackcomposepokedex.data.remote

import com.plcoding.jetpackcomposepokedex.data.remote.responses.Pokemon
import com.plcoding.jetpackcomposepokedex.data.remote.responses.PokemonList
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokeAPI {

    /** API to get a list of pokemon, This takes in a starting pokemon in the list based on the number in the
     sequence and the amount of pokemon per page as query parameters. This will return a Pokemon List **/
    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit:Int,
        @Query("offset") offset:Int
    ): PokemonList

    /** API to get single pokemon & details. This takes in a dynamic path being the Pokemon name & returns a Pokemon **/
    @GET("pokemon/{name}")
    suspend fun getPokemonInfo(
        @Path("name") name:String
    ): Pokemon
}