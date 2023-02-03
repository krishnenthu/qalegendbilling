package com.qalegendbilling.utilities;

import com.github.javafaker.Faker;
import com.github.javafaker.PhoneNumber;

import java.util.Random;

public class RandomDataUtility {
    static Faker faker;
    static String fName;
    static String lName;
    static PhoneNumber phone;
    public static String getfName(){
        faker= new Faker();
        fName = faker.name().lastName();
        return fName;
    }
    public static String getlName(){
        faker= new Faker();
        lName = faker.name().lastName();
        return lName;
    }
    public static PhoneNumber getPhone(){
        faker= new Faker();
        phone = faker.phoneNumber();
        return phone;
    }
    public static String getRandomEmail() {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        int length = 5;
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(alphabet.length());
            char randomChar = alphabet.charAt(index);
            sb.append(randomChar);
        }
        String randomStringEmail = sb.toString() + "@gmail.com";
        return randomStringEmail;
    }
}
