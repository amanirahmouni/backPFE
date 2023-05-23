package tn.arabsoft.auth.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.arabsoft.auth.entity.Personnel;
import tn.arabsoft.auth.entity.User;
import tn.arabsoft.auth.repository.PersonnelRepository;
import tn.arabsoft.auth.repository.UserRepository;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    public UserRepository userRepository;
@Autowired
public PersonnelRepository personnelRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user)

    {
        Personnel personnel=new Personnel();
        personnel.setMatricule(user.getMatricule());
        personnel.setNom(user.getLastName());
        personnel.setCOD_SOC("1");
        personnelRepository.save(personnel);
        return userRepository.save(user);
    }

    public User getUserById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.orElse(null);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);} 
    
  
    }
    
    



