/**
 * This program is created by Aarav M and Avi A
 * For the 2019 FTC Challenge
 * The Team it was created for was Skyrise Team 15625
 * Beginners are welcome to use this code
 * To get bearings on BASIC Onbot Java
 */


package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;


@TeleOp(name="Move Board", group="Linear Opmode")

public class MoveBoard extends LinearOpMode {

		private Servo testServo = null;
  
    @Override
    public void runOpMode() {
        testServo = hardwareMap.get(Servo.class, "servo");
        telemetry.addData("Status", "Initialized");
        telemetry.update();
			
      
        waitForStart();

        while (opModeIsActive()) {

    			if (gamepad1.left_bumper.isBusy()) {
            testServo.setDirection(1);
          }
          else if (gamepad1.right_bumper.isBusy()) {
            testServo.setDirection(0);
          }

        }
    }
}
