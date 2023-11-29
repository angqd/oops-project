package com.example.demo3.User;
import com.example.demo3.Product.Product;
import jakarta.persistence.*;


import java.util.ArrayList;
import java.util.List;
import org.mindrot.jbcrypt.BCrypt;

@Entity
@Table(name = "bbuser_table")
public class BBuser {


    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private long id;
    private String name;
    private String email;
    private String username;
    private String hostel;

    private String password;
    private long phoneNumber;

    public BBuser() {
    }

    public BBuser(long id, String name, String email, String username, String hostel, String password, long phoneNumber) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.username = username;
        this.hostel = hostel;
        this.password = BCrypt.hashpw(password, BCrypt.gensalt());
        this.phoneNumber = phoneNumber;
        setDefaultUsername();
    }

    public BBuser(String name, String email, String hostel, String password, long phoneNumber) {
        this.name = name;
        this.email = email;
        this.hostel = hostel;
        this.password = BCrypt.hashpw(password, BCrypt.gensalt());
        this.phoneNumber = phoneNumber;
        setDefaultUsername();
    }

    private void setDefaultUsername(){
        if(name != null && !name.isEmpty()){
            this.username = name.substring(0,1).toLowerCase();
        }else
        {
            this.username = "default";
        }
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
        setDefaultUsername();;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getHostel() {
        return hostel;
    }

    public void setHostel(String hostel) {
        this.hostel = hostel;
    }

    @Override
    public String toString(){
        return "User" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email" + email +
                ", username=" + username +"\n"+
                '}';
    }

    public String getPassword(){return password;}
    public void SetPassword(String password){
        this.password = BCrypt.hashpw(password, BCrypt.gensalt());
    }



}
/*
now we need to implement a function that creates a wallet automatically when we
create the user
 */