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
@Table(name = "workshop")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Workshop {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "workshop_id", updatable = false, nullable = false)
    private UUID workshopId;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(name = "contact_info")
    private String contactInfo;

    @OneToMany(mappedBy = "workshop", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Maintenance> maintenances;
}

