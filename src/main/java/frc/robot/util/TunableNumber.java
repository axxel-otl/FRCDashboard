package frc.robot.util;

import java.util.function.DoubleSupplier;

import edu.wpi.first.networktables.DoubleEntry;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;

/**
 * Un número que se publica en NetworkTables bajo la tabla "/Tuning" y que se
 * puede modificar desde Elastic mientras el robot está encendido.
 *
 * <p>
 * Elastic no necesita ninguna librería especial: lee y escribe directamente
 * los topics de NetworkTables 4. El robot publica el valor por defecto (el que
 * está en Constants.java) y después lee lo que el dashboard escriba en el
 * mismo topic.
 *
 * <p>
 * Los valores NO se guardan en el roboRIO. Al reiniciar el código vuelven a
 * los de Constants.java. Cuando encuentres un buen valor, cópialo a
 * Constants.java.
 */
public class TunableNumber implements DoubleSupplier {
  private static final NetworkTable TABLE = NetworkTableInstance.getDefault().getTable("Tuning");

  private final double defaultValue;
  private final DoubleEntry entry;

  /**
   * @param key          nombre del topic dentro de /Tuning (puede llevar
   *                     subcarpetas, por ejemplo "Fuel/INTAKING_FEEDER_VOLTAGE")
   * @param defaultValue valor inicial, normalmente la constante de
   *                     Constants.java
   */
  public TunableNumber(String key, double defaultValue) {
    this.defaultValue = defaultValue;
    // getEntry crea un publicador y un suscriptor sobre el mismo topic
    entry = TABLE.getDoubleTopic(key).getEntry(defaultValue);
    // Publica el valor por defecto para que aparezca en Elastic al arrancar
    entry.set(defaultValue);
  }

  /** Valor actual (el último que escribió Elastic, o el de Constants.java). */
  public double get() {
    return entry.get(defaultValue);
  }

  /** Regresa el valor al de Constants.java. */
  public void reset() {
    entry.set(defaultValue);
  }

  public double getDefault() {
    return defaultValue;
  }

  @Override
  public double getAsDouble() {
    return get();
  }
}
