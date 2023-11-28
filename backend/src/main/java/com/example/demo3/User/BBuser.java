package com.example.demo3.User;
import com.example.demo3.Product.Product;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

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
    private long phoneNumber;
    @OneToMany(mappedBy = "bbuser" , cascade = CascadeType.ALL)
    private List<Product> products = new ArrayList<>();
    public BBuser() {
    }

    public BBuser(long id, String name, String email, String username, long phoneNumber) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.username = username;
        this.phoneNumber = phoneNumber;
    }

    public BBuser(String name, String email,long phoneNumber) {
        this.name = name;
        this.email = email;
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
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
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
    public void addUserProduct(Product product){
        products.add(product);
        product.setbbuser(this);
    }



}
