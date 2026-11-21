package frc.robot;

import frc.robot.Constants.FuelConstants;
import frc.robot.Constants.OperatorConstants;
import frc.robot.util.TunableNumber;

/**
 * Valores que se pueden ajustar en vivo desde Elastic.
 *
 * <p>
 * Cada uno arranca con el valor de Constants.java y se publica en
 * NetworkTables como /Tuning/Fuel/... o /Tuning/Drive/... . En Elastic los
 * encuentras en el árbol de NetworkTables, carpeta "Tuning", o cargando el
 * layout del robot (File > Load Layout From Robot) que trae la pestaña
 * "Tuning" ya armada.
 *
 * <p>
 * Los nombres de los topics son iguales a los de las constantes para que sea
 * fácil copiar el valor final a Constants.java.
 */
public final class Tuning {
  private Tuning() {
  }

  // Fuel (intake / feeder / launcher)
  public static final TunableNumber INTAKING_FEEDER_VOLTAGE = new TunableNumber(
      "Fuel/INTAKING_FEEDER_VOLTAGE", FuelConstants.INTAKING_FEEDER_VOLTAGE);
  public static final TunableNumber INTAKING_INTAKE_VOLTAGE = new TunableNumber(
      "Fuel/INTAKING_INTAKE_VOLTAGE", FuelConstants.INTAKING_INTAKE_VOLTAGE);
  public static final TunableNumber LAUNCHING_FEEDER_VOLTAGE = new TunableNumber(
      "Fuel/LAUNCHING_FEEDER_VOLTAGE", FuelConstants.LAUNCHING_FEEDER_VOLTAGE);
  public static final TunableNumber LAUNCHING_LAUNCHER_VOLTAGE = new TunableNumber(
      "Fuel/LAUNCHING_LAUNCHER_VOLTAGE", FuelConstants.LAUNCHING_LAUNCHER_VOLTAGE);
  public static final TunableNumber SPIN_UP_FEEDER_VOLTAGE = new TunableNumber(
      "Fuel/SPIN_UP_FEEDER_VOLTAGE", FuelConstants.SPIN_UP_FEEDER_VOLTAGE);
  public static final TunableNumber SPIN_UP_SECONDS = new TunableNumber(
      "Fuel/SPIN_UP_SECONDS", FuelConstants.SPIN_UP_SECONDS);
  public static final TunableNumber LAUNCH_POWER = new TunableNumber(
      "Fuel/LAUNCH_POWER", FuelConstants.LAUNCH_POWER);
  public static final TunableNumber INDEXER_SPEED = new TunableNumber(
      "Fuel/INDEXER_SPEED", FuelConstants.INDEXER_SPEED);

  // Drive
  public static final TunableNumber DRIVE_SCALING = new TunableNumber(
      "Drive/DRIVE_SCALING", OperatorConstants.DRIVE_SCALING);
  public static final TunableNumber ROTATION_SCALING = new TunableNumber(
      "Drive/ROTATION_SCALING", OperatorConstants.ROTATION_SCALING);
  public static final TunableNumber DRIVE_POWER = new TunableNumber(
      "Drive/DRIVE_POWER", OperatorConstants.DRIVE_POWER);

  private static final TunableNumber[] ALL = {
      INTAKING_FEEDER_VOLTAGE, INTAKING_INTAKE_VOLTAGE, LAUNCHING_FEEDER_VOLTAGE,
      LAUNCHING_LAUNCHER_VOLTAGE, SPIN_UP_FEEDER_VOLTAGE, SPIN_UP_SECONDS,
      DRIVE_SCALING, ROTATION_SCALING, DRIVE_POWER, LAUNCH_POWER, INDEXER_SPEED };

  /**
   * Fuerza a Java a crear (y publicar) todos los valores al arrancar el robot.
   * Sin esta llamada aparecerían en Elastic hasta que algún comando los usara.
   */
  public static void init() {
  }

  /** Regresa todos los valores a los de Constants.java. */
  public static void resetAll() {
    for (TunableNumber n : ALL) {
      n.reset();
    }
  }
}
