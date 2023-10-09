package com.example.Filmland.entity;

import lombok.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @NotNull
    @Size(max = 100)
    private String userName;

    private LocalDate startingPayDay;
    @NotNull
    @Size(max = 100)
    private String email;
    @NotNull
    @Size(max = 100)
    private String password;

    public Customer(String userName, String email, String password, LocalDate startingPayDay) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.startingPayDay = startingPayDay;
    }

    @PrePersist
    @PreUpdate
    private void encodePassword() {
        this.password = new BCryptPasswordEncoder().encode(this.password);
    }

}
