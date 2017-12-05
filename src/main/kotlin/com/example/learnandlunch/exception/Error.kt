package com.example.learnandlunch.exception

import java.util.Date

data class Error(
        val timestamp: Date,
        val message: String?,
        val details: String
)