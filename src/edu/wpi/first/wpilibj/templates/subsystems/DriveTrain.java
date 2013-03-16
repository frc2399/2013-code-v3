
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.commands.JoystickDrive;
import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;

/**
 *
 * @author Lauren Dierker and Jessie Adkins
 */
public class DriveTrain extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public CANJaguar leftFront; // = new Jaguar(1);
    public CANJaguar leftRear; // = new Jaguar(2);
    public CANJaguar rightFront; // = new Jaguar(4);
    public CANJaguar rightRear; // = new Jaguar(3);
    
    
    
    Encoder testEncoder = new Encoder(RobotMap.testEncoderA, RobotMap.testEncoderB);
    public Gyro gyro = new Gyro(RobotMap.gyro);
    
    public RobotDrive drive;
    
    public DriveTrain(){
        
        try{
            
            //CORRECT 
            leftFront = new CANJaguar(RobotMap.driveFrontLeft);
            leftRear = new CANJaguar(RobotMap.driveBackLeft);
            rightFront = new CANJaguar(RobotMap.driveFrontRight);
            rightRear = new CANJaguar(RobotMap.driveBackRight);
             
            
            //TESTING 
            /**
            leftFront = new CANJaguar(RobotMap.testLeftFront);
            leftRear = new CANJaguar(RobotMap.testLeftRear);
            rightFront = new CANJaguar(RobotMap.testRightFront);
            rightRear = new CANJaguar(RobotMap.testRightRear);
             */
        }catch(Exception e){
            System.out.println(e);
            System.out.println(leftFront);
            System.out.println(leftRear);
            System.out.println(rightFront);
            System.out.println(rightRear);
        }
        
        
        drive = new RobotDrive(leftFront, leftRear, rightFront, rightRear);
        //ONLY FOR MYCROFT!
        //drive.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
        //drive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
        gyro.reset();
        gyro.setSensitivity(0.007);
    }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand( new JoystickDrive(1, false));
    }
    
    public double getTestEncoder() {
        return testEncoder.getDistance();
    }
    
    public void startTestEncoder() {
        testEncoder.start();
    }
    
    public double getGyroAngle(){
        return gyro.getAngle();
        //return 0.0;
    }
    
    public void resetGyro(){
        gyro.reset();
    }
}

