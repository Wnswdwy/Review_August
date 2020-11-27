package com.nswdwy.java;

/**
 * @author yycstart
 * @create 2020-08-30 20:21
 */
public class Customer {
    /**
     * +--------+-----------------+------+-----+---------+----------------+
     * | Field  | Type            | Null | Key | Default | Extra          |
     * +--------+-----------------+------+-----+---------+----------------+
     * | id     | int(11)         | NO   | PRI | NULL    | auto_increment |
     * | name   | varchar(20)     | YES  |     | NULL    |                |
     * | age    | int(11)         | YES  |     | NULL    |                |
     * | gender | enum('男','女') | YES  |     | 男      |                |
     * | email  | varchar(50)     | YES  |     | NULL    |                |
     * +--------+-----------------+------+-----+---------+----------------+
     */
    private int id;
    private String name;
    private int age;
    private String gender;
    private String email;

    public Customer(int id, String name, int age, String gender, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.email = email;
    }

    public Customer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
