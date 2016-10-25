package ru.kutepov.db.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Обязательства
 */
@DatabaseTable(tableName = "Liability")
public class Liability {

  @DatabaseField(generatedId = true)
  private int id;

  @DatabaseField(canBeNull = false)
  private String name;

  @DatabaseField(canBeNull = false)
  private double value;

  @DatabaseField(foreign = true, canBeNull = false, foreignAutoRefresh = true)
  private LiabilityType liabilityType;

  public Liability() {
  }

  public Liability(String name, double value, LiabilityType liabilityType) {
    this.name = name;
    this.value = value;
    this.liabilityType = liabilityType;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getValue() {
    return value;
  }

  public void setValue(double value) {
    this.value = value;
  }

  public LiabilityType getLiabilityType() {
    return liabilityType;
  }

  public void setLiabilityType(LiabilityType liabilityType) {
    this.liabilityType = liabilityType;
  }
}
