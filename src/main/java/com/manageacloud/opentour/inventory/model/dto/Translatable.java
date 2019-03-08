package com.manageacloud.opentour.inventory.model.dto;

import com.manageacloud.opentour.config.Lang;

/**
 * This request requires i18n, therefore it needs to be able to identify the language of the requests.
 */
public interface Translatable {

    public Lang getLang();

}
