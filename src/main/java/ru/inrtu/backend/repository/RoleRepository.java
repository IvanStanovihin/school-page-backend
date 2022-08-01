package ru.inrtu.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.inrtu.backend.entity.authorization.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

}
