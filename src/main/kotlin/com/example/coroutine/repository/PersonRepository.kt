package com.example.coroutine.repository

import com.example.coroutine.data.table.Person
import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface PersonRepository : CoroutineCrudRepository<Person, Long> {


    override suspend fun findById(id: Long) : Person?

    suspend fun save(person: Person) : Person
}