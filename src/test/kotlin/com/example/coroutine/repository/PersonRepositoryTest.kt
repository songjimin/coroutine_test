package com.example.coroutine.repository

import com.example.coroutine.config.R2bcConfiguration
import com.example.coroutine.data.table.Person
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit.jupiter.SpringExtension


@ExtendWith(SpringExtension::class)
@ContextConfiguration(classes = [R2bcConfiguration::class, PersonRepository::class])
class PersonRepositoryTest(
    private val personRepository: PersonRepository
) {


    @Test
    @DisplayName("저장 확인")
    suspend fun savePerson() : Unit {
        val person = Person(firstname = "JIMIN", lastname = "SONG")
        val saveData = personRepository.save(person)

        Assertions.assertEquals(saveData.firstname, person.firstname)
    }

//    @BeforeEach
//    fun beforeEach() {
//        databaseClient
//            .execute("delete from person")
//            .fetch()
//            .rowsUpdated()
//            .block()
//    }
//
//    private fun generatePerson(id: Long? = null): Person {
//        return Person(
//            id = id,
//            firstname = UUID.randomUUID().toString(),
//            lastname = UUID.randomUUID().toString()
//        )
//    }
//
//    private fun insertPerson(id: Long? = null): Person {
//        val givenPerson = generatePerson(id)
//        databaseClient.insert().into(Person::class.java)
//            .using(givenPerson)
//            .fetch()
//            .rowsUpdated()
//            .block()
//        return givenPerson
//    }
//
//    @Test
//    fun `test save`() {
//        val person = generatePerson()
//        personRepository.save(person)
//            .`as` { StepVerifier.create(it) }
//            .expectNextCount(1)
//            .verifyComplete()
//
//        val selectOne = databaseClient
//            .execute(
//                """
//                select count(*) from person
//                where firstname='${person.firstname}' and lastname='${person.lastname}'
//            """
//            )
//            .asType<Long>()
//            .fetch()
//            .one()
//
//        StepVerifier
//            .create(selectOne)
//            .expectNext(1)
//            .verifyComplete()
//    }

}