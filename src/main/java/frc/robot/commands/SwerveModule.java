// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import com.ctre.phoenix.sensors.AbsoluteSensorRange;
import com.ctre.phoenix.sensors.CANCoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.ControlType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;


/** Add your docs here. */
public class SwerveModule {
    CANSparkMax drivemotor;
    CANSparkMax swervemotor;
    public CANCoder steerencoder;

    final double steerReduction = (14.0 / 50.0) * (27.0 / 17.0) * (15.0 / 45.0);
    public SwerveModule(int dmotorid, int smoterid, double encoderoffset){
        drivemotor = new CANSparkMax(dmotorid, MotorType.kBrushless);
        swervemotor = new CANSparkMax(smoterid, MotorType.kBrushless); 
        swervemotor.getEncoder().setPositionConversionFactor(2*Math.PI*steerReduction);    
        swervemotor.getPIDController().setP(1.0);
        swervemotor.getPIDController().setD(0.1);
        swervemotor.getPIDController().setI(0);
        swervemotor.getEncoder().setPosition(0);
        // setup swerve module encoder
        steerencoder = new CANCoder(15);
        steerencoder.configMagnetOffset(encoderoffset);
        steerencoder.configAbsoluteSensorRange(AbsoluteSensorRange.Unsigned_0_to_360);
    }

    public void resetSteerPosition() {
        swervemotor.getEncoder().setPosition(Math.toRadians(steerencoder.getAbsolutePosition()));
    }

    public void move(double setSwerveMotorPosition, double drivemotorspeed){
        resetSteerPosition();
        swervemotor.set(setSwerveMotorPosition);
        drivemotor.set(drivemotorspeed);
    }

    public void SetToZero(){
        swervemotor.getEncoder().setPosition(0);
    }

    public void rotateto(double rotation){
        swervemotor.getPIDController().setReference(Math.toRadians(rotation), ControlType.kPosition);
    }
}
