package com.cletus.ejercicio.repository;

import com.cletus.ejercicio.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    User save(User u);

    List<User> findAll();

    Optional<User> findById(Long id);

    void deleteById(Long id);

    void deleteAll();

}
