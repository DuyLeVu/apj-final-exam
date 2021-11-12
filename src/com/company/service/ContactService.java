package com.company.service;

import com.company.file.ContactIO;
import com.company.model.Contact;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.company.file.Path.PATH_FILE_CONTACT;

public class ContactService implements GeneralService<Contact> {
    private List<Contact> contacts;

    public ContactService(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    @Override
    public void create(Contact contact) {
        contacts.add(contact);
    }

    @Override
    public void delete(String phoneNumber) {
        int index = findIndexByPhoneNumber(phoneNumber);
        if (index == -1) System.out.println("This contact is not available");
        else contacts.remove(index);
    }

    @Override
    public void update(String phoneNumber, Contact contact) {
        int index = findIndexByPhoneNumber(phoneNumber);
        if (index == -1) System.out.println("This contact is not available");
        else contacts.set(index, contact);
    }


    @Override
    public void findRelativeByPhoneNumber(String phoneNumber) {
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getPhoneNumber().contains(phoneNumber)) {
                System.out.println(contacts.get(i));
            }
        }
    }

    @Override
    public void display() {
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }

    public int findIndexByPhoneNumber(String phoneNumber) {
        int indexOf = -1;
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getPhoneNumber().equals(phoneNumber)) {
                indexOf = i;
                break;
            }
        }
        return indexOf;
    }

    public Contact findByPhoneNumber(String phoneNumber) {
        int index = -1;
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getPhoneNumber().equals(phoneNumber)) {
                index = i;
            }
        }
        if (index == -1) {
            return null;
        } else {
            return contacts.get(index);
        }
    }
}
