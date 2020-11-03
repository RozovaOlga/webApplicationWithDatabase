package by.grodno.home.webappsample.service;

import java.util.Date;

public class User {

    private Integer id;
    private String firstName;
    private String lastName;
    private Integer department;
    private Date birthdate;
    private boolean male;
    private Double salary;
    private Department departmentGetFromDatabase;

    public User() {
    }


    public User(Integer id, String firstName, String lastName, Integer department, Date birthdate, boolean male, Double salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.birthdate = birthdate;
        this.male = male;
        this.salary = salary;
    }

    public User(Integer id, String firstName, String lastName, Integer department, Date birthdate, boolean male) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.birthdate = birthdate;
        this.male = male;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getDepartment() {
        return department;
    }

    public void setDepartment(Integer department) {
        this.department = department;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public boolean isMale() {
        return male;
    }

    public void setMale(boolean male) {
        this.male = male;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Department getDepartmentGetFromDatabase() {
        return departmentGetFromDatabase;
    }

    public void setDepartmentGetFromDatabase(Department departmentGetFromDatabase) {
        this.departmentGetFromDatabase = departmentGetFromDatabase;
    }
}
