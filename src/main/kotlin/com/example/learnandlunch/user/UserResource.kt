package com.example.learnandlunch.user

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1")
class UserResource(
        val userService: UserService
) {

    @GetMapping("/users")
    fun getAllUsers() = userService.findAll()

    @GetMapping("/users/{id}")
    fun getUserById(@PathVariable id: Int) = userService.findOne(id) ?: throw UserNotFoundException("id-$id")

    fun createUser() {
        // TODO: 1) implémenter la méthode createUser
    }

    fun deleteUser() {
        // TODO: 2) implémenter la méthode deleteUser
    }
}

