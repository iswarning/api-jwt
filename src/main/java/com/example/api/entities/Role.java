package com.example.api.entities;

import com.example.api.common.ERole;

import javax.persistence.*;

@Entity(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Integer id;

    @Enumerated(EnumType.STRING)
    private ERole name;

    public Role(Integer id, ERole name) {
        this.id = id;
        this.name = name;
    }

    public Role() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ERole getName() {
        return name;
    }

    public void setName(ERole name) {
        this.name = name;
    }
}
