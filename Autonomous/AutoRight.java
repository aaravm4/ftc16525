/*
Copyright 2019 FIRST Tech Challenge Team 16525

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
associated documentation files (the "Software"), to deal in the Software without restriction,
including without limitation the rights to use, copy, modify, merge, publish, distribute,
sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial
portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * This file contains an minimal example of a Linear "OpMode". An OpMode is a 'program' that runs in either
 * the autonomous or the teleop period of an FTC match. The names of OpModes appear on the menu
 * of the FTC Driver Station. When an selection is made from the menu, the corresponding OpMode
 * class is instantiated on the Robot Controller and executed.
 *
 * This particular OpMode just executes a basic Tank Drive Teleop for a PushBot
 * It includes all the skeletal structure that all linear OpModes contain.
 *
 * Remove a @Disabled the on the next line or two (if present) to add this opmode to the Driver Station OpMode list,
 * or add a @Disabled annotation to prevent this OpMode from being added to the Driver Station
 */
@Autonomous(name="Auto Right", group="Linear Opmode")

public class AutoRight extends LinearOpMode {
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
      sleep(1460);
      // Delaying to make it smooth
      flDrive.setPower(0);
      frDrive.setPower(0);
      blDrive.setPower(0);
      brDrive.setPower(0);
      sleep(1000);
      flDrive.setPower(0.3);
      frDrive.setPower(-0.4);
      blDrive.setPower(-0.4);
      brDrive.setPower(0.3); 
      sleep(3200);
      flDrive.setPower(-0.3);
      frDrive.setPower(-0.3);
      blDrive.setPower(-0.3);
      brDrive.setPower(-0.3);
      sleep(800);
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
      sleep(1600);
      // Delaying to make it smooth
      flDrive.setPower(0);
      frDrive.setPower(0);
      blDrive.setPower(0);
      brDrive.setPower(0);
      sleep(1000);
      platserv.setPosition(0.8);
      // Strafing Right to Park
      flDrive.setPower(-0.3);
      frDrive.setPower((0.4));
      blDrive.setPower((0.4));
      brDrive.setPower(-0.3); 
      sleep(5500);
      
    }
  }
  
}
