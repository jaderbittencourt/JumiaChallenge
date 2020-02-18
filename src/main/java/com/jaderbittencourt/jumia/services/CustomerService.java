package com.jaderbittencourt.jumia.services;

import com.jaderbittencourt.jumia.entities.Customer;
import com.jaderbittencourt.jumia.enums.Country;
import com.jaderbittencourt.jumia.repositories.CustomerRepository;
import com.jaderbittencourt.jumia.utils.CountryCodeMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private static final String STATE_VALID = "Valid";
    private static final String STATE_INVALID = "Not valid";

    @Autowired
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> searchCustomers(final String countrySearch, final String stateSearch) {
        List<Customer> customers = customerRepository.findAll();
        customers = formatCustomersList(customers);

        if (!StringUtils.isEmpty(countrySearch)) {
            customers = filterByCountry(customers, countrySearch);
        }

        if (!StringUtils.isEmpty(stateSearch)) {
            customers = filterByState(customers, stateSearch);
        }
        return customers;
    }

    protected static List<Customer> formatCustomersList(List<Customer> customers) {
        customers.forEach(customer -> {
            Country country = CountryCodeMatcher.matchPhone(customer.getPhone());

            if (Objects.isNull(country)) {
                country = CountryCodeMatcher.matchCountryCode(customer.getPhone());
                customer.setState(STATE_INVALID);
            } else {
                customer.setState(STATE_VALID);
            }

            if (Objects.isNull(country)) {
                customer.setCountry("N/A");
                customer.setCountryCode("N/A");
            } else {
                customer.setCountry(country.getName());
                customer.setCountryCode(country.getCode());
                customer.setNumber(customer.getPhone().replaceAll(country.getCountryCodeRegex(), ""));
            }

        });
        return customers;
    }

    protected static List<Customer> filterByCountry(List<Customer> customers, final String countrySearch) {
        return customers
                .stream()
                .filter(customer -> countrySearch.equalsIgnoreCase(customer.getCountry()))
                .collect(Collectors.toList());
    }

    protected static List<Customer> filterByState(List<Customer> customers, final String stateSearch) {
        return customers
                .stream()
                .filter(customer -> stateSearch.equalsIgnoreCase(customer.getState()))
                .collect(Collectors.toList());
    }
}
