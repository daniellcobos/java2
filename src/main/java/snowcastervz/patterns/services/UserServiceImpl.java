package snowcastervz.patterns.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import snowcastervz.patterns.dao.UserRepository;
import snowcastervz.patterns.model.AppUser;


@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository theUserRepository) {
        userRepository = theUserRepository;
    }

    @Override
    public List<AppUser> findAll() {
        return userRepository.findAll();
    }

    @Override
    public AppUser findById(int theId) {
        Optional<AppUser> result = userRepository.findById(theId);

        AppUser theAppUser = null;

        if (result.isPresent()) {
            theAppUser = result.get();
        }
        else {
            // we didn't find the user
            throw new RuntimeException("Did not find user id - " + theId);
        }

        return theAppUser;
    }

    @Override
    public void save(AppUser theAppUser) {
        userRepository.save(theAppUser);
    }

    @Override
    public void deleteById(int theId) {
        userRepository.deleteById(theId);
    }

}
