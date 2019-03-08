package com.manageacloud.opentour.config;

public enum Lang {
    ES_ES(0),
    EN_AU(1);

    private int id;

    Lang(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static int size() {
        return Lang.values().length;
    }

    public static Lang valueOf(int position) {
        Lang toretun = null;
        for (Lang lang : Lang.values()) {
            if ( lang.getId() == position ) {
                toretun = lang;
            }
        }
        return toretun;
    }
}
