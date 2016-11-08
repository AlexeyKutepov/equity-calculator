package ru.kutepov.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.kutepov.db.dao.AssetDAO;
import ru.kutepov.db.dao.AssetTypeDAO;
import ru.kutepov.db.dao.LiabilityDAO;
import ru.kutepov.db.dao.LiabilityTypeDAO;
import ru.kutepov.db.entity.Asset;
import ru.kutepov.db.entity.AssetType;
import ru.kutepov.db.entity.Liability;
import ru.kutepov.db.entity.LiabilityType;

import javax.inject.Inject;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/")
public class MainController {

  @Inject
  private AssetTypeDAO assetTypeDAO;

  @Inject
  private AssetDAO assetDAO;

  @Inject
  private LiabilityTypeDAO liabilityTypeDAO;

  @Inject
  private LiabilityDAO liabilityDAO;

  /**
   * Классификатор категорий активов
   * @return {@link List<AssetType>}
   */
  @RequestMapping(value = "/asset/type/list", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
  public @ResponseBody List<AssetType> getAssetTypeList() throws SQLException {
    return assetTypeDAO.queryForAll();
  }

  /**
   * Список активов
   * @return {@link List<Asset>}
   */
  @RequestMapping(value = "/asset/list", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
  public @ResponseBody List<Asset> getAssetList() throws SQLException {
    return assetDAO.queryForAll();
  }

  /**
   * Добавить актив
   * @param asset актив
   * @return {@link Asset}
   */
  @RequestMapping(value = "/asset/add", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
  public @ResponseBody Asset addAsset(@RequestBody Asset asset) throws SQLException {
    assetDAO.create(asset);
    return asset;
  }

  /**
   * Удалить актив
   * @param id идентификатор актива
   */
  @RequestMapping(value = "/asset/{id}", method = RequestMethod.DELETE)
  @ResponseStatus(value = HttpStatus.OK)
  public void deleteAsset(@PathVariable int id) throws SQLException {
    assetDAO.deleteById(id);
  }

  /**
   * Классификатор категорий обязательств
   * @return {@link List<LiabilityType>}
   */
  @RequestMapping(value = "/liability/type/list", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
  public @ResponseBody List<LiabilityType> getLiabilityTypeList() throws SQLException {
    return liabilityTypeDAO.queryForAll();
  }

  /**
   * Список обязательств
   * @return {@link List<Liability>}
   */
  @RequestMapping(value = "/liability/list", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
  public @ResponseBody List<Liability> getLiabilityList() throws SQLException {
    return liabilityDAO.queryForAll();
  }

  /**
   * Добавить обязательство
   * @param liability обязательство
   * @return {@link Liability}
   */
  @RequestMapping(value = "/liability/add", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
  public @ResponseBody Liability addLiability(@RequestBody Liability liability) throws SQLException {
    liabilityDAO.create(liability);
    return liability;
  }

  /**
   * Удалить обязательство
   * @param id идентификатор обязательства
   */
  @RequestMapping(value = "/liability/{id}", method = RequestMethod.DELETE)
  @ResponseStatus(value = HttpStatus.OK)
  public void deleteLiability(@PathVariable int id) throws SQLException {
    liabilityDAO.deleteById(id);
  }

}