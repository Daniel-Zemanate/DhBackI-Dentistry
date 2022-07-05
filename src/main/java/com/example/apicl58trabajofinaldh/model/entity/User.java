package com.example.apicl58trabajofinaldh.model.entity;

//TODO: FALTA COMPLETAR LAS UNIONES DE ROL Y USUARIO VER - UNOaMUCHOS Y MUCHOSaMUCHOS

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "user")
public class User {

    @Id
    @SequenceGenerator(name = "sec_user", sequenceName = "sec_user", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sec_user")
    @Column(name = "id_user")
    private Long idUser;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private Role role;
}
