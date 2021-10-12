package com.vel.saveo.ui.main.response

/**
 * Created by Velmurugan on 10/12/2021.
 */
data class RickAndMortyList(val info: Info, val results: List<CharacterData>)
data class CharacterData(val name: String?, val species: String?, val image: String?)
data class Info(val count: Int?, val pages: String?, val next: String?, val prev: String?)
