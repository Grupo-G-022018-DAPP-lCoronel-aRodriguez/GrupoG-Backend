package ar.edu.unq.desapp.grupoG.service;

import ar.edu.unq.desapp.grupoG.model.User;

public interface UserService {
	    void save(User user);

	    User findByUsername(String username);
}
