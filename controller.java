package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.Gyroscope;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp

public class controller extends LinearOpMode {
    private DcMotor motorTest;

    private float currentPower = 0;
    @Override
    public void runOpMode() {
        motorTest = hardwareMap.get(DcMotor.class, "motorTest");
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        // Wait for the game to start (driver presses PLAY)
        waitForStart();


        // run until the end of the match (driver presses STOP)

        while (opModeIsActive()) {


            currentPower = -gamepad1.left_stick_y;
//            double turn  =  gamepad1.right_stick_x;
            motorTest.setPower(currentPower);
            telemetry.addData("Status", "Running");
            telemetry.addData("Power", currentPower);
            telemetry.update();






        }
    }
}