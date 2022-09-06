package com.geeta.demo.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.geeta.demo.entity.Customer;
import com.geeta.demo.repository.CustomerRepository;

@RestController
public class CustController {
    private CustomerRepository cr;

    public CustController(CustomerRepository cr) {
        this.cr = cr;
    }

    @PostMapping("/customer")
    public ResponseEntity<Object> createBook(@RequestBody Customer c) {
        Customer obj = cr.save(c);

        URI loc = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(loc).body("created in database");

    }

    @GetMapping(value = "/showall")
    public List<Customer> getAllBook() {
        return cr.findAll();
    }

    @GetMapping(value = "/customer/{id}")
    public Customer getBookById(@PathVariable("id") int id) {
        return cr.findById(id).get();
    }

    @DeleteMapping("/customer/{id}")
    public String deleteBook(@PathVariable("id") int id) {
        cr.deleteById(id);

        return "customer of " + id + "deleted sucessfully..";

    }

}
