package org.moto.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.UUID;

@Entity
@Table(name = "parts_replaced")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PartsReplaced {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "part_id", updatable = false, nullable = false)
    private UUID partId;

    @ManyToOne
    @JoinColumn(name = "maintenance_id", nullable = false)
    private Maintenance maintenance;

    @Column(name = "part_name", nullable = false, length = 100)
    private String partName;

    @Column(name = "part_cost", nullable = false)
    private String partCost;
}

