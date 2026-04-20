package Utils;


import com.github.javafaker.Faker;

public class RandomUtils {

    private static Faker faker = new Faker();


    public static String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};

        return faker.options().option(genders);
    }

//    public static String getRandomHobbies() {
//        String[] hobby = {"Sports", "Reading", "Music"};
//
//        return faker.options().option(hobby);
//    }

//    public static String getRandomPhoto() {
//        String[] photo = {"img/foto.jpg", "img/foto2.jpg"};
//
//        return faker.options().option(photo);
//    }


    public static String getRandomState() {
        String[] states = {"NCR","Uttar Pradesh", "Haryana", "Rajasthan"};
        return faker.options().option(states);
    }

    public static String getRandomCity(String state) {
        String[] NCR = {"Delhi","Gurgaon", "Noida"},
                 UttarPradesh = {"Agra", "Lucknow", "Merrut"},
                 Haryana = {"Karnal", "Panipat"},
                 Rajasthan = {"Jaipur", "Jaiselmer"};
        return switch (state) {
            case "NCR" -> faker.options().option(NCR);
            case "Uttar Pradesh" -> faker.options().option(UttarPradesh);
            case "Haryana" -> faker.options().option(Haryana);
            default -> faker.options().option(Rajasthan);
        };
    }

    public static String getSubject() {
        String[] subject = {"Math","Music", "Geography", "English"};
        return faker.options().option(subject);
    }


    public static String getMonth () {
    String[] month = {"January","February","March","April","May","June","July","August","September","October","November","December"};
        return faker.options().option(month);
    }


}
