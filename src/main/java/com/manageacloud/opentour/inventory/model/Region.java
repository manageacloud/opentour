package com.manageacloud.opentour.inventory.model;


import javax.persistence.*;
import java.io.Serializable;

/**
 * Region Table represents the region tree
 *
 * Created by Ruben Rubio Rey
 */

@Entity
@Table(name = "regions")
public class Region implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

//    @Column(name = "subject", columnDefinition = "text[]")
//    @Convert(converter = ListToArrayConveter.class)
//    private List<String> name;



}
