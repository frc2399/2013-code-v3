

package edu.wpi.first.wpilibj.templates.commands;


import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.CANJaguar.ControlMode;
import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 * ManPitch is used to control the pitch of the pitch plate using the joysticks.
 * The setpoint of the pitch is based off of the throttle control on the Driving 
 * Joystick.  It will always run, but if you take away its subsystems, it will stop.
 * @author Jessie
 */
public class PIDPitch extends CommandBase {

    double angle;
    boolean manInput;
    
    public PIDPitch(double angle, boolean isDriverControlled) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(pitch);
        manInput = isDriverControlled;
        this.angle = angle;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        pitch.enable();
        
        try{
            pitch.pitchMot.setPID(350, 0.02, 0.0);
            pitch.pitchMot.changeControlMode(ControlMode.kPosition);
            pitch.pitchMot.configSoftPositionLimits(2.0, 2.5);
            pitch.pitchMot.setPositionReference(CANJaguar.PositionReference.kPotentiometer);
            pitch.pitchMot.configNeutralMode(CANJaguar.NeutralMode.kCoast);
            pitch.pitchMot.configPotentiometerTurns(10);
        }catch(Exception e){
            System.out.println(e);
            e.printStackTrace();  
        }
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if(manInput){
            //IF YOU CHANGE THE JOYSTICK FOR THIS, PLEASE CHANGE THE JAVADOC, TOO!
            pitch.setPostition((oi.getDriveyStickThrottle() + 1.0) / 2.0);
        }else{
            //pitch.setSetpoint(angle);
        }
        
        System.out.println("Drivey Stick Throttle: " + oi.getDriveyStickThrottle());
        //System.out.println("regular pitch angle " + pitch.pitchEncoder.getValue());
        //System.out.println("PID pitch angle " + pitch.pitchEncoder.pidGet());
        try{
        //System.out.print("forward limit: " + pitch.pitchMot.getForwardLimitOK());
        //System.out.print("reverse limit: " + pitch.pitchMot.getReverseLimitOK());
        System.out.print("Pitch X: " + pitch.pitchMot.getX());
        System.out.print("P: " + pitch.pitchMot.getP());
        System.out.print("I: " + pitch.pitchMot.getI());
        System.out.println("Pitch Position: " + pitch.pitchMot.getPosition());
        }catch(Exception e){
            e.printStackTrace();  
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        //return pitch.onTarget();
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        pitch.disable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        pitch.disable();
    }
}
