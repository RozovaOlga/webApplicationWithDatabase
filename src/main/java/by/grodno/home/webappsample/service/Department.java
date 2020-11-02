package by.grodno.home.webappsample.service;

public class Department {
    private Integer id;
    private String name;
    private String location;

    public Department(Integer id,String name,  String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public Department() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
