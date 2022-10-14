package com.backend.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.crud.model.User;
import com.backend.crud.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
    private UserRepository userRepository;

    public List<User> obterTodos() {
        // regra de negocio caso tenha
        return userRepository.findAll();
    }

    public Optional<User> obterPorId(Integer id) {

        return userRepository.findById(id);

    }

    public User adicionar(User user) {

    	user.setId(null);
        return userRepository.save(user);

    }

    public void deletar(Integer id) {
        userRepository.deleteById(id);
    }

    public User atualizar(Integer id, User user) {
   
    	user.setId(id);
        return userRepository.save(user);

    }
}
