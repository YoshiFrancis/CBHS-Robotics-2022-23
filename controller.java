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
    private DcMotor[] rightDrive = {null, null};
    private DcMotor[] leftDrive = {null, null};

    private float currentPower = 0;
    @Override
    public void runOpMode() {

        rightDrive[0] = hardwareMap.get(DcMotor.class, "motorZero");
        rightDrive[1] = hardwareMap.get(DcMotor.class, "motorZero");
        leftDrive[0] = hardwareMap.get(DcMotor.class, "motorOne");
        leftDrive[1] = hardwareMap.get(DcMotor.class, "motorOne");

        telemetry.addData("Status", "Initialized");
        telemetry.update();
        // Wait for the game to start (driver presses PLAY)
        waitForStart();


        // run until the end of the match (driver presses STOP)

        while (opModeIsActive()) {

            if (Math.abs(gamepad1.left_stick_y ) < Math.abs(gamepad1.left_stick_x))
            {
                currentPower = -gamepad1.left_stick_x;
                for (int i = 0; i < 2; i++)
                {
                    rightDrive[i].setPower(currentPower);
                    leftDrive[i].setPower(currentPower);
                }
            }
            else
            {
                currentPower = -gamepad1.left_stick_y;
                for (int i = 0; i < 2; i++)
                {
                    leftDrive[i].setPower(currentPower);
                    rightDrive[i].setPower(-currentPower);
                }
            }

            telemetry.addData("Status", "Running");
            telemetry.addData("Power", currentPower);
            telemetry.update();

        }
    }
}