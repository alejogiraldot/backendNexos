package com.inventario.nexos.domain.application.ports.output.repository;


import com.inventario.nexos.domain.core.entity.UserNexos;
import org.apache.catalina.User;

import java.util.List;
import java.util.Optional;

public interface UserNexosRepository {
    UserNexos save(UserNexos user);
    Optional<UserNexos> findById(Integer id);
    UserNexos findByUserName(String userName);
    List<UserNexos> findAll();
}
