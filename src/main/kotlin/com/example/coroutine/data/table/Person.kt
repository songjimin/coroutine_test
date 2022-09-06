package com.example.coroutine.data.table

import org.springframework.data.annotation.Id

data class Person(@Id val id: Long? = null,
                  val firstname: String,
                  val lastname: String)
