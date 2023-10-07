// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj.util.Color;

public class Led extends SubsystemBase {
  AddressableLED m_led;
  AddressableLEDBuffer m_ledBuffer;

  /** Creates a new Led. */
  public Led() {
    m_led = new AddressableLED(9);
    m_ledBuffer = new AddressableLEDBuffer(60);
    m_led.setLength(m_ledBuffer.getLength());

    setColor(0, 0, 255);

    m_led.setData(m_ledBuffer);
    m_led.start();
  }

  public void setColor(int red, int green, int blue){
    for (var i = 0; i < m_ledBuffer.getLength(); i++) {
      // Sets the specified LED to the RGB values for red
      m_ledBuffer.setRGB(i, red, green, blue);
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
