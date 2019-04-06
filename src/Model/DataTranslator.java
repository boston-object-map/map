package Model;

import java.sql.SQLException;
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
import database.DBUtils;

public class DataTranslator implements IDataTranslator {

  private DBUtils dbu;

  /**
   * Construct a new DataTranslator.
   */
  public DataTranslator() {
    this.dbu = new DBUtils();
    dbu.getConnection();
  }

  public static void main(String[] args) throws SQLException {
    DataTranslator dt = new DataTranslator();
    for(IGeoObject igo : dt.getObjectsOfType("tree")) {
      System.out.println(igo.getInformation());
    }
  }

  @Override
  public List<IGeoObject> getObjectsInView(double upperLeft, double upperRight, double lowerLeft, double lowerRight) {
    return null;
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
      //TODO
      j.printStackTrace();
      throw new IllegalArgumentException("SQL error");
    }
  }
}
