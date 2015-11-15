package net.paulacr.starwars.utils;

/**
 * Created by Paula on 15/11/2015.
 */
public class Translations {


    private static final String FEMALE = "female";
    private static final String MALE = "male";
    private static final String NOT_INFORMED = "n/a";
    private static final String HERMAPHRODITE = "hermaphrodite";


    public static String genderTranslation (String word) {
        String translated = null;
        if(word.equals(FEMALE)) {
            translated = "feminino";
        } else if(word.equals(MALE)) {
            translated = "masculino";
        } else if(word.equals(NOT_INFORMED)) {
            translated = "indefinido";
        } else if(word.equals(HERMAPHRODITE)) {
            translated = "hermafrodita";
        }
        return translated;
    }

}
