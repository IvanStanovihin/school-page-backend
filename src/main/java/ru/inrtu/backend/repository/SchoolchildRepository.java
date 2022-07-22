package ru.inrtu.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.inrtu.backend.entity.Schoolchild;

public interface SchoolchildRepository extends JpaRepository<Schoolchild, Long> {

    @Query(nativeQuery = true, value = "select * from schoolchild s where s.name like :name and" +
            "s.surname like :surname and s.father_name like :fatherName and educational_class like :educationalClass")
    Schoolchild findExistingInDB(String name, String surname, String fatherName, String educationalClass);
}
