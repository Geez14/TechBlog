package com.geez14.techblogs.entities;

import java.util.Objects;

public class About {
    private int id;
    private String profile_picture;
    private String about;
//
//    /**
//     * Constructor to set data
//     *
//     * @param about java.lang.String
//     */
//    public About(String about) {
//        this.about = about;
//    }

    /**
     * For serialization and other purpose
     */
    public About() {
        super();
    }

    /**
     * Constructor to get about
     *
     * @param id    int
     * @param about java.lang.String
     */
    public About(int id, String about) {
        this.id = id;
        this.about = about;
    }

    /**
     * Constructor to get about
     *
     * @param id    int
     * @param profile_picture java.lang.String
     * @param about java.lang.String
     */
    About(int id, String profile_picture, String about) {
        this.id = id;
        this.profile_picture = profile_picture;
        this.about = about;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getProfile_picture() {
        return profile_picture;
    }

    public void setProfile_picture(String profile_picture) {
        this.profile_picture = profile_picture;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof About abouts)) return false;
        return id == abouts.id && Objects.equals(about, abouts.about);
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
        return "About{" +
                "id=" + id +
                ", about='" + about + '\'' +
                '}';
    }
}
