package com.examly.springapp.service;
import com.examly.springapp.model.User;
import com.examly.springapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repo;
    @Override
    public User addUser(User user) { return repo.save(user); }
    @Override
    public List<User> getAllUsers() { return repo.findAll(); }
    @Override
    public User getUserById(Long id) { return repo.findById(id).orElse(null); }
}