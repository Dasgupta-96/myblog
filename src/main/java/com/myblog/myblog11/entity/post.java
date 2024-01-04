package com.myblog.myblog11.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.boot.internal.GenerationStrategyInterpreter;

@Data
@Entity
@Table(name="post")
@AllArgsConstructor
@NoArgsConstructor
public class post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String description;
    private String content;
    private String title;


}
