package org.firstinspires.ftc.teamcode.skystone;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name="Tele Op", group="Linear Opmode")

public class Driving extends LinearOpMode {

    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    RobotConfig robotConfig = new RobotConfig(this);

    @Override
    public void runOpMode() throws InterruptedException {
        robotConfig.init();
        telemetry.addData("Status", "Initialized");
        telemetry.update();


        bringPlatform.setPosition(0);

        telemetry.addData("Status: ", "Hardware Configured");
        telemetry.update();

        // leftDrive.setDirection(DcMotor.Direction.FORWARD);
        // rightDrive.setDirection(DcMotor.Direction.FORWARD);

        waitForStart();
        runtime.reset();

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



            this.leftDrive.setPower(leftPower/2);
            this.rightDrive.setPower(rightPower/2);
            this.arm_motor.setPower(armPower/3);
            this.grabber_turn.setPosition(turnPower/2);

            if (gamepad2.right_bumper) {
                grabber_vert.setPosition(bumpPower+.1);
            } else if (gamepad2.left_bumper){
                grabber_vert.setPosition(bumpPower-.5);
            } else if (gamepad1.left_bumper){
                bringPlatform.setPosition(-1);
            } else if (gamepad1.right_bumper){
                bringPlatform.setPosition(0);
            }

        }
    }
}
