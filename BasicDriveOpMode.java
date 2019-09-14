package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name="BasicDrive Op Mode", group="Linear Opmode")

public class DriveOpMode extends LinearOpMode {
    private DcMotor leftDrive;
    private DcMotor rightDrive;
    
    @Override
    public void init() {
        leftDrive = hardwareMap.get('leftMotor');
        rightDrive = hardwareMap.get('rightMotor');
        telemetry.addData("Status: ","Runnning");
        telemetry.update();
    }

    public void runOpMode() {
        while (opModeIsActive()) {
            /* check gamestick val and config */
            float left_power = -gamepad1.left_stick_y;
            float right_power = -gamepad1.right_stick_y;
            /* sets power based on gamepad */
            leftDrive.setPower(left_power);
            rightDrive.setPower(right_power);
            telemetry.addData("Left Motor Power: ", left_power);
            telemetry.addData("Right Motor Power: ", right_power);
            telemetry.update();
        }
    }

}
