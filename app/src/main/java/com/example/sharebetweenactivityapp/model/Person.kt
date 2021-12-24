package com.example.sharebetweenactivityapp.model

import java.io.Serializable

class Person(var name: String, var surname: String) : Serializable {
    override fun toString(): String {
        return "Person[name= $name, surname= $surname]"
    }
}