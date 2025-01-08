package santander.service;

import org.springframework.stereotype.Service;
import santander.domain.model.User;

@Service
public interface UserService {

    Iterable<User> buscarTodos();

    User findById(Long id);

    User create(User userToCreate);

    void deletar(Long id);

    void atualizar(Long id, User user);

}