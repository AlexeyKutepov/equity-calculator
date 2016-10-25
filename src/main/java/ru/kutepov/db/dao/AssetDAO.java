package ru.kutepov.db.dao;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import ru.kutepov.db.entity.Asset;

import java.sql.SQLException;
import java.util.List;

public class AssetDAO extends BaseDaoImpl<Asset, Integer> {

  public AssetDAO(ConnectionSource connectionSource, Class<Asset> dataClass) throws SQLException {
    super(connectionSource, dataClass);
  }

  public List<Asset> getAssetList() throws SQLException {
    return this.queryForAll();
  }

  public Asset createAsset(Asset asset) throws SQLException {
    this.create(asset);
    return asset;
  }
}
