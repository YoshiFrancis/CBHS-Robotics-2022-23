package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.Gyroscope;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp

/*
To start controller #1; press Start + A
to start controller #2; press Start + B
*/


public class controller extends LinearOpMode {
    private DcMotor leftDrive = null;
    private DcMotor rightDrive = null;

    private float currentPower = 0;
    @Override
    public void runOpMode() {
        leftDrive = hardwareMap.get(DcMotor.class, "motorZero");
        rightDrive = hardwareMap.get(DcMotor.class, "motorOne");
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        // Wait for the game to start (driver presses PLAY)
        waitForStart();


        // run until the end of the match (driver presses STOP)

        while (opModeIsActive()) {


            currentPower = -gamepad1.left_stick_y * 1f;
//            double turn  =  gamepad1.right_stick_x;
            leftDrive.setPower(currentPower);
            rightDrive.setPower(-currentPower);
            telemetry.addData("Status", "Running");
            telemetry.addData("Power", currentPower);
            telemetry.update();






        }
    }
}