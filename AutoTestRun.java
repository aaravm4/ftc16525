/**
 * This program is created by Aarav M and Avi A
 * For the 2019 FTC Challenge
 * The Team it was created for was Skyrise Team 15625
 * Beginners are welcome to use this code
 * To get bearings on BASIC Onbot Java
 */

/* Modified from FTC Sample Packages */
package org.firstinspires.ftc.robotcontroller.external.samples;

/* Importing necessary libs */
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
/* Specifying this an Autonomous program */
@Autonomous
/* Running the function AutoTestRun */
public class AutoTestRun extends LinearOpMode {
    /*Setting all motors to null*/
    private DcMotor leftDrive = null;
    private DcMotor rightDrive = null;

    @Override
    public void runOpMode () throws InterruptedException {
        /*Cofirming that the OpMode is running*/
        telemetry.addData("Status: ", "Initialized");
        telemetry.update();
        /*setting up connections to DcMotors*/
        leftDrive = hardwareMap.get(DcMotor.class, "leftDrive");
        rightDrive = hardwareMap.get(DcMotor.class, "rightDrive");
        /*Waiting For Start*/
        waitForStart();

        while (opModeIsActive()) {
            /* Letting Driver Know Robot is Moving Forward */
            telemetry.addData("Status: ", "Moving Forward");
            telemetry.update();
            /* Setting Respective Powers to Move Forward */
            leftDrive.setPower(0.25);
            rightDrive.setPower(0.25);
            /* Running for 3 seconds */
            sleep(1000);
            /* Letting Driver Know Robot is Moving Backward */
            telemetry.addData("Status: ", "Moving Backwards");
            telemetry.update();
            /* Setting Respective Powers to Move Backwards */
            leftDrive.setPower(-0.25);
            rightDrive.setPower(-0.25);
            /* Running for 3 seconds */
            sleep(1000);
            /* Letting Driver Know Robot is Rotating Right */
            telemetry.addData("Status: ", "Rotating Right");
            telemetry,update();
            /* Setting Respective Powers to Rotate Right */
            leftDrive.setPower(0.25);
            rightDrive.setPower(-0.25);
            /* Running to make 360 degrees */
            sleep(1000);
            /* Letting Driver Know Robot is Rotating Left */
            telemetry.addData("Status: ", "Rotating Left");
            telemetry.update();
            /* Setting Respective Powers to Rotate Left */
            leftDrive.setPower(-0.25);
            rightDrive.setPower(0.25);
            /* Running to make 360 degrees */
            sleep(1000);
            /* Letting Driver Know Program is Finished */
            telemetry.addData("Status: ", "Program Executed");
            telemetry.update();
            /* Being idle because program is finished (waiting for more instructions) */
            idle();
        }

    }
}
