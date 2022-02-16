package ac.in.cutm.erp.exam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import ac.in.cutm.erp.exam.helper.UserFoundException;
import ac.in.cutm.erp.exam.model.Role;
import ac.in.cutm.erp.exam.model.User;
import ac.in.cutm.erp.exam.model.UserRole;
import ac.in.cutm.erp.exam.model.exam.Quiz;
import ac.in.cutm.erp.exam.repo.QuizRepository;
import ac.in.cutm.erp.exam.service.UserService;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class ExamserverApplication implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public QuizRepository quizRepository;

    public static void main(String[] args) {


        SpringApplication.run(ExamserverApplication.class, args);


    }

    @Override
    public void run(String... args) throws Exception {
        try {


            System.out.println("starting code");
//
            User user = new User();

            user.setFirstName("Durgesh");
            user.setLastName("Tiwari");
            user.setUsername("durgesh8896");
            user.setPassword(this.bCryptPasswordEncoder.encode("abc"));
            user.setEmail("abc@gmail.com");
            user.setProfile("default.png");

            Role role1 = new Role();
            role1.setRoleId(44L);
            role1.setRoleName("ADMIN");

            Set<UserRole> userRoleSet = new HashSet<>();
            UserRole userRole = new UserRole();

            userRole.setRole(role1);

            userRole.setUser(user);

            userRoleSet.add(userRole);

            User user1 = this.userService.createUser(user, userRoleSet);
            System.out.println(user1.getUsername());


        } catch (UserFoundException e) {
            e.printStackTrace();


        }


    }


}
