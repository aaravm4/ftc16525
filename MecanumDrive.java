package org.firstinspires.ftc.teamcode.skystone;

import org.firstinspires.ftc.teamcode.common.RobotConfig;
import com.qualcomm.robotcore.util.Hardware;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Blinker;
import com.qualcomm.robotcore.hardware.Gyroscope;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;


/* Mecanum Wheel Drive program Basic
 * Created by Aarav M
 * NO STRAFING
 * Gamepad1 RightStick controls movement
 * The Left Stick controls turn
*/

@TeleOp(name="Tele Op", group="Linear Opmode")

public class Driving extends LinearOpMode {    
    // Declaring Variables
    private double forback;
    private double rightleft;
  
    RobotConfig robotConfig = new RobotConfig(this);
    
    @Override
    public void runOpMode() throws InterruptedException {
    
        robotConfig.init();

        telemetry.addData("Status: ", "Hardware Configured");
        telemetry.update();

        robotConfig.frontleftDrive.setDirection(DcMotor.Direction.REVERSE);
      	robotConfig.frontrightDrive.setDirection(DcMotor.Direction.REVERSE);
        waitForStart();
				
      	// Back Left Motor is 312 RPM
      	// Back Right Motor is 435 RPM
      	// This is why we multiply by 233/312, 233/435 to imitate a 233 rpm motor
      
        while (opModeIsActive()) {
            
          	forback = -gamepad1.left_stick_y;
            rightleft  =  gamepad1.left_stick_x;
          	turnPower = gamepad1.right_stick_x;
          
        		// For Going Forward
            robotConfig.frontleftDrive.setPower(forback);
            robotConfig.frontrightDrive.setPower(forback);
            robotConfig.backleftDrive.setPower(forback*233/312);
            robotConfig.backrightDrive.setPower(forback*233/435);
          
            // For Going Right
          	if (rightleft > 0) {
              robotConfig.frontleftDrive.setPower(rightleft);
            	robotConfig.frontrightDrive.setPower(-(rightleft));
            	robotConfig.backleftDrive.setPower(-(rightleft*233/312));
           	  robotConfig.backrightDrive.setPower(rightleft*233/435);
            }
          	// For when Going Left
          	if (rightLeft < 0) {
              robotConfig.frontleftDrive.setPower(-(rightleft));
              robotConfig.frontrightDrive.setPower(rightleft);
           	  robotConfig.backrightDrive.setPower(rightleft*233/435);
              robotConfig.backleftDrive.setPower(-(rightleft*233/312));
            }
          
          	// For Turning Right
          	if (turnPower > 0) {
              robotConfig.frontleftDrive.setPower(turnPower);
              robotConfig.frontrightDrive.setPower(-turnPower);
              robotConfig.backleftDrive.setPower(turnPower*233/312);
              robotConfig.backrightDrive.setPower(-1*turnPower*233/435);
            }
          // For Turning Left
          if (turnPower < 0) {
              robotConfig.frontleftDrive.setPower(-turnPower);
              robotConfig.frontrightDrive.setPower(turnPower);
              robotConfig.backleftDrive.setPower(-1*turnPower*233/312);
              robotConfig.backrightDrive.setPower(turnPower*233/435);
            }

        }
    }
}
