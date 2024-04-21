package ru.gb;

import com.google.gson.Gson;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        Person person = new Person( "Ivan", "Ivanov", 30);
        System.out.println( person.toString());

        Person person2 = new Person( "Ivan", "Ivanov", 30);
        System.out.println( person2.toString());

        // проверяем равны ли обьекты
        if (person.equals(person2)) {
            System.out.println("Объекты равны");
        } else {
            System.out.println("Объекты не равны");
        }

        // выводим хэш код обьекта

        System.out.println(person.hashCode());
        System.out.println(person2.hashCode());

        // сериализация обьекта

        Gson gson = new Gson();

        String jsonString = gson.toJson(person);
        System.out.println(jsonString);


        // десериализация обьекта

        Person p = gson.fromJson(jsonString, Person.class);
        System.out.println(p.toString());

    }

}

