package com.company.java8.sorting;

import java.util.ArrayList;
import java.util.List;

import static java.util.Comparator.comparing;

public class Sorting {

  static List<Person> persons = new ArrayList<>();

  public static void main(String[] args) {
    persons.add(new Person("Joe", 42));
    persons.add(new Person("Adam", 45));
    persons.add(new Person("Phil", 23));
    persons.add(new Person("Pat", 7));
    persons.add(new Person("Joe", 38));


    persons.stream()
      .sorted(
          comparing(Person::getName)
            .thenComparing(Person::getAge))
      .forEach(System.out::println);


  }

  public static class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
      this.name = name;
      this.age = age;
    }

    public int getAge() {
      return age;
    }

    public void setAge(int age) {
      this.age = age;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    @Override public String toString() {
      return "Person{" +
          "name='" + name + '\'' +
          ", age=" + age +
          '}';
    }

  }
}
