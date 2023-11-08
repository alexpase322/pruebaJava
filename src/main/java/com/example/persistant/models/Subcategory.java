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

public class Subcategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sub_category_id")
    private Long subCategoryId;

    @Column(unique = true)
    private String subcategoryName;

    @OneToMany(targetEntity = Comercio.class, fetch = FetchType.LAZY, mappedBy = "subCategory")
    private List<Comercio> comercio;

    @ManyToOne(targetEntity = Category.class)
    @JoinColumn(name="category_id")
    private Category category;
}
