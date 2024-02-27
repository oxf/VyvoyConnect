package cz.stanislav.vyvoyconnect.service

import cz.stanislav.vyvoyconnect.dto.CreateUserDto
import cz.stanislav.vyvoyconnect.dto.CreateVacancyDto
import cz.stanislav.vyvoyconnect.model.Role
import cz.stanislav.vyvoyconnect.model.AppUser
import cz.stanislav.vyvoyconnect.model.Vacancy
import cz.stanislav.vyvoyconnect.repository.UserRepository
import cz.stanislav.vyvoyconnect.repository.VacancyRepository
import org.hibernate.type.descriptor.DateTimeUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*

@Service
class VacancyService(
    @Autowired val vacancyRepository: VacancyRepository
) {
    fun getAll(): List<Vacancy> {
        return vacancyRepository.findAll()
    }

    fun getById(id: UUID): Optional<Vacancy> {
        return vacancyRepository.findById(id)
    }

    fun getActiveVacancies(): List<Vacancy> {
        return vacancyRepository.getActiveVacancies()
    }

    fun createVacancy(createVacancyDto: CreateVacancyDto): Vacancy {
        val vacancyToCreate = Vacancy(
            id = UUID.randomUUID(),
            name = createVacancyDto.name,
            activeFrom = LocalDate.now(),
            activeTo = LocalDate.now().plusDays(30)
        )
        return vacancyRepository.save(vacancyToCreate)
    }


}
