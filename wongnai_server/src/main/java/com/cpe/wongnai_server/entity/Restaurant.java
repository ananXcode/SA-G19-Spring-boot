package com.cpe.wongnai_server.entity;
import lombok.*;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.*;

@Data
@Entity
@Getter @Setter
@Table(name = "Restaurants")
public class Restaurant {
    @Id 
    @SequenceGenerator(name = "res_seq", sequenceName = "res_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "res_seq")
    private @NonNull Long rid;
    private  @NonNull String rname;
    private @NonNull String raddress;
    private  String rtel;
    public Restaurant() {
    }

    public Restaurant(String rname, String raddress) {
        this.rname = rname;
        this.raddress = raddress;
    }
}