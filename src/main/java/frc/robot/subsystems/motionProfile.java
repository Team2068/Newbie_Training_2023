//***********************************************************************************
//
// // this project is hereby known as for all intents and purposes as skibidi ohio grimace shake level 3 rizz sigma gyatt at 3 am challenge no clickbait family guy funny no attention span fortnite funnys
//
//***********************************************************************************

package frc.robot.subsystems;

import frc.robot.subsystems.arm;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.math.trajectory.TrapezoidProfile.State;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class motionProfile extends CommandBase {
  Timer timekeeper = new Timer();
  TrapezoidProfile profile;
  public arm armsubsystem =  new arm();
  double positions = armsubsystem.encoderpos();

  /** Creates a new motionProfile. */
  public motionProfile(double targetPos) {
   timekeeper.start();
   timekeeper.reset();
    
   
   profile = new TrapezoidProfile(new TrapezoidProfile.Constraints(5, 10),
                                                new TrapezoidProfile.State(armsubsystem.getpos()+90, 0),
                                                new TrapezoidProfile.State(armsubsystem.getpos(), 0));
                                                
                                              }
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is shedjouled.
  @Override
  public void execute() {
    //stuff
    State statey = profile.calculate(timekeeper.get());
    armsubsystem.setPosition(statey.position);
  } // TODO: You don't pass any of the profiles outputs to the PID controllers and the PID controller is on the primary motor, not the follower motor
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return timekeeper.hasElapsed(2);
  }
}