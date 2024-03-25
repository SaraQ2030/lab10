package org.example.lab10.Service;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.lab10.Model.User;
import org.example.lab10.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> getUser(){
       return userRepository.findAll();
    }

    public Boolean addUser(User user){
        if (userRepository.equals(user)){
            return false;
        }
        userRepository.save(user);
        return true;
    }
    public Boolean updateUser(Integer id,User user){
        User u=userRepository.getReferenceById(id);
        if (userRepository.existsById(id)){
            u.setUserName(user.getUserName());
            u.setAge(user.getAge());
            u.setRole(user.getRole());
            userRepository.save(u);
            return true;
        }
        return false;
    }

    public Boolean deleteUser(Integer id){
        User u=userRepository.getReferenceById(id);
        if (userRepository.existsById(id)){
            userRepository.delete(u);
            return true;
        }
        return false;
    }


}
