package ac.in.cutm.erp.exam.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import ac.in.cutm.erp.exam.helper.UserFoundException;
import ac.in.cutm.erp.exam.helper.UserNotFoundException;
import ac.in.cutm.erp.exam.model.Role;
import ac.in.cutm.erp.exam.model.User;
import ac.in.cutm.erp.exam.model.UserRole;
import ac.in.cutm.erp.exam.repo.RoleRepository;
import ac.in.cutm.erp.exam.repo.UserRepository;
import ac.in.cutm.erp.exam.service.UserService;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    //creating user
    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {


        User local = this.userRepository.findByUsername(user.getUsername());
        if (local != null) {
            System.out.println("User is already there !!");
            throw new UserFoundException();
        } else {
            //user create
            for (UserRole ur : userRoles) {
                roleRepository.save(ur.getRole());
            }

            user.getUserRoles().addAll(userRoles);
            local = this.userRepository.save(user);

        }

        return local;
    }

    //getting user by username
    @Override
    public User getUser(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public void deleteUser(Long userId) {
        this.userRepository.deleteById(userId);
    }


}
