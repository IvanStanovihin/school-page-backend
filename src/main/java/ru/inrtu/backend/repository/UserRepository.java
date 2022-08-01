package ru.inrtu.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.inrtu.backend.entity.authorization.User;

public interface UserRepository extends JpaRepository<User, Long> {

    public User findByUsername(String username);
}
