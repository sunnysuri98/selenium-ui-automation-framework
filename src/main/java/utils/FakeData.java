package utils;

import java.util.Locale;

import com.github.javafaker.Faker;

public class FakeData {

    private static final Faker DATA = new Faker(new Locale("en-IND"));

    public static String firstName() {
        return DATA.name().firstName();
    }

    public static String lastName() {
        return DATA.name().lastName();
    }

    public static String email() {
        return firstName().toLowerCase() + "." + lastName().toLowerCase() + "@" + DATA.internet().domainName();
    }


    public static String username() {
        return firstName().toLowerCase() + lastName().toLowerCase() + DATA.number().digits(3);
    }

    public static String password() {
        return DATA.internet().password(8, 16, true, true, true);
    }

    public static String address(){
        return DATA.address().streetAddress();
    }

    public static String city(){
        return DATA.address().city();
    }

    public static String zipCode(){
        return DATA.address().zipCode();
    }

    public static String state(){
        return DATA.address().state();
    }

    public static int getRandomNumberBetweenOneAndTwo(){

        return DATA.number().numberBetween(1, 3);

    }

    public static int getRandomNumberBetweenOneAndEight(){

        return DATA.number().numberBetween(1, 9);

    }
    
}
