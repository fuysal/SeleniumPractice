package com.cybertek.day4;

import com.github.javafaker.Faker;

public class FakerTest {
    public static void main(String[] args) {
        Faker faker = new Faker();
        String country = faker.country();
        System.out.println(country);

    }
}
