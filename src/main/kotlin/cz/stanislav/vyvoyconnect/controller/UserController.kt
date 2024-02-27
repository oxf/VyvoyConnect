package cz.stanislav.vyvoyconnect.controller

import cz.stanislav.vyvoyconnect.dto.CreateUserDto
import cz.stanislav.vyvoyconnect.model.Role
import cz.stanislav.vyvoyconnect.model.AppUser
import cz.stanislav.vyvoyconnect.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/user")
class UserController(@Autowired val userService: UserService) {

    @GetMapping
    fun getAllUsers(): List<AppUser> {
        return userService.getAll()
    }
    @GetMapping("/{Id}")
    fun getUserById(@PathVariable id: UUID): Optional<AppUser> {
        return userService.getById(id)
    }
    @GetMapping("/role/{Role}")
    fun getUserById(@PathVariable role: Role): List<AppUser> {
        return userService.getByRole(role)
    }
    @PostMapping
    fun postUser(@RequestBody createUserDto: CreateUserDto): AppUser {
        return userService.createUser(createUserDto)
    }
}