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

package org.firstinspires.ftc.teamcode.skystone.detection;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import java.util.List;
import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.tfod.TFObjectDetector;
import org.firstinspires.ftc.robotcore.external.tfod.Recognition;

@Autonomous(name = "Stone Detection", group = "Concept")

public class StoneDetection extends LinearOpMode {
    // Declaring Labels and ObjDetect Models
    private static final String TFOD_MODEL_ASSET = "Skystone.tflite";
    private static final String LABEL_FIRST_ELEMENT = "Stone";
    private static final String LABEL_SECOND_ELEMENT = "Skystone";
    double ObjectAngle;
    double TargetHeightRatio;
    int ImageHeight;
    float ObjectHeight;
    double leftPower;
    double rightPower;
    double ObjectHeightRatio;

    //Adding Vuforia Key
    private static final String VUFORIA_KEY =
            "AZAarN7/////AAABmbwaPFXcCUKSuQXshhARVD0edTn5yksB2f5i9qUU/5VB4UkFTmki8BWBIyVGemPQFrTp5KfsGLrHy1FTZePcR9qfC3PD0IyiGJGy1Vbxp1dA4PUCvinmAPUEPZLopfxRYzyFc7uIhljkjcdiOLLzqreumEb2c4/7s1n4AgkxAxs8H6k/Mg+FCNOWqbSekb7msXG8IjgcqGrH7J16MYjvNZw8KHMShM2QDNyzfyyKVrSA4Hw1Ys6zc9yGuuC/go5IOWhFdqvwLMfEA331wfcLCPxXAXSTeOpfN+Jy7vRk8DMeoq5aooF5k3U5xXjyTxwJdzttGnmfNifw7kI8/GWvZS9U8FGjoki2QruawoJDJ3CZ";

    // Initialzing both vuforia and tfod
    private VuforiaLocalizer vuforia;
    private TFObjectDetector tfod;
    public boolean skystone_detected = false;
    

    @Override
    public void runOpMode() {
       
        initVuforia();
        TargetHeightRatio = 0.8;
        
        // Creating Tfod Instance
        if (ClassFactory.getInstance().canCreateTFObjectDetector()) {
            initTfod();
        } else {
            telemetry.addData("Sorry!", "This device is not compatible with TFOD");
        }
        
        // Activating ...
        if (tfod != null) {
            tfod.activate();
        }

        /** Wait for the game to begin */
        waitForStart();

        if (opModeIsActive()) {
            while (opModeIsActive()) {
                if (tfod != null) {
                    // getUpdatedRecognitions() will return null if no new information is available since
                    // the last time that call was made.
                    List<Recognition> recognitions = tfod.getUpdatedRecognitions();
                    if (recognitions != null) {
                      if (recognitions.size() > 0) {
                        telemetry.addData("# Object Detected", recognitions.size());
                        // step through the list of recognitions and display boundary info.
                        int i = 0;
                        for (Recognition recognition : recognitions) {
                            if (recognition.getLabel() == "Skystone") {
                                // finding if skystone is there or not
                                telemetry.addData("Skystone: ", "Detected");
                                skystone_detected = true;
                                // getting provided estimated angle
                                ObjectAngle = recognition.estimateAngleToObject(AngleUnit.DEGREES);
                                // showing user object angle
                                telemetry.addData("Estimated Angle", ObjectAngle);
                                if (ObjectAngle > 0) {
                                    telemetry.addData("Direction", "Right");
                                } else {
                                    telemetry.addData("Direction", "Left");
                                }
                                // Using params to detect how close the block is
                                ImageHeight = recognition.getImageHeight();
                                ObjectHeight = recognition.getHeight();
                                // Finding Object Height Ratio
                                // Large Ratio means that the Robot is Closer
                                ObjectHeightRatio = ObjectHeight / ImageHeight;
                                telemetry.addData("HeightRatio", ObjectHeightRatio);
                                if (ObjectHeightRatio < TargetHeightRatio - 0.05) { 
                                    telemetry.addData("Distance: ", "Not Close Enough");
                                } else if (ObjectHeightRatio > TargetHeightRatio + 0.05) {
                                    telemetry.addData("Distance: ", "Too Close");
                                } else {
                                    telemetry.addData("Distance: ", "Just Right");
                                }
                                break;
                            }
                        }
                      telemetry.update();
                      }
                    }
                }
            }
        }

        if (tfod != null) {
            tfod.shutdown();
        }
    }

    // Initializing Vuforia
    private void initVuforia() {

        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters();

        parameters.vuforiaLicenseKey = VUFORIA_KEY;
        parameters.cameraName = hardwareMap.get(WebcamName.class, "head_webcam");

        //  Instantiate the Vuforia engine
        vuforia = ClassFactory.getInstance().createVuforia(parameters);

        // Loading trackables is not necessary for the TensorFlow Object Detection engine.
    }

    // Loading Models ....
    private void initTfod() {
        int tfodMonitorViewId = hardwareMap.appContext.getResources().getIdentifier(
            "tfodMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        TFObjectDetector.Parameters tfodParameters = new TFObjectDetector.Parameters(tfodMonitorViewId);
       tfodParameters.minimumConfidence = 0.8;
       tfod = ClassFactory.getInstance().createTFObjectDetector(tfodParameters, vuforia);
       tfod.loadModelFromAsset(TFOD_MODEL_ASSET, LABEL_FIRST_ELEMENT, LABEL_SECOND_ELEMENT);
    }
}

