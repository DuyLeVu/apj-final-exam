package com.company;

import com.company.file.ContactIO;
import com.company.input.ContactInput;
import com.company.model.Contact;
import com.company.service.ContactService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import static com.company.file.Path.PATH_FILE_CONTACT;

public class Main {
    public static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        ArrayList<Contact> contacts = new ArrayList<>();
        ContactService contactService = new ContactService();
        int choice;
//        boolean check = false;
        try {
            do {
                menu_user();
                choice = SCANNER.nextInt();
                SCANNER.nextLine();
                switch (choice) {
                    case 1:
                        contactService.display();
                        break;
                    case 2:
                        Contact contact = ContactInput.inputContact();
                        contactService.create(contact);
                        break;
                    case 3:
                        if (contactService.getContacts().size() == 0) {
                            System.out.println("List Contact is empty!");
                        } else {
                            String contactPhoneNumberToUpdate;
                            Contact contactToUpdate = null;
                            try {
                                do {
                                    System.out.print("Enter your contact phone number you want update: ");
                                    contactPhoneNumberToUpdate = SCANNER.nextLine();
                                    contactToUpdate = contactService.findByPhoneNumber(contactPhoneNumberToUpdate);
                                    if (contactPhoneNumberToUpdate != null) {
                                        if (contactToUpdate == null) {
                                            System.out.println("Wrong phone number!");
                                            continue;
                                        }
                                    } else break;
                                }
                                while (contactToUpdate == null);
                                Contact newContactToUpdate = ContactInput.inputContact();
                                contactService.update(contactPhoneNumberToUpdate, newContactToUpdate);
                                System.out.println("Update successfully");
                            } catch (InputMismatchException e) {
                                System.out.println("Input mismatch exception");
                            }
                        }
                        break;
                    case 4:
                        if (contactService.getContacts().size() == 0) {
                            System.out.println("List Contact is empty!");
                        } else {
                            String contactPhoneNumberToDelete;
                            System.out.print("Enter your contact phone number you want delete: ");
                            contactPhoneNumberToDelete = SCANNER.nextLine();
                            String choiceToDelete;
                            System.out.println("Press Y to Delete");
                            choiceToDelete = SCANNER.nextLine();
                            if (choiceToDelete.equals("Y")) {
                                contactService.delete(contactPhoneNumberToDelete);
                                System.out.println("Delete successfully!");
                            } else break;
                        }
                        break;
                    case 5:
                        if (contactService.getContacts().size() == 0) {
                            System.out.println("List Contact is empty!");
                        } else {
                            String contactPhoneNumberToFind;
                            try {
                                System.out.print("Enter the phone number you are looking for: ");
                                contactPhoneNumberToFind = SCANNER.nextLine();
                                contactService.findRelativeByPhoneNumber(contactPhoneNumberToFind);
                            } catch (InputMismatchException e) {
                                System.out.println("Input mismatch exception");
                            }
                        }
                    case 6:
                        System.out.print("Tr?????c khi c???p nh???t b??? nh??? (xo?? to??n b??? danh b??? ??ang c?? trong b??? nh???)" + "\n" +
                                "???n Y N???u ch???p nh???n s??? th???c hi???n c???p nh???t l???i to??n b??? b??? nh??? danh b??? t??? file.\n");
                        String choiceToRead = SCANNER.nextLine();
                        if (choiceToRead.equals("Y")) {
                            try {
                                contactService.setContacts(ContactIO.readFromFile(PATH_FILE_CONTACT));
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                            System.out.println("Delete successfully");
                        } else{
                            System.out.println("Delete unsuccessfully");
                            break;
                        }
                    break;
                    case 7:
                        ContactIO.writeToFile(PATH_FILE_CONTACT, contactService.getContacts());
                        break;
                    case 8:
                        System.exit(8);
                }

            } while (choice <= 8 && choice >=1);
        } catch (
                InputMismatchException | IOException e) {
            System.out.println("Input mismatch exception");
        }

    }

    public static void menu_user() {
        System.out.println("--------CH????NG TR??NH QU???N L?? DANH B???--------");
        System.out.println("Ch???n ch???c n??ng theo s??? (????? ti???p t???c)");
        System.out.println("1. Xem danh s??ch");
        System.out.println("2. Th??m m???i");
        System.out.println("3. C???p nh???t");
        System.out.println("4. X??a");
        System.out.println("5. T??m ki???m");
        System.out.println("6. ?????c t??? File");
        System.out.println("7. Ghi v??o File");
        System.out.println("8. Tho??t");
        System.out.println("Ch???n ch???c n??ng: ");
    }
}

