package com.codegym.service;

import com.codegym.model.Customer;

import java.util.List;

public interface IGeneralService<T> {
    List<Customer> findAll();

    int findIndexById(int id);

    Customer findCustomerById(int id);

    void create(Customer customer);

    void update(int id, Customer customer);

    void delete(int id);

}
