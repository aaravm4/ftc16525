
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name="Auto Left", group="Linear Opmode")

public class AutoLeft extends LinearOpMode {
  private DcMotor flDrive = null;
  private DcMotor frDrive = null;
  private DcMotor blDrive = null;
  private DcMotor brDrive = null;
  private Servo platserv = null;
  
  @Override
  public void runOpMode() throws InterruptedException {
    
    flDrive = hardwareMap.get(DcMotor.class, "frontleftDrive");
    frDrive = hardwareMap.get(DcMotor.class, "frontrightDrive");
    blDrive = hardwareMap.get(DcMotor.class, "backleftDrive");
    brDrive = hardwareMap.get(DcMotor.class, "backrightDrive");
    platserv = hardwareMap.get(Servo.class, "bringPlatform");
  
    blDrive.setDirection(DcMotor.Direction.REVERSE);
    waitForStart();
    
    if (opModeIsActive()) {
      // Going Forward to the Platform
      flDrive.setPower(-0.3);
      frDrive.setPower(-0.3);
      blDrive.setPower(-0.3);
      brDrive.setPower(-0.3);
      sleep(1530);
      // Delaying to make it smooth
      flDrive.setPower(0);
      frDrive.setPower(0);
      blDrive.setPower(0);
      brDrive.setPower(0);
      sleep(1000);
      // Strafing Left
      flDrive.setPower(-0.4);
      frDrive.setPower(0.4);
      blDrive.setPower(0.4);
      brDrive.setPower(-0.4);
      sleep(1150);
      // Grabbing Platform
      platserv.setPosition(0.2);
      // Delaying to make it smooth
      flDrive.setPower(0);
      frDrive.setPower(0);
      blDrive.setPower(0);
      brDrive.setPower(0);
      sleep(1000);
      // Going Back
      flDrive.setPower(0.5);
      frDrive.setPower(0.5);
      blDrive.setPower(0.5);
      brDrive.setPower(0.5);
      sleep(1550);
      // Delaying to make it smooth
      flDrive.setPower(0);
      frDrive.setPower(0);
      blDrive.setPower(0);
      brDrive.setPower(0);
      sleep(1000);
      platserv.setPosition(0.8);
      // Strafing Right to Park
      flDrive.setPower(0.3);
      frDrive.setPower(-(0.48));
      blDrive.setPower(-(0.4));
      brDrive.setPower(0.3); 
      sleep(6000);
      // Delaying to make it smooth
    
    }
  }
  
}
