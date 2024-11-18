package org.moto.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import jakarta. persistence.MapsId;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "user_motorcycle")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserMotorcycle implements Serializable {

    @EmbeddedId
    private UserMotorcycleId id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @MapsId("motorcycleId")
    @JoinColumn(name = "motorcycle_id", nullable = false)
    private Motorcycle motorcycle;
}

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
class UserMotorcycleId implements Serializable {

    private UUID userId;
    private UUID motorcycleId;
}

