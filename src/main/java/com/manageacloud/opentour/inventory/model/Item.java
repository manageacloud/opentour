package com.manageacloud.opentour.inventory.model;

import com.manageacloud.opentour.config.Lang;
import com.vladmihalcea.hibernate.type.array.IntArrayType;
import com.vladmihalcea.hibernate.type.array.StringArrayType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

/**
 * Item table represents the base of any inventory
 *
 * Created by Ruben Rubio Rey
 */

@TypeDefs({
        @TypeDef(
                name = "string-array",
                typeClass = StringArrayType.class
        ),
        @TypeDef(
                name = "int-array",
                typeClass = IntArrayType.class
        )
})

@Entity
@Table(name = "items")
public class Item implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_user_id")
    private Integer createdUserId;

    @OneToOne
    @JoinColumn(name = "item_type_id", referencedColumnName = "id")
    private ItemType itemType;

    @OneToOne
    @JoinColumn(name = "region_id", referencedColumnName = "id")
    private Region region;


    @Type( type = "string-array" )
    @Column( name = "name", columnDefinition = "text[]" )
    private String[] name;

    private Float lat;
    private Float lng;

    protected  Item() {}

    public Item(Lang lang, Integer createdUserId, String name, ItemType itemType, Region region)  {
        this.createdUserId = createdUserId;
        this.name = new String[Lang.values().length];
        this.itemType = itemType;
        this.name[lang.getId()] = name;
        this.region = region;
    }

    public Item(Integer createdUserId, String[] name) {
        this.createdUserId = createdUserId;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public Integer getCreatedUserId() {
        return createdUserId;
    }

    public List<String> getName() {
        return Arrays.asList(this.name);
    }

    public String getName(Lang lang) {
            return name[lang.getId()];
    }


    public Float getLat() {
        return lat;
    }

    public Float getLng() {
        return lng;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public Region getRegion() {
        return region;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", createdUserId=" + createdUserId +
                ", name=" + name +
                ", lat=" + lat +
                ", lng=" + lng +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(id, item.id) &&
                Objects.equals(createdUserId, item.createdUserId) &&
                Objects.equals(name, item.name) &&
                Objects.equals(lat, item.lat) &&
                Objects.equals(lng, item.lng);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdUserId, /*name,*/ lat, lng);
    }
}
