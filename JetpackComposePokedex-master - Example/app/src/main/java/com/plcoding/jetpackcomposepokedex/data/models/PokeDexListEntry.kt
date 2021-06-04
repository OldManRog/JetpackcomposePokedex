package com.plcoding.jetpackcomposepokedex.data.models

/** This is the data class for the entries in the list view that holds the pokemon **/
data class PokeDexListEntry (
    val pokemonName: String,
    val imageUrl: String,
    val number: Int
)
