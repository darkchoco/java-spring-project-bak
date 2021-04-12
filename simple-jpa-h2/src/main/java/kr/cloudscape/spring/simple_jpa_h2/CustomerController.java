package kr.cloudscape.spring.simple_jpa_h2;

import kr.cloudscape.spring.simple_jpa_h2.dao.CustomerRepository;
import kr.cloudscape.spring.simple_jpa_h2.entity.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    private final CustomerRepository repository;

    public CustomerController(CustomerRepository repository) {
        super();
        this.repository = repository;
    }

    @PutMapping("/customer")
    public Customer putCustomer(Customer customer) {
        return repository.save(customer);
    }

    @PostMapping("/customer")  // INSERT, UPDATE
    public Customer postCustomer(Customer customer) {
        return repository.save(customer);
    }

    @DeleteMapping("/customer")
    public void deleteCustomer(int id) {
        repository.deleteById(id);
    }

    @GetMapping("/customer")
    public Customer getCustomer(int id) {
//        return repository.findById(id).orElse(null);  // 200 OK
        return repository.findById(id).orElseThrow();  // 500 Internal Server Error
    }

    @GetMapping("/customer/list")
    public List<Customer> getCustomerList() {
        return (List<Customer>) repository.findAll();  // iterator return. Casting 필요.
    }

    /**
     * @return 동명이인이 여럿 있을 수 있으므로 List 리턴.
     */
    @GetMapping("/customer/name")
    public List<Customer> getCustomer(String name) {
        return repository.findByName(name);
    }

    @GetMapping("/customer/search")
    public List<Customer> searchCustomer(String name) {
        return repository.findByNameLike("%" + name + "%");
    }
}
