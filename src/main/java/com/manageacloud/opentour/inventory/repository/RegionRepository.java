package com.manageacloud.opentour.inventory.repository;

import com.manageacloud.opentour.inventory.model.Item;
import com.manageacloud.opentour.inventory.model.Region;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Ruben Rubio
 * User tk421 on 27/06/16.
 */
@Repository
public interface RegionRepository extends CrudRepository<Region, Long> {

}
