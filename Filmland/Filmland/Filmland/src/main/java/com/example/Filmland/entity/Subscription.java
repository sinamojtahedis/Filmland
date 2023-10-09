package com.example.Filmland.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity

public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer maxLimit;
    private Boolean subscribe;


    @ManyToOne
    Customer customer;
    @OneToOne
    Category category;


    public Subscription(Integer maxLimit, Boolean subscribe, Customer customer, Category category) {
        this.maxLimit = maxLimit;
        this.subscribe = subscribe;
        this.customer = customer;
        this.category = category;
    }

    public void setSubscribe(Boolean subscribe) {
        this.subscribe = subscribe;
        if (Boolean.TRUE.equals(subscribe)) {
            updateStartingPayDayForCustomer();
        }
    }

    private void updateStartingPayDayForCustomer() {
        if (customer != null) {
            LocalDate today = LocalDate.now();
            LocalDate paymentDate = today.plusDays(30);
            customer.setStartingPayDay(paymentDate);
        }
    }
}
