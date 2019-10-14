  package org.firstinspires.ftc.teamcode.skystone;

import org.firstinspires.ftc.teamcode.common.RobotConfig;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Blinker;
import com.qualcomm.robotcore.hardware.Gyroscope;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;


@TeleOp(name="Tele Op", group="Linear Opmode")

public class Driving extends LinearOpMode {

    // Declare OpMode members.
    
    RobotConfig robotConfig = new RobotConfig(this);

    @Override
    public void runOpMode() throws InterruptedException {
        robotConfig.init();
        telemetry.addData("Status", "Initialized");
        telemetry.update();


        robotConfig.bringPlatform.setPosition(0);

        telemetry.addData("Status: ", "Hardware Configured");
        telemetry.update();

        robotConfig.leftDrive.setDirection(DcMotor.Direction.FORWARD);
        // rightDrive.setDirection(DcMotor.Direction.FORWARD);

        waitForStart();

        while (opModeIsActive()) {

            double leftPower;
            double rightPower;
            double armPower;
            double turnPower;
            double upPower;
            double bumpPower;
            double platPower;


            leftPower = gamepad1.left_stick_y;
            rightPower  =  gamepad1.right_stick_y;
            armPower = -gamepad2.left_stick_y;
            turnPower = -gamepad2.right_stick_x;
            bumpPower = 0;



            robotConfig.leftDrive.setPower(leftPower/2);
            robotConfig.rightDrive.setPower(rightPower/2);
            robotConfig.arm_motor.setPower(armPower/3);
            robotConfig.grabber_turn.setPosition(turnPower/2);

            if (gamepad2.right_bumper) {
                robotConfig.grabber_vert.setPosition(bumpPower+.5);
            } else if (gamepad2.left_bumper){
                robotConfig.grabber_vert.setPosition(bumpPower-.5);
            } else if (gamepad1.left_bumper){
                robotConfig.bringPlatform.setPosition(-1);
            } else if (gamepad1.right_bumper){
                robotConfig.bringPlatform.setPosition(0);
            }

        }
    }
}
