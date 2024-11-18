package org.moto.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.ManyToOne;
import jakarta. persistence.MapsId;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "maintenance_service")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MaintenanceService implements Serializable {

    @EmbeddedId
    private MaintenanceServiceId id;

    @ManyToOne
    @MapsId("maintenanceId")
    @JoinColumn(name = "maintenance_id", nullable = false)
    private Maintenance maintenance;

    @ManyToOne
    @MapsId("serviceTypeId")
    @JoinColumn(name = "service_type_id", nullable = false)
    private ServiceType serviceType;
}

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
class MaintenanceServiceId implements Serializable {

    private UUID maintenanceId;
    private UUID serviceTypeId;
}
