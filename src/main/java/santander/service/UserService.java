package santander.service;

import org.springframework.stereotype.Service;
import santander.domain.model.User;

@Service
public interface UserService {

    User findById(Long id);

    User create(User userToCreate);


}