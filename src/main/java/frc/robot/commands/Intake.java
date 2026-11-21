// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.CANFuelSubsystem;
import static frc.robot.Tuning.*;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class Intake extends Command {
  /** Creates a new Intake. */

  CANFuelSubsystem fuelSubsystem;

  public Intake(CANFuelSubsystem fuelSystem) {
    addRequirements(fuelSystem);
    this.fuelSubsystem = fuelSystem;
  }

  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled. The
  // voltages are read from Elastic (/Tuning/Fuel) on every loop, so a change on
  // the dashboard takes effect immediately, even while the button is held.
  @Override
  public void execute() {
    fuelSubsystem.setIntakeLauncherRoller(INTAKING_INTAKE_VOLTAGE.get());
    fuelSubsystem.setFeederRoller(INTAKING_FEEDER_VOLTAGE.get());
  }

  // Called once the command ends or is interrupted. Stop the rollers
  @Override
  public void end(boolean interrupted) {
    fuelSubsystem.setIntakeLauncherRoller(0);
    fuelSubsystem.setFeederRoller(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
