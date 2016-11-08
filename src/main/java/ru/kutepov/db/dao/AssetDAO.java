package ru.kutepov.db.dao;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import ru.kutepov.db.entity.Asset;
import ru.kutepov.db.entity.AssetType;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AssetDAO extends BaseDaoImpl<Asset, Integer> {

  public AssetDAO(ConnectionSource connectionSource, Class<Asset> dataClass) throws SQLException {
    super(connectionSource, dataClass);
  }

  /**
   * Получить список активов определённой категории
   * @param assetType категория актива
   * @return {@link List<Asset>}
   */
  public List<Asset> getAssetListByAssetType(AssetType assetType) throws SQLException {
    Map<String, Object> map = new HashMap<>();
    map.put("assetType_id", assetType.getId());
    return this.queryForFieldValues(map);
  }
}
