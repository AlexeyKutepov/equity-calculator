package ru.kutepov.db.dao;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import ru.kutepov.db.entity.LiabilityType;

import java.sql.SQLException;
import java.util.List;

public class LiabilityTypeDAO extends BaseDaoImpl<LiabilityType, Integer> {

  protected LiabilityTypeDAO(ConnectionSource connectionSource, Class<LiabilityType> dataClass) throws SQLException {
    super(connectionSource, dataClass);
  }

  /**
   * Получить список категорий обязательств
   * @return {@link List<LiabilityType>}
   */
  public List<LiabilityType> getLiabilityTypeList() throws SQLException {
    return this.queryForAll();
  }
}
