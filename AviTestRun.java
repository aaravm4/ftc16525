package org.firstinspires.ftc.robotcontroller.external.samples;

/* Importing necessary libs */
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
/* Specifying this an Autonomous program */

@Autonomous(name='Avi Test' group='Linear OpMode')


public class AviTest extends LinearOpMode {
	DcMotor leftDrive = null;
  DcMotor rightDrive  = null;
  	public void runOpMode () throws InterruptedException {
 		 	  leftDrive = hardwareMap.get(DcMotor.class, "leftDrive");
 	   	  rightDrive = hardwareMap.get(DcMotor.class, "rightDrive");
			  
      
        while (opModeIsActive()) {
      	      leftDrive.setPower(0.25);
  	          rightDrive.setPower(-0.25);
  					  sleep(1000);
        }
	
    }
}
