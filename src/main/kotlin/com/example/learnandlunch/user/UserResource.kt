package com.example.learnandlunch.user

import org.springframework.web.bind.annotation.RestController

@RestController
class UserResource(
        val userService: UserService
) {

    fun getAllUsers() {
        // TODO: 1) implémenter le getAllUsers
    }

    fun getUserById() {
        // TODO: 2) implémenter le getUserById
    }
}