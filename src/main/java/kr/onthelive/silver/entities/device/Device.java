package kr.onthelive.silver.entities.device;

import kr.onthelive.silver.entities.profile.Senior;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "device")
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "senior_id")
    private Senior senior;

    @Column(name = "device_uid")
    private String deviceId;

    @Column(name = "device_type")
    private String deviceType;

    @OneToOne(mappedBy = "device", cascade = CascadeType.ALL, orphanRemoval = true)
    private Alarm alarm;

}