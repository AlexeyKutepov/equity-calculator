package ru.kutepov.db.dao;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import ru.kutepov.db.entity.Liability;

import java.sql.SQLException;

public class LiabilityDAO extends BaseDaoImpl<Liability, Integer> {

  protected LiabilityDAO(ConnectionSource connectionSource, Class<Liability> dataClass) throws SQLException {
    super(connectionSource, dataClass);
  }
}
