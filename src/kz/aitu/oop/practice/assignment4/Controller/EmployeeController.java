package kz.aitu.oop.practice.assignment4.Controller;

import kz.aitu.oop.practice.assignment4.Entities.Employee;
import kz.aitu.oop.practice.assignment4.Repositories.Irepo.Interface.IRepo;

import java.util.List;


public class EmployeeController {
        private final IRepo repo;
        public EmployeeController(IRepo repo) {
            this.repo = repo;
        }
        public String createEmps(int id,String fullname, int age,String speciality,int salary) {

            Employee employee = new Employee(id,fullname, age,speciality,salary);

            boolean created = repo.createEmps(employee);

            return (created ? "User was created!" : "User creation was failed!");
        }
        public String deleteEmps(int id) {
            Employee employee = repo.deleteEmps(id);

            return (employee == null ? " " : employee.toString());
        }
        public String seeEmps() {
            List<Employee> employee = repo.seeEmps();
            return employee.toString();
        }
    public int salaryCost(){
        int response = repo.salaryEmps();
        return response;
    }
    }
