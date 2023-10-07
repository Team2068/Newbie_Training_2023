// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.commands.SwerveModule;

public class Drive extends SubsystemBase {
  /** Creates a new Drive. */
  SwerveModule module1 = new SwerveModule(1, 2, 34); // TODO put in actual numbers
  SwerveModule module2 = new SwerveModule(3, 4, -8);// TODO put in actual numbers
  SwerveModule module3 = new SwerveModule(5, 6, 65); // TODO put in actual numbers
  SwerveModule module4 = new SwerveModule(7, 8, 94); // TODO put in actual numbers

  public SwerveDriveKinematics kinematics = new SwerveDriveKinematics(new Translation2d(4, 4)); // TODO put in actual numbers
  public Drive() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

  }

  public void getAxisInputWithKinnematics(double LeftYAxis, double LeftXAxis, double RightXAxis) {
    SwerveModuleState[] arr = kinematics.toSwerveModuleStates(new ChassisSpeeds(LeftXAxis, LeftYAxis, RightXAxis));
    
    kinematics.desaturateWheelSpeeds(arr, .2);
    
    module1.move(arr[0].speedMetersPerSecond, arr[0].angle.getDegrees());
    module1.move(arr[1].speedMetersPerSecond, arr[1].angle.getDegrees());
    module1.move(arr[2].speedMetersPerSecond, arr[2].angle.getDegrees());
    module1.move(arr[3].speedMetersPerSecond, arr[3].angle.getDegrees());

  }

  public void getAxisInput(double LeftYAxis, double RightXAxis){
    module1.move(module1.steerencoder.getAbsolutePosition()+(RightXAxis*5), LeftYAxis/2);
    module2.move(module1.steerencoder.getAbsolutePosition()+(RightXAxis*5), LeftYAxis/2);
    module3.move(module1.steerencoder.getAbsolutePosition()+(RightXAxis*5), LeftYAxis/2);
    module4.move(module1.steerencoder.getAbsolutePosition()+(RightXAxis*5), LeftYAxis/2);
  }
}
