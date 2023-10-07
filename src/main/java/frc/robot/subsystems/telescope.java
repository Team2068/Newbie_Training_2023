// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.ControlType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class telescope extends SubsystemBase {
  public CANSparkMax telescopeMotor;

  /** Creates a new telescope. */
  public telescope() {
    telescopeMotor = new CANSparkMax(0, MotorType.kBrushless);
    telescopeMotor.getPIDController().setP(0.3);
    telescopeMotor.getPIDController().setI(0);
    telescopeMotor.getPIDController().setD(0);
    telescopeMotor.getEncoder().setPosition(0);
  }

  public void SetPosition(double position){
    telescopeMotor.getPIDController().setReference(position, ControlType.kPosition);
  }

  @Override
  public void periodic() {
    
  }
}
