package com.wyl.componentapp

import java.io.Serializable

data class Bean(
    val name: String,
    val age: Int/*,
    val xx: String?*/
) : Serializable {
    companion object {
        private const val serialVersionUID = 1L
    }

}