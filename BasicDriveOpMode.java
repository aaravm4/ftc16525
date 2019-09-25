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
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;


@TeleOp(name="Drive Controlled", group="Linear Opmode")

public class BasicDriveOpMode extends LinearOpMode throws InterruptedException {

    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor leftDrive = null;
    private DcMotor rightDrive = null;
    private DcMotor arm_motor = null;
    // private Servo bringPlatform = null;

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        leftDrive  = hardwareMap.get(DcMotor.class, "leftDrive");
        rightDrive = hardwareMap.get(DcMotor.class, "rightDrive");
        arm_motor = hardwareMap.get(DcMotor.class, "arm_motor")
        bringPlatform = hardwareMap.get(Servo.class, "bringPlat")
            
            
        telemetry.addData("Status: ", "Hardware Configured");
        telemetry.update();
        
        // leftDrive.setDirection(DcMotor.Direction.FORWARD);
        // rightDrive.setDirection(DcMotor.Direction.FORWARD);
        
        waitForStart();
        runtime.reset();

        while (opModeIsActive()) {

            double leftPower;
            double rightPower;
            double armPower

            leftPower = -gamepad1.left_stick_y;
            rightPower  =  -gamepad1.right_stick_y;
            armPower = -gamepad2.left_stick_y;
            
            leftDrive.setPower(leftPower/2);
            rightDrive.setPower(rightPower/2);
            arm_motor.setPosition(armPower/2);
            
            // if (gamepad1.left_bumper) {
            // 		bringPlatform.setPosition(1);
          	// }
          	// else if (gamepad1.right_bumper) {
            //		bringPlatform.setPosition(0);
          	// }

            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.addData("Left Motor: ", leftPower.toString());
            telemetry.addData("Right Motor: ", rightPower.toString());
            telemetry.addData("Arm Motor: ", armPower.toString());
            telemetry.update();
        }
    }
}
