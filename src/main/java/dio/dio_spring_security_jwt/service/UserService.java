package dio.dio_spring_security_jwt.service;

import org.springframework.beans.factory.annotation.Autowired;
import dio.dio_spring_security_jwt.model.AppUser;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import dio.dio_spring_security_jwt.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private PasswordEncoder encoder;

    public void createUser(AppUser user) {
        String pass = user.getPassword();
        // Criptografando antes de salvar no banco
        user.setPassword(encoder.encode(pass));
        repository.save(user);
    }
}
