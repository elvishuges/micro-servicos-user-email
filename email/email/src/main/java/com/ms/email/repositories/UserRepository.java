package com.ms.email.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ms.email.models.UserModel;

public interface UserRepository extends JpaRepository<UserModel, UUID> {

}
