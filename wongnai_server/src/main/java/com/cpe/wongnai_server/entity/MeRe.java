package com.cpe.wongnai_server.entity;
import lombok.*;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.*;
@Entity
@Getter @Setter
@NoArgsConstructor
@
    ToString @EqualsAndHashCode
@Table(name = "MeRe")
public class MeRe {
    @Id
    @SequenceGenerator(name = "mere_seq", sequenceName = "mere_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mere_seq")
    private @NonNull Long mr_id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "reme_ID", insertable = true)
    private  Restaurant freme;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "mere_ID", insertable = true)
    private  Menu fmere;



}