// File: src/main/java/in/shivam/farmtech_empower/service/UserService.java

package in.shivam.farmtech_empower.service;

import in.shivam.farmtech_empower.entity.User;

public interface UserService {
    User saveUser(User user);  // Method to save user
    boolean checkEmail(String email);  // Method to check if email already exists
}
