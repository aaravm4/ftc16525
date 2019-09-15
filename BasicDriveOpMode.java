
package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name = "BasicDriveOpMode", group = "Linear Opmode")

public class BasicDriveOpMode extends OpMode {
    private DcMotor leftDrive;
    private DcMotor rightDrive;
    public void init() {
        left = hardwareMap.dcMotor.get("leftDrive");
        right = hardwareMap.dcMotor.get("rightDrive");
    }
    public void loop() {
        right.setPower(gamepad1.right_stick_y);
        left.setPower(-gamepad1.left_stick_y);
    }
}
