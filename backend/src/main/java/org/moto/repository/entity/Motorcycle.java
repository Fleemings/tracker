package org.moto.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta. persistence.CascadeType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "motorcycle")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Motorcycle {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "motorcycle_id", updatable = false, nullable = false)
    private UUID motorcycleId;

    @Column(nullable = false, length = 100)
    private String brand;

    @Column(nullable = false, length = 100)
    private String model;

    @Column(nullable = false)
    private Integer year;

    @OneToMany(mappedBy = "motorcycle", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserMotorcycle> userMotorcycles;

    @OneToMany(mappedBy = "motorcycle", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Maintenance> maintenances;
}
