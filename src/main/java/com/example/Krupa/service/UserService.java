package com.example.Krupa.service;

import com.example.Krupa.models.game;
import com.example.Krupa.models.users;
import com.example.Krupa.repo.gameRepository;
import com.example.Krupa.repo.usersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private usersRepository UsersRepository;

    @Autowired
    public UserService(usersRepository UsersRepository) {
        this.UsersRepository = UsersRepository;
    }

    public users findByuserID (Integer USER_ID) {
        return UsersRepository.findByuserID(USER_ID);
    }
    public users addUsers(String NAME, String PASSWORD, boolean IS_ADMIN) {
        users user = new users(NAME, PASSWORD, IS_ADMIN);
        return UsersRepository.save(user);
    }
    public List<users> AllUsers() {
        List<users> users = UsersRepository.findAll();
        return users;
    }
    public void DeleteUser(Integer USER_ID) {
        UsersRepository.delete(UsersRepository.findById(USER_ID).orElseThrow());
    }
    public ArrayList<users> ReadUser(Integer USER_ID) {
        Optional<users> users = UsersRepository.findById(USER_ID);
        ArrayList<users> readUser = new ArrayList<>();
        users.ifPresent(readUser::add);
        return readUser;
    }
    public users UpdateUser(Integer USER_ID, String NAME, String PASSWORD) {
        users user = UsersRepository.findById(USER_ID).orElseThrow();
        user.setNAME(NAME);
        user.setPASSWORD(PASSWORD);
        UsersRepository.save(user);
        return user;
    }
}
