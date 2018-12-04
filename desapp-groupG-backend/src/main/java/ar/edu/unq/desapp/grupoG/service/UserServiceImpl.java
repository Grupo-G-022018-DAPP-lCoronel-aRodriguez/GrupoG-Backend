package ar.edu.unq.desapp.grupoG.service;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ar.edu.unq.desapp.grupoG.exceptions.InvalidPasswordException;
import ar.edu.unq.desapp.grupoG.model.User;
import ar.edu.unq.desapp.grupoG.repository.AuctionRepository;
import ar.edu.unq.desapp.grupoG.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService {
	
	//@Autowired
    private UserRepository userRepository;
	
    //@Autowired
    private AuctionRepository auctionRepository;
    
    //@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


	@Override
	public void save(User user) {
        try {
			user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		} catch (InvalidPasswordException e) {
			e.printStackTrace();
		}
        user.setAuctions(new HashSet<>(auctionRepository.findAll()));
        userRepository.save(user);

	}

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

}
