package com.example.api.api;

import com.example.api.entities.Customer;
import com.example.api.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@PreAuthorize("hasRole('ADMIN')")
@RequestMapping("api/customers")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CustomerApiController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<?> index(){
        try {
            return ResponseEntity.ok(customerService.getAllCustomers());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(" Error !");
        }
    }

    @PostMapping
    public ResponseEntity<?> store(@RequestBody Customer customer){
        try {
            customerService.save(customer);
            return ResponseEntity.ok("Create successfully");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(" Create failed !");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> show(@PathVariable("id") int id){
        try {
            return ResponseEntity.ok(customerService.getCustomerById(id).get());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(" Not found customer !");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody Customer newCustomer){
        try {
            newCustomer.setId(id);
            customerService.save(newCustomer);
            return ResponseEntity.ok("Update success !");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(" Update fail !");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        try {
            customerService.deleteCustomer(id);
            return ResponseEntity.ok(" Deleted success !");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(" Delete fail !");
        }
    }

    @GetMapping("/search")
    public ResponseEntity<?> search(@Param("query") String query) {
        try {
            return ResponseEntity.ok(customerService.searchCustomer(query));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
