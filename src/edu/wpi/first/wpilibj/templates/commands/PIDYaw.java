
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.templates.PIDOutputTranslator;


/**
 * PIDYaw is used to move the robot to a specified angle using a PID Controller 
 * in the command.  When called, the robot should move to the specified angle
 * accurately, and stop once it gets there.  This command will end if the robot 
 * is at the correct angle.  However, if for some reason the robot starts spinning
 * in the wrong direction, it will never reach the specified angle and will go 
 * into a continuous death spin.  In order to kill this, you need to take away 
 * the subsystems supporting this command (AKA driveTrain), and it will stop 
 * immediately.  I recommend switching over to JoystickDrive if you want to kill 
 * this command.  Likewise, if you are using this command, you will not be able
 * to drive the robot regularly, and the driving joystick will do nothing.  
 * @author Jessie
 */
public class PIDYaw extends CommandBase {
    
    PIDController controller;
    PIDOutputTranslator translator;
    double angle;

    public PIDYaw(double angle) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(driveTrain);
        this.angle = angle;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        
        translator = new PIDOutputTranslator();
        
        //controller = new PIDController((oi.getDriveyStickThrottle() + 1.0) / 20.0, 0, 0, driveTrain.gyro, translator);
        controller = new PIDController(0.001, 0, 0, driveTrain.gyro, translator);
        // P = 0.00546875
        controller.setSetpoint(driveTrain.getGyroAngle() + angle);
        controller.setPercentTolerance(1);
        controller.setInputRange(-360, 360);
        controller.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        System.out.println("Translator: " + translator.getValue() + "P " + controller.getP());
        
        driveTrain.drive.mecanumDrive_Cartesian(0, 0, -translator.getValue(), 0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return controller.onTarget();
    }

    // Called once after isFinished returns true
    protected void end() {
        controller.disable();
        controller.free();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        controller.disable();
        controller.free();
    }
}
