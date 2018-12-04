package ar.edu.unq.desapp.grupoG.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.unq.desapp.grupoG.model.User;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
