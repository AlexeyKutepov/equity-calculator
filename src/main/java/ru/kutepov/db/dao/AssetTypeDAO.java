package ru.kutepov.db.dao;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import ru.kutepov.db.entity.AssetType;

import java.sql.SQLException;

public class AssetTypeDAO extends BaseDaoImpl<AssetType, Integer> {

  public AssetTypeDAO(ConnectionSource connectionSource, Class<AssetType> dataClass) throws SQLException {
    super(connectionSource, dataClass);
  }
}
