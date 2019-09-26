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
      	// Front Servo that grabs the platform
      	bringPlatform = hardwareMap.get(Servo.class, "bringPlat")
      	
          telemetry.addData("Status": "Hardware Configured");
        telemetry.update();

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
          	grabber_vertical.setPosition(-gamepad2.right_stick_y);
          	// Move the whole arm up and down
          	arm_motor.setPower(-gamepad2.left_stick_y;);
          	
          	telemetry.addData("Arm Turning:", -gamepad2.left_stick_x.toString());
          	telemetry.addData("Arm Collector Up And Down:", -gamepad2.right_stick_y.toString());
          
          
          
          
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
