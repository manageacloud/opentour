package com.manageacloud.opentour.inventory.model;


import com.manageacloud.opentour.config.Lang;
import com.vladmihalcea.hibernate.type.array.IntArrayType;
import com.vladmihalcea.hibernate.type.array.StringArrayType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Item_Type table represents the main category for the inventory types in the database.
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
@Table(name = "item_types")
public class ItemType implements Serializable {

    /**
     * Main item types: Point of Interest, Events or Products.
     *
     */
    public enum TYPE {

        POINT_OF_INTEREST(1),
        EVENT(2),
        PRODUCT(3);

        private long id;

        TYPE(int id) {
            this.id = id;
        }

        public long getId() {
            return id;
        }

    }


    @Id
    @GeneratedValue
    private Long id;

    @Type( type = "string-array" )
    @Column( name = "name", columnDefinition = "text[]" )
    private String[] name;

    protected  ItemType() {}

    public Long getId() {
        return id;
    }

    public List<String> getName() {
        return Arrays.asList(this.name);
    }

    public String getName(Lang lang) {
        return name[lang.getId()];
    }

    @Override
    public String toString() {
        return "ItemType{" +
                "id=" + id +
                //", name=" + name +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemType itemType = (ItemType) o;
        return Objects.equals(id, itemType.id) /*&& Objects.equals(name, itemType.name)*/;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id/*, name*/);
    }
}
