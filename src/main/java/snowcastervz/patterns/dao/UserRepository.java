package snowcastervz.patterns.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import snowcastervz.patterns.model.AppUser;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends  JpaRepository<AppUser,Integer> {
    Optional<AppUser> findByEmail(String email);
    Optional<AppUser> findByUsernameOrEmail(String username, String email);
    Optional<AppUser> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}
