package com.example.apicl58trabajofinaldh;

import com.example.apicl58trabajofinaldh.model.entity.Role;
import com.example.apicl58trabajofinaldh.model.entity.User;
import com.example.apicl58trabajofinaldh.repository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

public class DataLoader implements ApplicationRunner {


    private UserRespository userRespository;

    @Autowired
    public DataLoader(UserRespository userRespository) {
        this.userRespository = userRespository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        userRespository.save(new User("admin", "admin", Role.ADMIN));
        userRespository.save(new User("user", "user", Role.USER));
    }
}
