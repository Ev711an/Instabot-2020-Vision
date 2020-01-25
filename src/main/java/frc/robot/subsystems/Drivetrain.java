/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {

  //fields
  private WPI_TalonSRX
  leftMotor1,
  leftMotor2,
  rightMotor1,
  rightMotor2;

  /**
   * Creates a new Drivetrain.
   */
  public Drivetrain(int motor0, int motor1, int motor2, int motor3) {
    leftMotor1 = new WPI_TalonSRX(motor0);
    leftMotor2 = new WPI_TalonSRX(motor1);
    rightMotor1 = new WPI_TalonSRX(motor2);
    rightMotor2 = new WPI_TalonSRX(motor3);
  }

  public void setSpeed(double leftPower, double rightPower) {
    leftMotor1.set(leftPower);
    leftMotor2.set(leftPower);
    rightMotor1.set(-rightPower);
    rightMotor2.set(-rightPower);
  }

  public void stop() {
    setSpeed(0, 0);
    brake();
  }

  public void brake() {
    leftMotor1.setNeutralMode(NeutralMode.Brake);
    leftMotor2.setNeutralMode(NeutralMode.Brake);
    rightMotor1.setNeutralMode(NeutralMode.Brake);
    rightMotor2.setNeutralMode(NeutralMode.Brake);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Motor " + leftMotor1.getBaseID() + " current:", leftMotor1.getStatorCurrent());
    SmartDashboard.putNumber("Motor " + leftMotor2.getBaseID() + " current:", leftMotor2.getStatorCurrent());
    SmartDashboard.putNumber("Motor " + rightMotor1.getBaseID() + " current:", rightMotor1.getStatorCurrent());
    SmartDashboard.putNumber("Motor " + rightMotor2.getBaseID() + " current:", rightMotor2.getStatorCurrent());
  }
}
