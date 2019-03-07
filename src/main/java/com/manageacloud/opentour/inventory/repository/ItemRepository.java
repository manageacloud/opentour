package com.manageacloud.opentour.inventory.repository;

import com.manageacloud.opentour.inventory.model.Item;
import com.manageacloud.opentour.users.model.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Ruben Rubio
 * User tk421 on 27/06/16.
 */
@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {

    @Transactional
    @Modifying
    @Query(value = "insert into items (created_user_id, name[:lang]) values (:userId, :name)", nativeQuery = true)
    int insertItem( @Param("lang") int lang,
                    @Param("userId") int userId,
                    @Param("name") String name);



}
