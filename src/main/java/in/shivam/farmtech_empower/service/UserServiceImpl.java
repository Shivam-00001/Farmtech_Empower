// File: src/main/java/in/shivam/farmtech_empower/service/UserServiceImpl.java

package in.shivam.farmtech_empower.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import in.shivam.farmtech_empower.entity.User;
import in.shivam.farmtech_empower.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;  // Autowire UserRepo instead of User

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword())); // Encode password before saving
        return userRepo.save(user);
    }

    @Override
    public boolean checkEmail(String email) {
        return userRepo.findByEmail(email) != null;
    }
}
