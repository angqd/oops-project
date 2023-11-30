package com.example.demo3.Image;

import jakarta.persistence.*;

@Entity
@Table(name="image_table")
public class Images {


    @Id
    @SequenceGenerator(
            name = "image_sequence",
            sequenceName = "image_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "image_sequence"
    )
    private long id;
    private long pid;
    private String url;


    public Images() {
    }

    public Images(long id, long pid, String url) {
        this.id = id;
        this.pid = pid;
        this.url = url;
    }

    public Images(long pid, String url) {
        this.pid = pid;
        this.url = url;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPid() {
        return pid;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


}
