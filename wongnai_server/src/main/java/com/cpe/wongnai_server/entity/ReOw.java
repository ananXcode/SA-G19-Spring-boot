package com.cpe.wongnai_server.entity;
import lombok.*;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.*;
@Entity
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
@Table(name = "ReOw")
public class ReOw {
    @Id 
    @SequenceGenerator(name = "reow_seq", sequenceName = "reow_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reow_seq")
    private @NonNull Long owr_id;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "reow_id", insertable = true)
    private  Restaurant freow;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "owre_id", insertable = true)
    private  Owner fowre;
}