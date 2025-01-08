package santander.service.impl;

import org.springframework.stereotype.Service;
import santander.domain.model.User;
import santander.domain.repository.UserRepository;
import santander.service.UserService;


import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public Iterable<User> buscarTodos() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        if (userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())){
            throw new IllegalArgumentException("This Account Number already exists.");
        }
        return userRepository.save(userToCreate);
    }

    @Override
    public void deletar(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void atualizar(Long id, User user) {
        Optional<User> userBd = userRepository.findById(id);
        if (userBd.isPresent()){
            userRepository.save(user);
        }
    }


}