package kz.aitu.oop.practice.assignment4.Repositories.Irepo;
import kz.aitu.oop.practice.assignment4.Entities.Employee;
import kz.aitu.oop.practice.assignment4.Postgres.IIDB.IDB;
import kz.aitu.oop.practice.assignment4.Repositories.Irepo.Interface.IRepo;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class EmployeeRepo implements IRepo {
    private final IDB db;

    public EmployeeRepo(IDB db) {
        this.db = db;
    }


    @Override
    public boolean createEmps(Employee employee) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO company(id,fullname,age,speciality,salary) VALUES (?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, employee.getId());
            st.setString(2, employee.getFullname());
            st.setInt(3, employee.getAge());
            st.setString(4, employee.getSpeciality());
            st.setInt(5, employee.getSalary());

            st.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public List<Employee> seeEmps() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,fullname,age,speciality,salary FROM company";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Employee> employees = new LinkedList<>();
            while (rs.next()) {
                Employee employee = new Employee(rs.getInt("id"),
                        rs.getString("fullname"),
                        rs.getInt("age"),
                        rs.getString("speciality"),
                        rs.getInt("salary"));

                employees.add(employee);
            }

            return employees;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }


    @Override
    public Employee deleteEmps(int id) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/postgres",
                            "postgres", "1234");
            c.setAutoCommit(false);

            stmt = c.createStatement();
            String sql = "DELETE from COMPANY where ID = " + id + ";";//sql query to delete the employee by id
            stmt.executeUpdate(sql);
            c.commit();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("ID " + id + " was deleted");
        return null;
    }




    @Override
    public int salaryEmps() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT salary FROM company"; // it is query
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            int digit = 0;
            while (rs.next()) { //loop for getting salaries
                digit=digit+rs.getInt("salary");
            }return digit;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        }finally {
            try{
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return 0;
    }
}
