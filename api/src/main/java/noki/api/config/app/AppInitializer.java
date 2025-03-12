package noki.api.config.app;

import noki.api.domain.user.User;
import noki.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AppInitializer implements CommandLineRunner {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        var userAdmin = userRepository.findByLogin("admin@admin");

        if (userAdmin == null) {
            User admin = new User();
            admin.setLogin("admin@admin");
            admin.setPassword(passwordEncoder.encode("admin"));

            userRepository.save(admin);
        }
    }
}
