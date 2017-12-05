package com.example.learnandlunch.user

import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService {

    companion object {
        var users = arrayListOf<User>()
        var usersCount = 3

        init {
            users.add(User(1, "Adam", Date()))
            users.add(User(2, "Eve", Date()))
            users.add(User(3, "Dieu", Date()))
        }
    }

    fun findOne(id: Int) = users.firstOrNull { it.id == id }

    fun findAll() = users

    fun save(_user: User): User {
        val user = _user.copy()

        if (user.id == null) {
            user.id = ++usersCount
        }

        users.add(user)

        return user
    }

    fun deleteById(id: Int) = users.removeIf { it.id == id }
}