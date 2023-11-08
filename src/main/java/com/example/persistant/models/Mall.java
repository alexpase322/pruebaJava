package com.example.persistant.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
public class Mall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mall")
    private Long idMall;

    private String name;

    @ManyToOne(targetEntity = Comercio.class)
    @JoinColumn(name = "comercio_id")
    private Comercio comercio;

    @OneToMany(targetEntity = Admin.class, fetch = FetchType.LAZY, mappedBy = "mall")
    @Column(nullable = false)
    private List<Admin> admin;

    //@ManyToMany(targetEntity = Watchman.class, fetch = FetchType.LAZY)
    //@JoinTable(joinColumns = @JoinColumn(name = "id_mall"), inverseJoinColumns = @JoinColumn(name = "id_watchman"))
    //private List<Watchman> watchmen;

    @OneToMany(targetEntity = MallWatchman.class, fetch = FetchType.LAZY, mappedBy = "mall")
    @Column(nullable = false)
    private List<MallWatchman> mall;

}
