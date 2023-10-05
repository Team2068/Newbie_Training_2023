// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.commands.SwerveModule;

public class Drive extends SubsystemBase {
  /** Creates a new Drive. */
  SwerveModule module1 = new SwerveModule(1, 2, 34);
  SwerveModule module2 = new SwerveModule(3, 4, -8);
  SwerveModule module3 = new SwerveModule(5, 6, 65);
  SwerveModule module4 = new SwerveModule(7, 8, 94);
  public Drive() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

  }

  public void getAxisInput(double LeftYAxis, double RightXAxis){
    module1.move(module1.steerencoder.getAbsolutePosition()+(RightXAxis*5), LeftYAxis/2);
    module2.move(module1.steerencoder.getAbsolutePosition()+(RightXAxis*5), LeftYAxis/2);
    module3.move(module1.steerencoder.getAbsolutePosition()+(RightXAxis*5), LeftYAxis/2);
    module4.move(module1.steerencoder.getAbsolutePosition()+(RightXAxis*5), LeftYAxis/2);
  }
}
