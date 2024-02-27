package cz.stanislav.vyvoyconnect.controller

import cz.stanislav.vyvoyconnect.dto.CreateUserDto
import cz.stanislav.vyvoyconnect.dto.CreateVacancyDto
import cz.stanislav.vyvoyconnect.model.Role
import cz.stanislav.vyvoyconnect.model.AppUser
import cz.stanislav.vyvoyconnect.model.Vacancy
import cz.stanislav.vyvoyconnect.service.UserService
import cz.stanislav.vyvoyconnect.service.VacancyService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/vacancy")
class VacancyController(@Autowired val vacancyService: VacancyService) {

    @GetMapping
    fun getAllVacancies(): List<Vacancy> {
        return vacancyService.getAll()
    }
    @GetMapping("/{Id}")
    fun getVacancyById(@PathVariable id: UUID): Optional<Vacancy> {
        return vacancyService.getById(id)
    }
    @GetMapping("/active")
    fun getActiveVacancies(): List<Vacancy> {
        return vacancyService.getActiveVacancies()
    }
    @PostMapping
    fun postUser(@RequestBody createVacancyDto: CreateVacancyDto): Vacancy {
        return vacancyService.createVacancy(createVacancyDto)
    }
}