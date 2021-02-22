package kz.aitu.oop.practice.assignment4.Entities;

public class Employee {
    String fullname;
    String speciality;
    int age;
    int salary;
    int id = 0;

    public Employee(int id, String fullname, int age, String speciality, int salary){//constructor to set the values to variables
        this.id = id;
        this.fullname = fullname;
        this.speciality = speciality;
        this.age = age;
        this.salary = salary;
    }


    //fullname

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public void printAllEmployees() { System.out.println(getFullname()); }
    public String getFullname() { return fullname; }//getter to return the fullname
    //speciality
    public String getSpeciality() { return speciality; }
    //age
    public int getAge() {return age; }
    //salary
    public int getSalary() { return salary; }

    public String toString() {
        return "Employee{" +
                "id=' "+id+'\n'+
                "fullName=' "+fullname+'\n'+
                ", age=' "+ age+'\n'+
                ", specialty='" + speciality + '\'' +
                ", salary='" + salary + '\'' + '}';
    }
}
