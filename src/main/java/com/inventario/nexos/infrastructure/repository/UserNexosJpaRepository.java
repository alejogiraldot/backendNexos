package com.inventario.nexos.infrastructure.repository;

import com.inventario.nexos.infrastructure.entity.MerchandiseEntity;
import com.inventario.nexos.infrastructure.entity.UserNexosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserNexosJpaRepository extends JpaRepository<UserNexosEntity,Integer> {
    UserNexosEntity findByUserName(String userName);
}
