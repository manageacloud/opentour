package com.manageacloud.opentour.inventory.service;

import com.manageacloud.opentour.config.Lang;
import com.manageacloud.opentour.inventory.model.Item;
import com.manageacloud.opentour.inventory.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {

    @Autowired
    ItemRepository itemRepository;

//    public Item addItem(Lang lang, Item newItem) {
//        long id = itemRepository.insertItem(lang.getId(), newItem.getCreatedUserId(), newItem.getName(lang));
//        return itemRepository.findById(id).orElse(null);
//    }

    public Item addItem(Item newItem) {
        newItem = itemRepository.save(newItem);
        return newItem;
    }


}
