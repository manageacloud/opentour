package com.manageacloud.opentour.inventory.model.dto;

import com.manageacloud.opentour.config.Lang;
import com.manageacloud.opentour.inventory.model.ItemType;

/**
 * Defines the object that will contain the parameters to create and update Items.
 *
 *
 */
public class ItemDTO  implements Translatable, Identificable  {

    private int lang;

    private int userId;

    private String name;

    private String itemType;

    private long regionId;

    public ItemDTO(int lang, int userId, String name, String itemType, long regionId) {
        this.lang = lang;
        this.userId = userId;
        this.name = name;
        this.itemType = itemType;
        this.regionId = regionId;
    }

    public String getName() {
        return name;
    }

    public ItemType.TYPE getItemType() {
        return ItemType.TYPE.valueOf(itemType);
    }

    public long getRegionId() {
        return regionId;
    }

    @Override
    public Lang getLang() {
        return Lang.valueOf(this.lang);
    }

    @Override
    public int getUserId() {
        return this.userId;
    }
}
