package com.geez14.techblogs.entities.views;

import com.geez14.techblogs.entities.About;
import com.geez14.techblogs.entities.Detail;
import com.geez14.techblogs.entities.User;


// this class contain all the data of about/detail/user
public class Profile {
    private final int id;
    // User table
    private final String username;
    private final String email;
    private final String registrationDate;
    private final String password;
    // Detail
    private final String firstName;
    private final String lastName;
    private final String gender;
    private final String phoneNumber;
    // About
    private final String profilePic;
    private final String about;

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
        this.registrationDate = user.getRegistrationDate();
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }


    public String getProfilePic() {
        return profilePic;
    }

    public String getAbout() {
        return about;
    }

    public String getRegistrationDate() {
        return registrationDate;
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
                ", registrationDate=" + registrationDate+
                ", about='" + about + '\'' +
                '}';
    }

}
