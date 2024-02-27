package cz.stanislav.vyvoyconnect.repository

import cz.stanislav.vyvoyconnect.model.Role
import cz.stanislav.vyvoyconnect.model.AppUser
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository: JpaRepository<AppUser, UUID> {
    fun findUsersByRole(role: Role): List<AppUser>
}