package com.jaderbittencourt.jumia.repositories;

import com.jaderbittencourt.jumia.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
