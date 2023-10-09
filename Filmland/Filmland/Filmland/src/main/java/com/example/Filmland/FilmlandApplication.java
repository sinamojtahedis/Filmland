package com.example.Filmland;

import com.example.Filmland.Repository.CategoryRepository;
import com.example.Filmland.Repository.CustomerRepository;
import com.example.Filmland.Repository.SubscriptionRepository;
import com.example.Filmland.entity.Category;
import com.example.Filmland.entity.Customer;
import com.example.Filmland.entity.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.time.LocalDate;

@EnableScheduling
@SpringBootApplication
public class FilmlandApplication implements CommandLineRunner {
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    SubscriptionRepository subscriptionRepository;


    public static void main(String[] args) {
        SpringApplication.run(FilmlandApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {


        Category category1 = new Category("Dutch Films", 10, 4.0);
        categoryRepository.save(category1);
        Category category2 = new Category("Dutch Series", 20, 6.0);
        categoryRepository.save(category2);
        Category category3 = new Category("International Films", 5, 8.0);
        categoryRepository.save(category3);


        Customer customer1 = new Customer("sogeti", "info@filmland-assessment.nl", "Javaiscool90", LocalDate.now());
        customerRepository.save(customer1);
        Customer customer2 = new Customer("sina", "sina.mojtahedis@gmail.com", "1234", customer1.getStartingPayDay());
        customerRepository.save(customer2);

        Subscription subscription1 = new Subscription(3, false, customer1, category1);
        subscriptionRepository.save(subscription1);
        Subscription subscription2 = new Subscription(2, false, customer2, category2);
        subscriptionRepository.save(subscription2);

    }

}