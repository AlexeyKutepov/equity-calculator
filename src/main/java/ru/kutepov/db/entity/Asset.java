package ru.kutepov.db.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Актив
 */
@DatabaseTable(tableName = "Asset")
public class Asset {

  @DatabaseField(generatedId = true)
  private int id;

  @DatabaseField(canBeNull = false)
  private String name;

  @DatabaseField(canBeNull = false)
  private double value;

  @DatabaseField(foreign = true, canBeNull = false)
  private AssetType assetType;

  public Asset() {
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

  public AssetType getAssetType() {
    return assetType;
  }

  public void setAssetType(AssetType assetType) {
    this.assetType = assetType;
  }
}
