package com.example.wbdvsp20jannunziserverjava.repositories;

import com.example.wbdvsp20jannunziserverjava.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository
        extends CrudRepository<User, Integer> {
}
