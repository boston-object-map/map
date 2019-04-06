package Model;

import java.util.ArrayList;
import java.util.List;

import GeoObjects.IGeoObject;

public class DataTranslator implements IDataTranslator {
  @Override
  public List<IGeoObject> getObjectsInView(double upperLeft, double upperRight, double lowerLeft, double lowerRight) {
    return null;
  }

  @Override
  public List<IGeoObject> getObjectsOfType(String type) {
    //Execute a query
    //Build a list of objects from Resultset
    return new ArrayList<>();
  }
}
