package com.yazici.huaweitask.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@Entity
@Table(name = "parking_area")
@NoArgsConstructor
@AllArgsConstructor
public class ParkingArea {


  @GeneratedValue @Id private Long id;

  @Column(name = "create_date", updatable = false, nullable = false)
  private LocalDateTime createDate;

  @Column(name = "update_date")
  private LocalDateTime updateDate;

  @Column(name = "name", nullable = false, unique = true)
  private String name;

  @Column(name = "capacity", nullable = false)
  private Integer capacity;

  @Column(name = "city", nullable = false)
  private String city;

  @OneToMany(mappedBy = "parkingArea", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
  private List<PriceList> priceLists;

  @OneToMany(mappedBy = "parkingArea", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
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
