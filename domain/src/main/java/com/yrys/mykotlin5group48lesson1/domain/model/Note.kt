package com.yrys.mykotlin5group48lesson1.domain.model

class Note(
    val id: Int = DEFAULT_ID,
    val title: String,
    val description: String,
    val createdAt: Long
) {
    companion object {
        const val DEFAULT_ID = 0
    }
}
