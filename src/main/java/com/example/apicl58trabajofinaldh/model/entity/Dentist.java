package com.example.apicl58trabajofinaldh.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "dentist")
public class Dentist {


    @Id
    @SequenceGenerator(name = "dentist_sec", sequenceName = "dentist_sec",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dentist_sec")
    @Column(name = "id_dentist")
    private Long idDentist;
    @Column(name = "lisence_plate",unique = true, nullable = false)
    private String licensePlate;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;

    @OneToMany(mappedBy = "dentist")
    @JsonIgnore
    private Set<Turn> turnListDentist;
}
