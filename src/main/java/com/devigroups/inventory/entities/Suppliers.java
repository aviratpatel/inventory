package com.devigroups.inventory.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="suppliers")
@Getter
@Setter
@NoArgsConstructor // <--- THIS is it
public class Suppliers {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private Integer suppId;
    private String suppName;
    private Integer prodId;
    private Integer bufferStock;
    private String unitOfMeasure;
    private Integer costPerUnit;
}
