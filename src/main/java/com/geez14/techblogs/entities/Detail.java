package com.geez14.techblogs.entities;

public class Detail {
    private int id;
    private String firstName;
    private String lastName;
    private String gender;
    private String phoneNumber;


    /**
     * For serialization and other purpose
     */
    public Detail() {
        super();
    }

//    /**
//     * Constructor to set data
//     *
//     * @param firstName   java.lang.String
//     * @param lastName    java.lang.String
//     * @param gender      java.lang.String
//     * @param phoneNumber java.lang.String
//     */
//    public Detail(String firstName, String lastName, String gender, String phoneNumber) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.gender = gender;
//        this.phoneNumber = phoneNumber;
//    }

    /**
     * Constructor to get object from ID
     *
     * @param id          int
     * @param firstName   java.lang.String
     * @param lastName    java.lang.String
     * @param gender      java.lang.String
     * @param phoneNumber java.lang.String
     */
    public Detail(int id, String firstName, String lastName, String gender, String phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Detail details)) return false;
        return id == details.id &&
                firstName.equals(details.firstName) &&
                lastName.equals(details.lastName) &&
                gender.equals(details.gender) &&
                phoneNumber.equals(details.phoneNumber);
    }

    @Override
    public int hashCode() {
        return id;
    }

    /**
     * Override toString method to get object representation
     *
     * @return java.lang.String
     */
    @Override
    public String toString() {
        return "Detail{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
