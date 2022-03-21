package com.codegym.service;

import com.codegym.model.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CustomerService implements ICustomerService {

    static List<Customer> customers = new ArrayList<>();

    static {
        customers.add(new Customer(1, "Thang", "0394910426", "nguyenthang29tbdl@gmail.com", "Ha Noi"));
        customers.add(new Customer(2, "Cuong", "0394910427", "nguyencuong29tbdl@gmail.com", "Ha Noi"));
        customers.add(new Customer(3, "Viet", "0394910428", "nguyenviet29tbdl@gmail.com", "Ha Noi"));
        customers.add(new Customer(4, "Binh", "0394910486", "nguyenquoc29tbdl@gmail.com", "Ha Noi"));
        customers.add(new Customer(5, "Huy", "0394910429", "nguyenchien29tbdl@gmail.com", "Ha Noi"));
    }

    @Override
    public List<Customer> findAll() {
        return customers;
    }

    @Override
    public int findIndexById(int id) {
        int index = -1;
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getId() == id) {
                index = i;
            }
        }
        return index;
    }

    @Override
    public Customer findCustomerById(int id) {
        int index = findIndexById(id);

        return customers.get(index);
    }

    @Override
    public void create(Customer customer) {
        customers.add(customer);
    }

    @Override
    public void update(int id, Customer customer) {
        int index = findIndexById(id);
        customers.set(index, customer);
    }

    @Override
    public void delete(int id) {
        int index = findIndexById(id);
        customers.remove(index);
    }
}
