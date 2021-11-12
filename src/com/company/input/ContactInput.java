package com.company.input;

import com.company.model.Contact;
import com.company.model.Validation;

import java.util.Scanner;

public class ContactInput {
    public static final Scanner SCANNER = new Scanner(System.in);

    public static Contact inputContact() {
        System.out.println("Enter contact information");
        String contactPhoneNumber = inputContactPhoneNumber();
        System.out.print("Enter contact group: ");
        String contactGroup = SCANNER.nextLine();
        String contactName = inputContactName();
        System.out.print("Enter contact gender: ");
        String contactGender = SCANNER.nextLine();
        String contactAddress = inputContactAddress();
        String contactDateOfBirth = inputContactDateOfBirth();
        String contactEmail = inputContactEmail();
        return new Contact(contactPhoneNumber, contactGroup, contactName, contactGender, contactAddress, contactDateOfBirth, contactEmail);
    }

    private static String inputContactPhoneNumber() {
        String contactPhoneNumber;
        boolean invalidPhoneNUmber;
        do {
            System.out.print("Enter contact phone number: ");
            contactPhoneNumber = SCANNER.nextLine();
            invalidPhoneNUmber = !Validation.isValid(contactPhoneNumber, Validation.PHONE_NUMBER_REGEX);
            if (invalidPhoneNUmber) System.out.println("Wrong format of phone number");
        } while (invalidPhoneNUmber);
        return contactPhoneNumber;
    }

    private static String inputContactName() {
        String contactName;
        boolean invalidName;
        do {
            System.out.print("Enter contact name: ");
            contactName = SCANNER.nextLine();
            invalidName = !Validation.isValid(contactName, Validation.NAME_REGEX);
            if (invalidName) System.out.println("Wrong format of name");
        } while (invalidName);
        return contactName;
    }

    private static String inputContactAddress() {
        String contactAddress;
        boolean invalidAddress;
        do {
            System.out.print("Enter contact address: ");
            contactAddress = SCANNER.nextLine();
            invalidAddress = !Validation.isValid(contactAddress, Validation.NAME_REGEX);
            if (invalidAddress) System.out.println("Wrong format of address");
        } while (invalidAddress);
        return contactAddress;
    }

    private static String inputContactDateOfBirth(){
        String contactDateOfBirth;
        boolean invalidDateOfBirth;
        do {
            System.out.print("Enter contact Date of birth (dd/mm/yyyy): ");
            contactDateOfBirth = SCANNER.nextLine();
            invalidDateOfBirth = !Validation.isValid(contactDateOfBirth, Validation.DATEOFBIRTH_REGEX);
            if (invalidDateOfBirth) System.out.println("Wrong format of date of birth");
        } while (invalidDateOfBirth);
        return contactDateOfBirth;
    }

    private static String inputContactEmail(){
        String contactEmail;
        boolean invalidEmail;
        do {
            System.out.print("Enter contact Email: ");
            contactEmail = SCANNER.nextLine();
            invalidEmail = !Validation.isValid(contactEmail, Validation.EMAIL_REGEX);
            if (invalidEmail) System.out.println("Wrong format of email");
        } while (invalidEmail);
        return contactEmail;
    }
}
