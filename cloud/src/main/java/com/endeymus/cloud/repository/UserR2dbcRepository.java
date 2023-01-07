package com.endeymus.cloud.repository;

import com.endeymus.cloud.model.entity.User;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.UUID;

/**
 * Реактивный репозиторий для взимодействия с User
 */
@Repository
public interface UserR2dbcRepository extends R2dbcRepository<User, UUID> {

    @Query("SELECT * FROM users u WHERE u.login in (:login)")
    Flux<User> findByLoginIn(@Param("login") List<String> login);
}
