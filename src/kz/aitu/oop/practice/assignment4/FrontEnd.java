package kz.aitu.oop.practice.assignment4;

import kz.aitu.oop.practice.assignment4.Controller.EmployeeController;
import kz.aitu.oop.practice.assignment4.Entities.Employee;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FrontEnd {
    private final EmployeeController controller;
    private final Scanner scanner;

    public FrontEnd(EmployeeController controller) {
        this.controller = controller;
        scanner = new Scanner(System.in);
    }
    public void start() {
        while (true) {
            System.out.println("1. See all employees");
            System.out.println("2. Delete employee by ID");
            System.out.println("3. Create new Employee:");
            System.out.println("4. Total cost of salaries:");
            System.out.println("0. Exit");
            System.out.println();
            try {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1: seeEmps();
                    break;
                    case 2: deleteEmployee();
                    break;
                    case 3:createEmployee();
                    break;
                    case 4: salaryCost();
                    break;
                    default: System.exit(0);
                }
            } catch (InputMismatchException e) {
                System.out.println("Input must be integer");
                scanner.nextLine();
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println();
        }
    }
    public void seeEmps() {
        String response = controller.seeEmps();
        System.out.println(response);
    }
    public void deleteEmployee() {
        System.out.println("Please enter id");
        int id = scanner.nextInt();
        String response = controller.deleteEmps(id);
        System.out.println(response);
    }
    public void createEmployee() {
        System.out.println("Please enter id");
        int id = scanner.nextInt();
        System.out.println("Please enter fullname");
        String name = scanner.next();
        System.out.println("Please enter age");
        int age = scanner.nextInt();
        System.out.println("Please enter speciality");
        System.out.println("1.front-end developer");
        System.out.println("2.back-end developer");
        System.out.println("3.data-scientist");
        System.out.println("4.mobile app developer on iOS");
        System.out.println("5.mobile app developer on Android");
        int choice = scanner.nextInt();
        String speciality;
        switch(choice){
            case 1: speciality = "front-end developer";
                break;
            case 2: speciality = "back-end developer";
                break;
            case 3: speciality = "data scientist";
                break;
            case 4: speciality = "iOS developer";
                break;
            case 5: speciality = "android developer";
                break;
            default: speciality = "designer";
        }

        System.out.println("Please enter salary");
        int salary = scanner.nextInt();

        String response = controller.createEmps(id,name,age,speciality,salary);
        System.out.println(response);
    }
    public void salaryCost(){
        int response = controller.salaryCost();
        System.out.println("Total cost of the salaries are: " + response);
    }
}
