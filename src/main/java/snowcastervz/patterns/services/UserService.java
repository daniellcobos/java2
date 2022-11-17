package snowcastervz.patterns.services;

import snowcastervz.patterns.model.AppUser;

import java.util.List;

public interface UserService {

    public List<AppUser> findAll();

    public AppUser findById(int theId);

    public void save(AppUser theAppUser);

    public void deleteById(int theId);

}