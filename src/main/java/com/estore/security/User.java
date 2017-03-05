package com.estore.security;

import com.estore.model.Product;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.List;


/**
 * @author oscarsoto on 2/22/17.
 *         There is no reasonable excuse for doing anything less than your best.
 *         - Martin, Robert C.
 */
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "user")
    private List<Product> products;

    @NotBlank(message = "Please enter a username")
    @Column(nullable = false, unique = true)
    private String username;

    @NotBlank(message = "Please enter a password")
    @Column(nullable = false)
    private String password;

    public User(){}

    public User(User user) {
        id = user.id;
        username = user.username;
        password = user.password;
    }

    public User(Long id, String username, String email, String password) {
        this.setId(id);
        this.setUsername(username);
        this.setPassword(password);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString(){
        return this.getId() + " " + this.getUsername() + " " + this.getPassword();
    }
}
