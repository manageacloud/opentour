package com.manageacloud.opentour.users.repository;

import com.manageacloud.opentour.users.model.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Ruben Rubio
 * User tk421 on 27/06/16.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Query("select u from User u where u.email = :email")
    List<User> findByEmail(@Param("email") String email);

    @Query("select u from User u where u.cookie = :cookie")
    List<User> findByCookie(@Param("cookie") String cookie);

    @Query(value = "select u.* from users u where u.phone = :phone", nativeQuery = true)
    List<User> findByPhone(@Param("phone") String phone);

    @Query(value = "select u.* from users u WHERE u.email = lower(trim(?1)) LIMIT 1", nativeQuery = true)
    List<User> findByEmailIgnoreCaseContaining(String email);


}
