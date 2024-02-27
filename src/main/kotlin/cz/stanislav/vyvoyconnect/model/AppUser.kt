package cz.stanislav.vyvoyconnect.model

import jakarta.persistence.Entity
import jakarta.persistence.Id
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.*

@Entity
data class AppUser(@Id val id: UUID,
                   val username: String,
                   val password: String,
                   val email: String,
                   val role: String)
