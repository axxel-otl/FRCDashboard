// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.Tuning;
import frc.robot.subsystems.CANFuelSubsystem;
import static frc.robot.Tuning.*;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class Launch extends Command {
  /** Creates a new Launch. */

  CANFuelSubsystem fuelSubsystem;

  public Launch(CANFuelSubsystem fuelSystem) {
    addRequirements(fuelSystem);
    this.fuelSubsystem = fuelSystem;
  }

  @Override
  public void initialize() {
  }

  // Voltages are read from Elastic (/Tuning/Fuel) on every loop
  @Override
  public void execute() {
    fuelSubsystem.setIntakeLauncherRoller(LAUNCHING_LAUNCHER_VOLTAGE.get() * frc.robot.Tuning.LAUNCH_POWER.get());
    fuelSubsystem.setFeederRoller(LAUNCHING_FEEDER_VOLTAGE.get() * frc.robot.Tuning.INDEXER_SPEED.get());
  }

  // Called once the command ends or is interrupted. The rollers keep their last
  // value; the subsystem's default command stops them.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
