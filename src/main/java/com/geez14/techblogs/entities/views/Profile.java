package com.geez14.techblogs.entities.views;

import com.geez14.techblogs.entities.About;
import com.geez14.techblogs.entities.Detail;
import com.geez14.techblogs.entities.User;

// this class contain all the data of about/detail/user
public class Profile {
    private int id;
    // User table
    private String username;
    private String email;
    private String password;
    // Detail
    private String firstName;
    private String lastName;
    private String gender;
    private String phoneNumber;
    // About
    private String profilePic;
    private String about;

    public Profile(User user, Detail detail, About about) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.firstName = detail.getFirstName();
        this.lastName = detail.getLastName();
        this.gender = detail.getGender();
        this.phoneNumber = detail.getPhoneNumber();
        this.about = about.getAbout();
        this.profilePic = about.getProfilePicture();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", profilePic='" + profilePic + '\'' +
                ", about='" + about + '\'' +
                '}';
    }
}
