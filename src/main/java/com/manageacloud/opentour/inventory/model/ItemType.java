package com.manageacloud.opentour.inventory.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * Item_Type table represents the main category for the inventory types in the database.
 *
 * Created by Ruben Rubio Rey
 */

@Entity
@Table(name = "item_types")
public class ItemType implements Serializable {

    public enum TYPE {

        POINT_OF_INTEREST(1),
        EVENT(2),
        PRODUCT(3);

        private int id;

        TYPE(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

    }


    @Id
    @GeneratedValue
    private Integer id;

//    @Column(name = "name", columnDefinition = "text[]")
//    @Convert(converter = ListToArrayConveter.class)
//    private List<String> name;

    protected  ItemType() {}

    public Integer getId() {
        return id;
    }

//    public List<String> getName() {
//        return name;
//    }

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
