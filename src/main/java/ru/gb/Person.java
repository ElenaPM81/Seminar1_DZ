package ru.gb;

import com.google.gson.Gson;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Objects;

//Создать проект с использованием Maven или Gradle, добавить в него несколько зависимостей и написать код, использующий эти зависимости.
//Пример решения:
//        1. Создайте новый Maven или Gradle проект, через Intellj IDEA.
//        2. Добавьте зависимости org.apache.commons:commons-lang3:3.14.0 и com.google.code.gson:gson:2.10.1.
//        3. Создайте класс Person с полями firstName, lastName и age.
//        4. Используйте библиотеку commons-lang3 для генерации методов toString, equals и hashCode.
//5. Используйте библиотеку gson для сериализации и десериализации объектов класса Person в формат JSON.
public class Person {

        String firstName = "John";
        String lastName = "Doe";
        int age = 30;

    // создаем конструктор
    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    // реализуем геттеры и сеттеры
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    // реализуем метод toString
    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("firstName", firstName)
                .append("lastName", lastName)
                .append("age", age)
                .toString();
    }
    // реализуем метод equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return new EqualsBuilder()
                .append(firstName, person.firstName)
                .append(lastName, person.lastName)
                .append(age, person.age)
                .isEquals();
    }
    // реализуем метод hashCode
    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(firstName)
                .append(lastName)
                .append(age)
                .toHashCode();
    }
    // реализуем метод json
    public String toJson() {
        return new Gson().toJson(this);

    }
    // реализуем метод fromJson
    public boolean fromJson(String json) {
        return new Gson().fromJson(json, Person.class) != null;
    }
}

