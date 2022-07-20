package ru.inrtu.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.inrtu.backend.entity.Schoolchild;

public interface SchoolchildRepository extends JpaRepository<Schoolchild, Long> {
}
