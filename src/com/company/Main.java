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

    public static void main(String[] args) {
        ArrayList<Contact> contacts = new ArrayList<>();
        ContactService contactService = new ContactService(contacts);
        int choice;
        boolean check = false;
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
                        System.out.print("Trước khi cập nhật bộ nhớ (xoá toàn bộ danh bạ đang có trong bộ nhớ)" + "\n" +
                                "Ấn Y Nếu chấp nhận sẽ thực hiện cập nhật lại toàn bộ bộ nhớ danh bạ từ file.\n");
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

            } while (!check);
        } catch (
                InputMismatchException | IOException e) {
            System.out.println("Input mismatch exception");
        }

    }

    public static void menu_user() {
        System.out.println("--------CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ--------");
        System.out.println("Chọn chức năng theo số (để tiếp tục)");
        System.out.println("1. Xem danh sách");
        System.out.println("2. Thêm mới");
        System.out.println("3. Cập nhật");
        System.out.println("4. Xóa");
        System.out.println("5. Tìm kiếm");
        System.out.println("6. Đọc từ File");
        System.out.println("7. Ghi vào File");
        System.out.println("8. Thoát");
        System.out.println("Chọn chức năng: ");
    }
}

