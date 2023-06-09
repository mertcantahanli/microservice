package com.kodlamaio.inventoryservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="models")
public class Model {
    @Id@GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;

    @ManyToOne
    @JoinColumn(name="brand_id")
    private  Brand brand;
    @OneToMany(mappedBy = "model", cascade = CascadeType.ALL)
    private List<Car> cars;
}
