package kz.aitu.oop.practice.assignment4.Repositories.Irepo.Interface;

import kz.aitu.oop.practice.assignment4.Entities.Employee;

import java.util.List;

public interface IRepo {
    boolean createEmps(Employee employee);
    List<Employee> seeEmps();
    Employee deleteEmps(int id);
    int salaryEmps();
}
