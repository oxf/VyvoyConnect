package cz.stanislav.vyvoyconnect.service

import cz.stanislav.vyvoyconnect.dto.CreateUserDto
import cz.stanislav.vyvoyconnect.model.Role
import cz.stanislav.vyvoyconnect.model.AppUser
import cz.stanislav.vyvoyconnect.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(
        @Autowired val userRepository: UserRepository
) {
    fun getAll(): List<AppUser> {
        return userRepository.findAll()
    }
    fun getById(id: UUID): Optional<AppUser> {
        return userRepository.findById(id)
    }
    fun getByRole(role: Role): List<AppUser> {
        return userRepository.findUsersByRole(role)
    }

    fun createUser(createUserDto: CreateUserDto): AppUser {
        val appUserToCreate = AppUser(
                id = UUID.randomUUID(),
                username = createUserDto.username,
                email = createUserDto.email,
                password = createUserDto.password,
                role =createUserDto.role
        )
        return userRepository.save(appUserToCreate)
    }


}
