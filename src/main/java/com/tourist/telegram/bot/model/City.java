
package com.tourist.telegram.bot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "city")
public class City {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "city_name_RUS")
    private String nameRus;
    
    @Column(name = "city_name_ENG")
    private String nameEng;
    
    @Column(name = "information_RUS")
    private String informationRus;
    
    @Column(name = "information_ENG")
    private String informationEng;
}
