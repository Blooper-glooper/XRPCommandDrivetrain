// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.xrp.XRPMotor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
  /** Creates a new Drivetrain. */

  private final XRPMotor leftMotor;
  private final XRPMotor rightMotor;

  private final DifferentialDrive drivetrain;

  public Drivetrain() {

    leftMotor = new XRPMotor(0); 
    rightMotor = new XRPMotor(1);

    drivetrain = new DifferentialDrive(leftMotor, rightMotor);
    rightMotor.setInverted(true);
  }

  public void drive(double xSpeed, double zSpeed) {
    drivetrain.arcadeDrive(xSpeed, zSpeed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
