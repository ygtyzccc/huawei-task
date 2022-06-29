package com.yazici.huaweitask.entity;

import com.yazici.huaweitask.entity.enums.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@Entity
@Table(name = "vehicle")
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {

  @GeneratedValue @Id private Long id;

  @Column(name = "create_date", updatable = false, nullable = false)
  private LocalDateTime createDate;

  @Column(name = "update_date")
  private LocalDateTime updateDate;

  @Column(name = "license_plate", nullable = false, unique = true)
  private String licensePlate;

  @Column(name = "type")
  @Enumerated(EnumType.STRING)
  private VehicleType type;

  @OneToMany(mappedBy = "vehicle", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
  @OrderBy("checkOutDate")
  private List<Park> parks;

  @PrePersist
  public void onCreate() {
    this.createDate = LocalDateTime.now();
  }

  @PostPersist
  public void onUpdate() {
    this.updateDate = LocalDateTime.now();
  }
}
