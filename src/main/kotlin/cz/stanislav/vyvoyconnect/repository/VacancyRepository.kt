package cz.stanislav.vyvoyconnect.repository

import cz.stanislav.vyvoyconnect.model.Vacancy
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface VacancyRepository: JpaRepository<Vacancy, UUID> {
    @Query("SELECT v " +
            "FROM Vacancy v " +
            "WHERE v.activeFrom <= CURRENT_DATE " +
            "AND v.activeTo >= CURRENT_DATE")
    fun getActiveVacancies(): List<Vacancy>
}