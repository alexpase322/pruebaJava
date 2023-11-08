package com.example.persistant.models;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_admin")
    private Long idAdmin;

    private String name;
    @Column(name = "last_name")
    private String lastName;

    @ManyToOne(targetEntity = Mall.class)
    @JoinColumn(name = "mall_id")
    private Mall mall;
}
