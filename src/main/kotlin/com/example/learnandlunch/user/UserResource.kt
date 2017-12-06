package com.example.learnandlunch.user

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder

@RestController
@RequestMapping("/api/v1")
class UserResource(
        val userService: UserService
) {

    @GetMapping("/users")
    fun getAllUsers() = userService.findAll()

    @GetMapping("/users/{id}")
    fun getUserById(@PathVariable id: Int) = userService.findOne(id) ?: throw UserNotFoundException("id-$id")

    @PostMapping("/users")
    fun createUser(@RequestBody user: User): ResponseEntity<Any> {
        val newUser = userService.save(user)
        val locationUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newUser.id)
                .toUri()

        return ResponseEntity.created(locationUri).build()
    }

    fun deleteUser() {
        // TODO: 2) implémenter la méthode deleteUser
    }
}

