package com.manageacloud.opentour.inventory.repository;

import com.manageacloud.opentour.inventory.model.Item;
import com.manageacloud.opentour.inventory.model.ItemType;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Ruben Rubio
 * User tk421 on 27/06/16.
 */
@Repository
public interface ItemTypeRepository extends CrudRepository<ItemType, Long> {

}
