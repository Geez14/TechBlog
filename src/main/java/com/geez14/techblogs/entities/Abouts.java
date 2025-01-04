package com.geez14.techblogs.entities;

import java.util.Objects;

public class Abouts {
    private int id;
    private String about;

    /**
     * Constructor to set data
     *
     * @param about java.lang.String
     */
    public Abouts(String about) {
        this.about = about;
    }

    /**
     * For serialization and other purpose
     */
    public Abouts() {
        super();
    }

    /**
     * Constructor to get about
     *
     * @param id    int
     * @param about java.lang.String
     */
    public Abouts(int id, String about) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Abouts abouts)) return false;
        return id == abouts.id && Objects.equals(about, abouts.about);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, about);
    }
}
