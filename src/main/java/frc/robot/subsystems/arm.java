// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.AlternateEncoderType;
import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkMaxAlternateEncoder;
import com.revrobotics.CANSparkMax.ControlType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DutyCycleEncoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class arm extends SubsystemBase {
  public DutyCycleEncoder armEnconder;
  public CANSparkMax armMotor1;
  public CANSparkMax armMotor2;


  /** Creates a new arm. */
  public arm() {
    armEnconder = new DutyCycleEncoder(0);
    armEnconder.setDutyCycleRange(0, 1);
    armMotor1 = new CANSparkMax(5, MotorType.kBrushless);
    armMotor2 = new CANSparkMax(6, MotorType.kBrushless);
    armEnconder.reset();

    armEnconder.setPositionOffset(0);

    armMotor2.follow(armMotor1, true);
    armMotor1.getPIDController().setP(0);
    armMotor1.getPIDController().setI(0);
    armMotor1.getPIDController().setD(0);
    armMotor1.getAlternateEncoder(SparkMaxAlternateEncoder.Type.kQuadrature, 8192);
    armMotor1.getEncoder().setPositionConversionFactor(360); 
  }

  public void resetEncoder(){
    armEnconder.reset();
  }


  public Double getpos(){
    return (armMotor1.getEncoder().getPosition()) % 360;
  }

  public void moveTo(int position){
    
  }
  public double encoderpos() {
    return armEnconder.getAbsolutePosition();
  }

  

  public void setVoltage(double voltage) {
    armMotor1.setVoltage(voltage);
    armMotor1.setVoltage(-voltage);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setPosition(double position) {
    armMotor1.getPIDController().setReference(position,ControlType.kPosition);
  }
}