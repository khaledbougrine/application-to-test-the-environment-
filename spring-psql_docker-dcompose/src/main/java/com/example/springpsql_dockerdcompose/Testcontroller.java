package com.example.springpsql_dockerdcompose;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.w3c.dom.stylesheets.LinkStyle;

import java.net.URI;
import java.util.List;

@RestController
public class Testcontroller {
    @Autowired
    CustomerRepository customerRepository;
    @PostMapping("add")
    public ResponseEntity getUser(@RequestBody Customer customer){
        System.out.println(customer.toString());
        customerRepository.save(customer);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(customer.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
    @GetMapping("get")
    public List<Customer> getCustomer(){
        return customerRepository.findAll();
    }
}
