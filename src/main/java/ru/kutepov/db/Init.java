package ru.kutepov.db;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import org.springframework.stereotype.Component;
import ru.kutepov.db.entity.Asset;
import ru.kutepov.db.entity.AssetType;
import ru.kutepov.db.entity.Liability;
import ru.kutepov.db.entity.LiabilityType;

import javax.inject.Inject;
import java.sql.SQLException;
import java.util.List;

@Component
public class Init {

  @Inject
  private ConnectionSource connectionSource;

  public void init() throws SQLException {
    TableUtils.createTableIfNotExists(connectionSource, AssetType.class);
    TableUtils.createTableIfNotExists(connectionSource, Asset.class);
    TableUtils.createTableIfNotExists(connectionSource, LiabilityType.class);
    TableUtils.createTableIfNotExists(connectionSource, Liability.class);

    populateAssetType();
    populateLiabilityType();
  }

  private void populateAssetType() throws SQLException {
    Dao<AssetType, Integer> assetTypeDao = DaoManager.createDao(connectionSource, AssetType.class);

    // Проверяем есть ли что-нибудь в таблице
    List<AssetType> assetTypeList = assetTypeDao.queryForAll();
    if (assetTypeList == null || assetTypeList.isEmpty()) {
      // Если таблица пустая, то заполняем
      assetTypeDao.create(new AssetType(1, "Крупные активы и недвижимость"));
      assetTypeDao.create(new AssetType(2, "Ликвидные активы"));
      assetTypeDao.create(new AssetType(3, "Ценные бумаги"));
    }
  }

  private void populateLiabilityType() throws SQLException {
    Dao<LiabilityType, Integer> liabilityTypeDao = DaoManager.createDao(connectionSource, LiabilityType.class);

    // Проверяем есть ли что-нибудь в таблице
    List<LiabilityType> liabilityTypeList = liabilityTypeDao.queryForAll();
    if (liabilityTypeList == null || liabilityTypeList.isEmpty()) {
      // Если таблица пустая, то заполняем
      liabilityTypeDao.create(new LiabilityType(1, "Долгосрочные обязательства"));
      liabilityTypeDao.create(new LiabilityType(2, "Краткосрочные обязательства"));
    }
  }
}
