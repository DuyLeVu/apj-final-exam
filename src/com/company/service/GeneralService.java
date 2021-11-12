package com.company.service;

import java.util.List;

public interface GeneralService<T> {
    void create(T t);

    void delete(String phoneNumber);

    void update(String phoneNumber, T t);

    void findRelativeByPhoneNumber(String phoneNumber);

    void display();
}
