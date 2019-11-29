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
package org.firstinspires.ftc.teamcode.skystone;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.Hardware;
import com.qualcomm.robotcore.hardware.Blinker;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareDevice;
import com.qualcomm.robotcore.hardware.Gyroscope;
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
@TeleOp(name = "Mecanum Drive", group = "Linear Opmode")

public class MecanumDrive extends LinearOpMode {
	// Declaring Variables
	private double forback;
	private double rightleft;
	private double turnPower;
	private DcMotor frontleftDrive = null;
	private DcMotor frontrightDrive = null;
	private DcMotor backleftDrive = null;
	private DcMotor backrightDrive = null;

	@Override
	public void runOpMode() throws InterruptedException {

		frontleftDrive = hardwareMap.get(DcMotor.class, "frontleftDrive");
		backrightDrive = hardwareMap.get(DcMotor.class, "backrightDrive");
		backleftDrive = hardwareMap.get(DcMotor.class, "backleftDrive");
		frontrightDrive = hardwareMap.get(DcMotor.class, "frontrightDrive");

		telemetry.addData("Status: ", "Hardware Configured");
		telemetry.update();

		frontleftDrive.setDirection(DcMotor.Direction.REVERSE);
		frontrightDrive.setDirection(DcMotor.Direction.REVERSE);
		waitForStart();

		// Back Left Motor is 312 RPM
		// Back Right Motor is 435 RPM
		// This is why we multiply by 233/312, 233/435 to imitate a 233 rpm motor
		while (opModeIsActive()) {
			// Only 3 Main Gamepad Inputs
			forback = -gamepad1.left_stick_y;
			rightleft = gamepad1.left_stick_x;
			turnPower = gamepad1.right_stick_x;

			// For Going Forward and Backward
			frontleftDrive.setPower( - (forback));
			frontrightDrive.setPower(forback);
			backleftDrive.setPower(forback);
			backrightDrive.setPower(forback);

			// Strafing Right
			if (rightleft > 0) {
				
			}
			// For when Going Left
			if (rightleft < 0) {
				
			}

			// Twisting Right
			if (turnPower > 0) {
				
			}
			// Twisting Left
			if (turnPower < 0) {
				
			}

		}
	}
}
