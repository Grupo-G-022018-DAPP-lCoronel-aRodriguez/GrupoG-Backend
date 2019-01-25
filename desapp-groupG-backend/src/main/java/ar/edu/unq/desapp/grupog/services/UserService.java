package ar.edu.unq.desapp.grupog.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import ar.edu.unq.desapp.grupog.exceptions.InvalidIdException;
import ar.edu.unq.desapp.grupog.model.User;
import ar.edu.unq.desapp.grupog.repository.UserRepository;

@Service
public class UserService {
	
	private  UserRepository userRepository;
	
	UserService(UserRepository repository) {
		this.userRepository = repository;
	}

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User create(User user) {
		return userRepository.saveAndFlush(user);
	}

	public Optional<User> findById(Long id) {
		return userRepository.findById(id);
	}

	public User update(Long id, User modifiedUser){
		return userRepository.findById(id)
				.map(user -> {
					BeanUtils.copyProperties(modifiedUser, user);
					return userRepository.saveAndFlush(user);
				})
				.orElseThrow(InvalidIdException::new);
	}

	public User delete(Long id) {
		return userRepository.findById(id)
				.map(user -> {
					userRepository.delete(user);
					return user;
				})
				.orElseThrow(InvalidIdException::new);
	}

}
