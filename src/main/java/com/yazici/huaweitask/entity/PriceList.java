package com.yazici.huaweitask.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "price_list")
@NoArgsConstructor
@AllArgsConstructor
public class PriceList  {

  @GeneratedValue @Id private Long id;

  @Column(name = "create_date", updatable = false, nullable = false)
  private LocalDateTime createDate;

  @Column(name = "update_date")
  private LocalDateTime updateDate;

  @Column(name = "start_hour")
  private Integer startHour;

  @Column(name = "end_hour")
  private Integer endHour;

  @Column(name = "price")
  private Long price;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "park_area_id", nullable = false)
  @JsonIgnore
  private ParkingArea parkingArea;

  @PrePersist
  public void onCreate() {
    this.createDate = LocalDateTime.now();
  }

  @PostPersist
  public void onUpdate() {
    this.updateDate = LocalDateTime.now();
  }
}
