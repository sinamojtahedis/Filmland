package com.example.Filmland.Repository;

import com.example.Filmland.entity.Category;
import com.example.Filmland.entity.Customer;
import com.example.Filmland.entity.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    Optional<Subscription> findByCustomerAndCategoryName(Customer customer, String categoryName);

    Optional<Subscription> findByCustomerAndCategory(Customer customer, Category category);


}
