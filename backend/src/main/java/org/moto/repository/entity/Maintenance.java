package org.moto.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "maintenance")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Maintenance {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "maintenance_id", updatable = false, nullable = false)
    private UUID maintenanceId;

    @ManyToOne
    @JoinColumn(name = "motorcycle_id", nullable = false)
    private Motorcycle motorcycle;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "service_date", nullable = false)
    private OffsetDateTime serviceDate;

    @Column(name = "odometer_reading")
    private Integer odometerReading;

    @Column(name = "total_cost", nullable = false)
    private BigDecimal totalCost;

    @Column(name = "part_replaced")
    private Boolean partReplaced;

    @Column(name = "next_service_date")
    private OffsetDateTime nextServiceDate;

    @Column(name = "comments")
    private String comments;

    @ManyToOne
    @JoinColumn(name = "workshop_id")
    private Workshop workshop;

    @OneToMany(mappedBy = "maintenance", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PartsReplaced> partsReplaced;

    @OneToMany(mappedBy = "maintenance", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MaintenanceService> maintenanceServices;
}


