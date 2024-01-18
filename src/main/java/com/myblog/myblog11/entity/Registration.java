package com.myblog.myblog11.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="reg")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Registration {

    @Id

    private int id;
    private String name;
    private String city;
    private String email;

}
