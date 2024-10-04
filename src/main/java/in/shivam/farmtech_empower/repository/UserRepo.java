// File: src/main/java/in/shivam/farmtech_empower/repository/UserRepo.java

package in.shivam.farmtech_empower.repository;

import in.shivam.farmtech_empower.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
    User findByEmail(String email);  // Custom query for finding users by email
}
