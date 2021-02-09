package muratcelik.librapp.service;

import muratcelik.librapp.entity.User;

import java.util.List;
import java.util.Optional;

/**
 * @author Murat Çelik
 */
public interface IUserService {

    List<User> getAllUser();

    Optional<User> getUserById(Long id);

    void addUser(User user);

    void deleteUser(Long id);

    void updateUser(User userDetails);

    User findUserByName(String userName);
}
