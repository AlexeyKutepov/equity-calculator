package ru.kutepov.db.dao;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import ru.kutepov.db.entity.Liability;

import java.sql.SQLException;
import java.util.List;

public class LiabilityDAO extends BaseDaoImpl<Liability, Integer> {

  protected LiabilityDAO(ConnectionSource connectionSource, Class<Liability> dataClass) throws SQLException {
    super(connectionSource, dataClass);
  }

  /**
   * Получить список обязательств
   * @return {@link List<Liability>}
   */
  public List<Liability> getLiabilityList() throws SQLException {
    return this.queryForAll();
  }

  /**
   * Добавить обязательство
   * @param liability обязательство
   * @return {@link Liability}
   */
  public Liability createLiability(Liability liability) throws SQLException {
    this.create(liability);
    return liability;
  }

  /**
   * Удалить обязательство
   * @param id идентификатор обязательства
   */
  public void deleteLiability(int id) throws SQLException {
    this.deleteById(id);
  }
}
