// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Subsystems.Drivetrain;

public class RobotContainer {

  private final Drivetrain drivetrain;
  private final CommandXboxController controller = new CommandXboxController(0);

  public RobotContainer() {
    drivetrain = new Drivetrain();
    configureBindings();
  }

  private void configureBindings() {
    drivetrain.setDefaultCommand(Commands.run(() -> drivetrain.drive(-controller.getLeftY(), -controller.getRightX()), drivetrain));

    controller.a().whileTrue(Commands.run(() -> drivetrain.drive(1, 0), drivetrain));
    // Or
    //controller.a().whileTrue(new DriveX(drivetrain, 1));

    controller.b().onTrue(Commands.sequence(
      Commands.run(() -> drivetrain.drive(1,0), drivetrain).withTimeout(2),
      Commands.run(() -> drivetrain.drive(-1,0), drivetrain).withTimeout(2)
    ));

    // Or
    // controller.b().onTrue(Commands.sequence(
    //   new DriveX(drivetrain, 1).withTimeout(2),
    //   new DriveX(drivetrain, -1).withTimeout(2)
    // ));
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
