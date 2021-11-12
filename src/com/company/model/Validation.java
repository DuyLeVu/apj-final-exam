package com.company.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    public static final String PHONE_NUMBER_REGEX="^[\\d]{10}$";
    public static final String NAME_REGEX = "^\\S?(.+)+\\S?$";
    public static final String EMAIL_REGEX = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$";
    public static final String DATEOFBIRTH_REGEX= "^\\d{1,2}[-|/]\\d{1,2}[-|/]\\d{4}$";

    public static boolean isValid(String str,String regex){
        Pattern pattern= Pattern.compile(regex);
        Matcher matcher= pattern.matcher(str);
        return matcher.matches();
    }
}
