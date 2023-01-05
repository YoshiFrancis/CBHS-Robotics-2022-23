package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous
public class TwoMotors extends LinearOpMode {

    private DcMotor rightDrive = null;
    private DcMotor leftDrive = null;

    @Override
    public void runOpMode() {

        rightDrive = hardwareMap.get(DcMotor.class, "motorZero");
        leftDrive = hardwareMap.get(DcMotor.class, "motorOne");

        leftDrive.setDirection(DcMotor.Direction.FORWARD);
        rightDrive.setDirection(DcMotor.Direction.FORWARD);

        waitForStart();

        leftDrive.setPower(2f);
        rightDrive.setPower(2f);
    }
}
