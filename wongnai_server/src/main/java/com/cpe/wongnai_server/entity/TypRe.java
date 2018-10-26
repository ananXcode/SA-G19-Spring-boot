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
@Table(name = "ReCa")
public class TypRe {
    @Id 
    @SequenceGenerator(name = "typre_seq", sequenceName = "typre_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "typre_seq")
    private @NonNull Long tr_id;
   
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "reca_ID", insertable = true)
    private  Restaurant freca;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "care_ID", insertable = true)
    private  Category fcare;
    

   
    
}