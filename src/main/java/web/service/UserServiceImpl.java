package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.Repository.UserRepository;
import web.models.User;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserRepository userDao;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.save(user);
    }

    @Override
    @Transactional (readOnly = true)
    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    @Override
    @Transactional (readOnly = true)
    public User getUserById(Long id) {
        return userDao.getById(id);
    }

    @Override
    public void removeUserById(Long id) {
        userDao.deleteById(id);
    }


    @Override
    public void edit(Long id, User u) {
        u.setPassword(passwordEncoder.encode(u.getPassword()));
        userDao.saveAndFlush(u);
    }
}
