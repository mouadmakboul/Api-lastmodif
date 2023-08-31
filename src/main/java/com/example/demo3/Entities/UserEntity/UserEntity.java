package com.example.demo3.Entities.UserEntity;


import com.example.demo3.Entities.AccountEntity.AccountEntity;
import com.example.demo3.Entities.CommentaireEntity.CommentaireEntity;
import com.example.demo3.Entities.LogementEntity.LogementEntity;
import com.example.demo3.Entities.PayementEntity.PayementEntity;
import com.example.demo3.Entities.ReservationEntity.ReservationEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "users",uniqueConstraints = {
        @UniqueConstraint(columnNames = "username"),
        @UniqueConstraint(columnNames = "email")
})
public class UserEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 20)
    private String username;

    @NotBlank
    @Size(max = 20)
    private String firstname;

    @NotBlank
    @Size(max = 20)
    private String lastname;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    @Size(max = 120)
    private String password;
    @NotBlank
    @Size(max = 20)
    private String numero;

    @OneToMany(mappedBy = "user" ,fetch = FetchType.LAZY)
    private List<CommentaireEntity> commentaires;
    @OneToMany(mappedBy = "user" ,fetch = FetchType.LAZY)
    private List<AccountEntity> Accounts;
    @OneToMany(mappedBy = "user" ,fetch = FetchType.LAZY)
    private List<LogementEntity> logements;
    @OneToMany(mappedBy = "user" ,fetch = FetchType.LAZY)
    private List<PayementEntity> payement;
    @OneToMany(mappedBy = "user" ,fetch = FetchType.LAZY)
    private List<ReservationEntity> reservation;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

    public UserEntity() {
    }


    public UserEntity(String username, String firstname, String lastname, String email, String password, String numero) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.numero = numero;
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

    public String getFirstname() {
        return firstname;
    }

//

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public UserEntity(String username, String firstname, String lastname, String email, String password) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}