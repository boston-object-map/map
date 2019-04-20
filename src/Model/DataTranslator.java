package Model;

import java.util.ArrayList;
import java.util.List;

import GeoObjects.ChargingStation;
import GeoObjects.College;
import GeoObjects.FireHydrant;
import GeoObjects.IGeoObject;
import GeoObjects.ParkingMeter;
import GeoObjects.PublicLibrary;
import GeoObjects.Streetlight;
import GeoObjects.TotSpray;
import GeoObjects.TrafficSignal;
import GeoObjects.Tree;
import Database.DBUtils;

public class DataTranslator implements IDataTranslator {

  private DBUtils dbu;

  /**
   * Construct a new DataTranslator.
   */
  public DataTranslator() {
    this.dbu = new DBUtils();
    dbu.getConnection();
  }

  @Override
  public List<IGeoObject> getObjectsInView(double lowerX, double upperX, double lowerY, double upperY) {
    String[] objects = new String[]{"college", "chargingstation", "firehydrant",
    "parkingmeter", "publiclibrary", "streetlight", "totspray", "trafficsignal", "tree"};
    List<IGeoObject> list = new ArrayList<>();

    for (String i: objects) {
      try {
        switch (i) {
          case "college":
            list.addAll(this.dbu.getObjectsInView("X, Y, OBJECTID, Name, Address, PhoneNumbe, NumStudents13", "college", lowerX, upperX, lowerY, upperY, College::buildColleges));
            break;
          case "chargingstation":
            list.addAll(this.dbu.getObjectsInView("X, Y, OBJECTID, Station_Name, Street_Address, Station_Operator, EV_Connector_Types", "charging_station", lowerX, upperX, lowerY, upperY, ChargingStation::buildChargingStations));
            break;
          case "firehydrant":
            list.addAll(this.dbu.getObjectsInView("X, Y, OBJECTID, placement_date_time, hydrant_manuf_code, hydrant_model_code", "fire_hydrant", lowerX, upperX, lowerY, upperY, FireHydrant::buildFireHydrants));
            break;
          case "parkingmeter":
            list.addAll(this.dbu.getObjectsInView("X, Y, OBJECTID, pay_policy, park_no_pay, street, base_rate", "parking_meter", lowerX, upperX, lowerY, upperY, ParkingMeter::buildParkingMeters));
            break;
          case "publiclibrary":
            list.addAll(this.dbu.getObjectsInView("X, Y, OBJECTID, branch, st_address", "public_library", lowerX, upperX, lowerY, upperY, PublicLibrary::buildPublicLibraries));
            break;
          case "streetlight":
            list.addAll(this.dbu.getObjectsInView("X, Y, OBJECTID, type", "streetlight", lowerX, upperX, lowerY, upperY, Streetlight::buildStreetlights));
            break;
          case "totspray":
            list.addAll(this.dbu.getObjectsInView("X, Y, OBJECTID, park_name, neighborho, address_te", "tot_spray", lowerX, upperX, lowerY, upperY, TotSpray::buildTotSprays));
            break;
          case "trafficsignal":
            list.addAll(this.dbu.getObjectsInView("X, Y, OBJECTID, Location", "traffic_signal", lowerX, upperX, lowerY, upperY, TrafficSignal::buildTrafficSignals));
            break;
          case "tree":
            list.addAll(this.dbu.getObjectsInView("X, Y, OBJECTID, type", "tree", lowerX, upperX, lowerY, upperY, Tree::buildTrees));
            break;
          default:
            throw new IllegalArgumentException("No GeoObjects of type " + i);
        }
      } catch (java.sql.SQLException j) {
        j.printStackTrace();
        throw new IllegalArgumentException("SQL error");
      }
    }
    return list;
  }

  @Override
  public List<IGeoObject> getObjectsOfType(String type) throws IllegalArgumentException {
    try {
      switch (type.toLowerCase()) {
        case "college":
          return this.dbu.getObjectsInView("X, Y, OBJECTID, Name, Address, PhoneNumbe, NumStudents13", "college", -80, -60, 40, 44, College::buildColleges);
        case "chargingstation":
          return this.dbu.getObjectsInView("X, Y, OBJECTID, Station_Name, Street_Address, Station_Operator, EV_Connector_Types", "charging_station", -80, -60, 40, 44, ChargingStation::buildChargingStations);
        case "firehydrant":
          return this.dbu.getObjectsInView("X, Y, OBJECTID, placement_date_time, hydrant_manuf_code, hydrant_model_code", "fire_hydrant", -80, -60, 40, 44, FireHydrant::buildFireHydrants);
        case "parkingmeter":
          return this.dbu.getObjectsInView("X, Y, OBJECTID, pay_policy, park_no_pay, street, base_rate", "parking_meter", -80, -60, 40, 44, ParkingMeter::buildParkingMeters);
        case "publiclibrary":
          return this.dbu.getObjectsInView("X, Y, OBJECTID, branch, st_address", "public_library", -80, -60, 40, 44, PublicLibrary::buildPublicLibraries);
        case "streetlight":
          return this.dbu.getObjectsInView("X, Y, OBJECTID, type", "streetlight", -80, -60, 40, 44, Streetlight::buildStreetlights);
        case "totspray":
          return this.dbu.getObjectsInView("X, Y, OBJECTID, park_name, neighborho, address_te", "tot_spray", -80, -60, 40, 44, TotSpray::buildTotSprays);
        case "trafficsignal":
          return this.dbu.getObjectsInView("X, Y, OBJECTID, Location", "traffic_signal", -80, -60, 40, 44, TrafficSignal::buildTrafficSignals);
        case "tree":
          return this.dbu.getObjectsInView("X, Y, OBJECTID, type", "tree", -80, -60, 40, 44, Tree::buildTrees);
        default:
          throw new IllegalArgumentException("No GeoObjects of type " + type);
      }
    }
    catch (java.sql.SQLException j) {
      j.printStackTrace();
      throw new IllegalArgumentException("SQL error");
    }
  }
}
