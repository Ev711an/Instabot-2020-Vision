/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ControlPanelSpindle extends SubsystemBase {

  private WPI_TalonSRX spindle; 

  /**
   * Creates a new ControlPanelSpindle.
   */
  public ControlPanelSpindle(int motor2) {
    spindle = new WPI_TalonSRX(motor2);
  }
 
  public void spin(double power) {
    spindle.set(power);
  }
  public void stop() {
    spindle.set(0);
  }
  public double get() {
   double pos = spindle.getSelectedSensorPosition();
   return pos;
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run

  }
}
