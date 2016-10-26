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

  /**
   * Получить список активов
   * @return {@link List<Asset>}
   */
  public List<Asset> getAssetList() throws SQLException {
    return this.queryForAll();
  }

  /**
   * Добавить актив
   * @param asset актив
   * @return {@link Asset}
   */
  public Asset createAsset(Asset asset) throws SQLException {
    this.create(asset);
    return asset;
  }

  /**
   * Удалить актив
   * @param id идентификатор актива
   */
  public void deleteAsset(int id) throws SQLException {
    this.deleteById(id);
  }
}
