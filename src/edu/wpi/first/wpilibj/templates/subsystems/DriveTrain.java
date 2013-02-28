
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.commands.JoystickDrive;
import edu.wpi.first.wpilibj.CANJaguar;
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
            leftFront = new CANJaguar(7);
            leftRear = new CANJaguar(8);
            rightFront = new CANJaguar(6);
            rightRear = new CANJaguar(5);
        }catch(Exception e){
            System.out.println(e);
            System.out.println(leftFront);
            System.out.println(leftRear);
            System.out.println(rightFront);
            System.out.println(rightRear);
        }
        
        drive = new RobotDrive(leftFront, leftRear, rightFront, rightRear);
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
    }
    
    public void resetGyro(){
        gyro.reset();
    }
}

