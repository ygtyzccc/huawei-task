package com.yazici.huaweitask.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yazici.huaweitask.entity.enums.ParkStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@Builder
@Entity
@Table(name = "park")
@NoArgsConstructor
@AllArgsConstructor
public class Park {

  @GeneratedValue @Id private Long id;

  @Column(name = "create_date", updatable = false, nullable = false)
  private LocalDateTime createDate;

  @Column(name = "update_date")
  private LocalDateTime updateDate;

  @Column(name = "check_in_date")
  private LocalDateTime checkInDate;

  @Column(name = "check_out_date")
  private LocalDateTime checkOutDate;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "vehicle_id", nullable = false)
  @JsonIgnore
  private Vehicle vehicle;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "parking_area_id", nullable = false)
  @JsonIgnore
  private ParkingArea parkingArea;

  @Column(name = "fee")
  private Double fee;

  @Column(name = "status")
  @Enumerated(EnumType.STRING)
  private ParkStatus status;

  @PrePersist
  public void onCreate() {
    this.createDate = LocalDateTime.now();
  }

  @PostPersist
  public void onUpdate() {
    this.updateDate = LocalDateTime.now();
  }
}
