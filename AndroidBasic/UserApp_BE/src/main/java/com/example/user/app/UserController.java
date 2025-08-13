package com.example.user.app;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*") // 안드로이드에서 접근 가능하게
class UserController {

    private final UserRepository repository;


    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return repository.save(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        return repository.findById(id)
                .map(user -> {
                    user.setName(updatedUser.getName());
                    user.setEmail(updatedUser.getEmail());
                    return repository.save(user);
                })
                .orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        repository.deleteById(id);
    }

    // Product 전체조회
    @GetMapping("/{id}/products")
    public ResponseEntity<List<Product>> getUserProducts(@PathVariable Long id) {

        // 가짜 상품
        List<Product> dummyProducts = List.of(
                new Product(1L, "상품A"),
                new Product(2L, "상품B"),
                new Product(3L, "상품C")
        );
        return ResponseEntity.ok(dummyProducts);
    }
}
