package com.tc.kmp.tutorial.network

import kotlinx.serialization.Serializable

/**
 *
 * {
 *     "userId": 1,
 *     "id": 1,
 *     "title": "delectus aut autem",
 *     "completed": false
 *   },
 */


@Serializable
data class TodoDTO(
    val id: Int,
    val userId: Int,
    val title: String,
    val completed: Boolean
)
