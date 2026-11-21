// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.Set;

import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Tuning;
import frc.robot.subsystems.CANFuelSubsystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class LaunchSequence extends SequentialCommandGroup {
  /** Creates a new LaunchSequence. */
  public LaunchSequence(CANFuelSubsystem fuelSubsystem) {
    addCommands(
        // withTimeout() takes its value when the command is CREATED (when the
        // button is bound at robot start). Commands.defer() builds the spin-up
        // command each time the sequence starts, so it uses the SPIN_UP_SECONDS
        // value that is in Elastic at the moment the button is pressed.
        Commands.defer(
            () -> new SpinUp(fuelSubsystem).withTimeout(Tuning.SPIN_UP_SECONDS.get()),
            Set.of(fuelSubsystem)),
        new Launch(fuelSubsystem));
  }
}
