package com.examly.springapp.service;
import com.examly.springapp.model.User;
import com.examly.springapp.repository.UserRepository;
import com.examly.springapp.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository repo;
    public UserServiceImpl(UserRepository repo) { this.repo = repo; }
    @Override
    public User addUser(User user) { return repo.save(user); }
    @Override
    public List<User> getAllUsers() { return repo.findAll(); }
    @Override
    public User getUserById(Long id) { 
        return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + id)); 
    }
    @Override
    public User updateUser(Long id, User user) {
        User existing = this.getUserById(id);
        if(user.getUsername() != null) existing.setUsername(user.getUsername());
        if(user.getEmail() != null) existing.setEmail(user.getEmail());
        if(user.getRole() != null) existing.setRole(user.getRole());
        if(user.getPhoneNumber() != null) existing.setPhoneNumber(user.getPhoneNumber());
        if(user.getDepartment() != null) existing.setDepartment(user.getDepartment());
        return repo.save(existing);
    }
}
