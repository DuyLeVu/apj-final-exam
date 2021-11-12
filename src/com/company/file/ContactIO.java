package com.company.file;

import com.company.model.Contact;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ContactIO {

    public static void writeToFile(String path, List<Contact> contacts) throws IOException {
        FileWriter fileWriter = new FileWriter(path);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String str = "Số điện thoại,Nhóm,Họ tên,Giới tính,Địa chỉ,Ngày sinh,Email\n";
        for (Contact c : contacts) {
            str += c.getPhoneNumber() + ","
                    + c.getGroupContact() + ","
                    + c.getName() + ","
                    + c.getGender() + ","
                    + c.getAddress() + ","
                    + c.getDateOfBirth() + ","
                    + c.getEmail() + "\n";
        }
        bufferedWriter.write(str);
        bufferedWriter.close();
        fileWriter.close();
    }

    public static List<Contact> readFromFile(String path) throws IOException {
        List<Contact> contacts = new ArrayList<>();
        File file = new File(path);
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String lineCSV = bufferedReader.readLine();
            while ((lineCSV = bufferedReader.readLine()) != null) {
                String[] lineContent = lineCSV.split(",");
                String contactPhoneNumber = lineContent[0];
                String contactGroup = lineContent[1];
                String contactName = lineContent[2];
                String contactGender = lineContent[3];
                String contactAddress = lineContent[4];
                String contactDateOfBirth = lineContent[5];
                String contactEmail = lineContent[6];

                contacts.add(new Contact(contactPhoneNumber, contactGroup, contactName, contactGender, contactAddress, contactDateOfBirth, contactEmail));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contacts;
    }
}
