package cz.stanislav.vyvoyconnect.dto

data class CreateUserDto(
    val username: String,
    val password: String,
    val email: String,
    val role: String
)
