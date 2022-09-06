package com.example.coroutine.controller

import com.example.coroutine.data.table.Person
import com.example.coroutine.repository.PersonRepository
import org.springframework.web.bind.annotation.*


@RestController
class PersonController(
    private val personRepository: PersonRepository
) {

    @GetMapping
    suspend fun getPerson(@RequestParam id : Long) : Person {
        return personRepository.findById(id) ?: Person(firstname = "NO", lastname = "No")
    }

    @PostMapping
    suspend fun getPerson(@RequestBody person : Person) : Person {
        val saveData = personRepository.save(person)
        return saveData;
    }
}