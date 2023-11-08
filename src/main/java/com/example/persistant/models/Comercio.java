package com.example.persistant.models;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Comercio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comercio")
    private Long idComercio;

    @Column(unique = true)
    private String nombre;

    @ManyToOne(targetEntity = Location.class)
    @JoinColumn(name = "location_id")
    private Location location;

    @OneToOne(targetEntity = Manager.class)
    @JoinColumn(name = "manager_id")
    private Manager manager;

    @ManyToOne(targetEntity = ComercioStatus.class)
    @JoinColumn(name="comercio_status_id")
    private ComercioStatus comercioStatus;

    @ManyToOne(targetEntity = Subcategory.class)
    @JoinColumn(name="sub_category_id")
    private Subcategory subCategory;

    @OneToMany(targetEntity = Mall.class, fetch = FetchType.LAZY, mappedBy = "comercio")
    private List<Mall> malls;
}
