package com.example.tdd.router

import java.io.Serializable

data class Route(val path: String, val params: List<Serializable>? = null)
