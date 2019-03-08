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
 * Region Table represents the region tree
 * TODO import data and define properly region levels
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
@Table(name = "regions")
public class Region implements Serializable {

    public enum Regions {

        SPAIN(1L);

        private Long id;

        Regions(Long regionId) {
            this.id = regionId;
        }

        public Long getId() {
            return id;
        }
    }

    @Id
    @GeneratedValue
    private Long id;

    @Type( type = "string-array" )
    @Column( name = "name", columnDefinition = "text[]" )
    private String[] name;

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
        return "Region{" +
                "id=" + id +
                ", name=" + Arrays.toString(name) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Region region = (Region) o;
        return Objects.equals(id, region.id) &&
                Arrays.equals(name, region.name);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id);
        result = 31 * result + Arrays.hashCode(name);
        return result;
    }
}
