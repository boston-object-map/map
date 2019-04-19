package Run;

import Model.DataTranslator;
import Model.IDataTranslator;
import View.AnimationPanel;
import View.MapView;

/**
 * Entry point for our program.
 */
public class BostonMap {
  private AnimationPanel ap;
  private MapView mp;
  private IDataTranslator dt;

  public BostonMap() {

  }

  public static void main(String[] args) {
    IDataTranslator dt = new DataTranslator();
    MapView mv = new MapView(dt);
    mv.render();
  }
}
