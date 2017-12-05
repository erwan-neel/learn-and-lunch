package com.example.learnandlunch.user

import java.util.Date

data class User(
        var id: Int? = null,
        var name: String,
        var birthday: Date
)