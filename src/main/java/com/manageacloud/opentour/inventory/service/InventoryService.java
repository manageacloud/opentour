package com.manageacloud.opentour.inventory.service;

import com.manageacloud.opentour.config.Lang;
import com.manageacloud.opentour.inventory.model.Item;
import com.manageacloud.opentour.inventory.model.ItemType;
import com.manageacloud.opentour.inventory.model.Region;
import com.manageacloud.opentour.inventory.model.dto.ItemDTO;
import com.manageacloud.opentour.inventory.repository.ItemRepository;
import com.manageacloud.opentour.inventory.repository.ItemTypeRepository;
import com.manageacloud.opentour.inventory.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    ItemTypeRepository itemTypeRepository;

    @Autowired
    RegionRepository regionRepository;


    public Item addItem(ItemDTO newItemDTO) {

        ItemType itemType = itemTypeRepository.findById(newItemDTO.getItemType().getId())
                .orElse(null);

        Region region = regionRepository.findById(newItemDTO.getRegionId()).orElse(null);

        Item item = new Item(newItemDTO.getLang(), newItemDTO.getUserId(),
                newItemDTO.getName(), itemType, region);

        return itemRepository.save(item);
    }


}
