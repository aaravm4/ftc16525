package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.Gyroscope;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name="Test Controlled", group="Linear Opmode")

public class BasicDriveOpMode extends LinearOpMode {

    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor leftDrive = null;
    private DcMotor rightDrive = null;
    private DcMotor arm_motor = null;
    private Servo grabber_turn = null;
    private Servo grabber_vert = null;
    // private Servo bringPlatform = null;

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        leftDrive  = hardwareMap.get(DcMotor.class, "leftDrive");
        rightDrive = hardwareMap.get(DcMotor.class, "rightDrive");
        arm_motor = hardwareMap.get(DcMotor.class, "arm_motor");
        grabber_turn = hardwareMap.get(Servo.class, "grabber_turn");
        grabber_vert = hardwareMap.get(Servo.class, "grabber_vert");
            
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

            leftPower = -gamepad1.left_stick_y;
            rightPower  =  -gamepad1.right_stick_y;
            armPower = -gamepad2.left_stick_y;
            turnPower = -gamepad2.right_stick_x;
            bumpPower = 0;
            

            leftDrive.setPower(leftPower/2);
            rightDrive.setPower(rightPower/2);
            arm_motor.setPower(armPower/2);
            grabber_turn.setPosition(turnPower/2);
            
            if (gamepad2.right_bumper) {
                grabber_vert.setPosition(bumpPower+.5);
            } else if (gamepad2.left_bumper){
                grabber_vert.setPosition(bumpPower-.5);
            }
            
          
        }
    }
}
