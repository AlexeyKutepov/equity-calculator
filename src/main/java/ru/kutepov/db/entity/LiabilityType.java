package ru.kutepov.db.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Категория обязательства
 */
@DatabaseTable(tableName = "LiabilityType")
public class LiabilityType {

  @DatabaseField(id = true)
  private int id;

  @DatabaseField(unique = true, canBeNull = false)
  private String name;

  public LiabilityType() {
  }

  public LiabilityType(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public LiabilityType(String name) {
    this.name = name;
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
}
