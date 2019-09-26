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
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;
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
@TeleOp(name="Everything", group="Linear Opmode")

public class Everything extends LinearOpMode {
  
      // to move the small arm left and right
      private Servo grabber_turn = null;
      // The collecter for the small arm
      private Servo grabber_vertical = null;
      // To move the arm up and down
      private DcMotor arm_motor = null;
      // Front Servo that grabs the platform
      private Servo bringPlat = null;
      // Left and right wheels
      private DcMotor leftDrive = null;
      private DcMotor rightDrive = null;
    
    @Override
    public void runOpMode() {
       /*
       
      _    _               _                           _____             __ _       
     | |  | |             | |                         / ____|           / _(_)      
     | |__| | __ _ _ __ __| |_      ____ _ _ __ ___  | |     ___  _ __ | |_ _  __ _ 
     |  __  |/ _` | '__/ _` \ \ /\ / / _` | '__/ _ \ | |    / _ \| '_ \|  _| |/ _` |
     | |  | | (_| | | | (_| |\ V  V / (_| | | |  __/ | |___| (_) | | | | | | | (_| |
     |_|  |_|\__,_|_|  \__,_| \_/\_/ \__,_|_|  \___|  \_____\___/|_| |_|_| |_|\__, |
                                           __/ |
                                          |___/ 
    */

          // Left and right wheels
          leftDrive  = hardwareMap.get(DcMotor.class, "leftDrive");
        rightDrive = hardwareMap.get(DcMotor.class, "rightDrive");
          // to move the small arm left and right
          grabber_turn = hardwareMap.get(Servo.class, "grabber_turn");
          // The collecter for the small arm
          grabber_vertical = hardwareMap.get(Servo.class, "grabber_vert");
          // To move the arm up and down
          arm_motor = hardwareMap.get(DcMotor.class, "arm_motor");
          // Front Servo that grabs the platfor
          
       
          waitForStart();
          while (opModeIsActive()) {
                  
            /*         
               _____                      _____          _   ___  
              / ____|                    |  __ \        | | |__ \ 
             | |  __  __ _ _ __ ___   ___| |__) |_ _  __| |    ) |
             | | |_ |/ _` | '_ ` _ \ / _ \  ___/ _` |/ _` |   / / 
             | |__| | (_| | | | | | |  __/ |  | (_| | (_| |  / /_ 
              \_____|\__,_|_| |_| |_|\___|_|   \__,_|\__,_| |____|
              
                             ARM MOVEMENT
            */                                                     
                                                      
            
              // Move arm left and right
              grabber_turn.setPosition(-gamepad2.left_stick_x);
              // Move arm collecter up and down
              grabber_vertical.setPosition(gamepad2.right_stick_y);
              // Move the whole arm up and down
              arm_motor.setPower(-gamepad2.left_stick_y/2);
              
              
          
          
          
          
              /*
             _____                      _____          _   __ 
            / ____|                    |  __ \        | | /_ |
           | |  __  __ _ _ __ ___   ___| |__) |_ _  __| |  | |
           | | |_ |/ _` | '_ ` _ \ / _ \  ___/ _` |/ _` |  | |
           | |__| | (_| | | | | | |  __/ |  | (_| | (_| |  | |
            \_____|\__,_|_| |_| |_|\___|_|   \__,_|\__,_|  |_|
            ROBOT MOVEMENT
            */
              
              double leftPower;
            double rightPower;
          
              leftPower = -gamepad1.left_stick_y;
            rightPower  =  -gamepad1.right_stick_y;
              
              leftDrive.setPower(leftPower/2);
            rightDrive.setPower(rightPower/2);
                                                     
        }
    }
}
