package cz.stanislav.vyvoyconnect.model

import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*

@Entity
data class Vacancy(
    @Id val id: UUID,
    val name: String,
    val activeFrom: LocalDate,
    val activeTo: LocalDate,
)
