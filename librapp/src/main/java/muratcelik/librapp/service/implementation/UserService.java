package muratcelik.librapp.service.implementation;

import lombok.RequiredArgsConstructor;
import muratcelik.librapp.entity.User;
import muratcelik.librapp.repository.UserRepository;
import muratcelik.librapp.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Murat Çelik
 */
@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final UserRepository userRepository;

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void updateUser(User userDetails) {
        User user = userRepository.getOne(userDetails.getId());
        user.setName(userDetails.getName());
        user.setSurname(userDetails.getSurname());
        user.setEmail(userDetails.getEmail());
        userRepository.save(user);
    }

    @Override
    public User findUserByName(String userName) {
        return userRepository.findUserByName(userName);
    }
}
