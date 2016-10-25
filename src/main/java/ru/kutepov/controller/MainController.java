package ru.kutepov.controller;

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

  @RequestMapping(value = "/asset/type/list", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
  public @ResponseBody List<AssetType> getAssetTypeList() throws SQLException {
    return assetTypeDAO.getAssetTypeList();
  }

  @RequestMapping(value = "/asset/list", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
  public @ResponseBody List<Asset> getAssetList() throws SQLException {
    return assetDAO.getAssetList();
  }

  @RequestMapping(value = "/asset/add", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
  public @ResponseBody Asset addAsset(@RequestBody Asset asset) throws SQLException {
    return assetDAO.createAsset(asset);
  }

  @RequestMapping(value = "/liability/type/list", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
  public @ResponseBody List<LiabilityType> getLiabilityTypeList() throws SQLException {
    return liabilityTypeDAO.getLiabilityTypeList();
  }

  @RequestMapping(value = "/liability/list", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
  public @ResponseBody List<Liability> getLiabilityList() throws SQLException {
    return liabilityDAO.getLiabilityList();
  }

  @RequestMapping(value = "/liability/add", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
  public @ResponseBody Liability addLiability(@RequestBody Liability liability) throws SQLException {
    return liabilityDAO.createLiability(liability);
  }

}