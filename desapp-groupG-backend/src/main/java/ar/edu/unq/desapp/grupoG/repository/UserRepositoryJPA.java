package ar.edu.unq.desapp.grupoG.repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import ar.edu.unq.desapp.grupoG.model.User;

public interface UserRepositoryJPA extends JpaRepository<User, Id>{
	
	
}