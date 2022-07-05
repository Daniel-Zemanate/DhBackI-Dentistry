package com.example.apicl58trabajofinaldh.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//TODO: FALTA COMPLETAR LAS UNIONES DE ROL Y USUARIO VER - UNOaMUCHOS Y MUCHOSaMUCHOS

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "role")
public class Role {

    @Id
    @SequenceGenerator(name = "sec_role", sequenceName = "sec_role", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sec_role")
    @Column(name = "id_role")
    private Long idRole;

    @Column(name = "role_name")
    private String roleName;

    @OneToMany(mappedBy = "role")
    @JsonIgnore
    List<User> userList = new ArrayList<>();
}
