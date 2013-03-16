
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.CANJaguar.ControlMode;
import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.PIDPitch;
/**
 *
 * @author Jessie
 */
public class Pitch extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    public CANJaguar pitchMot;// = new Jaguar(RobotMap.pitchMot);
    //this is different because it is a magnetic encoder
    public AnalogChannel pitchEncoder = new AnalogChannel(RobotMap.pitchEncoder);
    
    
    
    public Pitch(){
        
        try{
            //pitchMot = new CANJaguar(RobotMap.pitchMot);
            pitchMot = new CANJaguar(RobotMap.pitchMot);
            pitchMot.changeControlMode(ControlMode.kPosition);
            pitchMot.setPID(350, 0.03, 0.0);
            pitchMot.configSoftPositionLimits(3.75, 4.35);
            pitchMot.setPositionReference(CANJaguar.PositionReference.kPotentiometer);
            pitchMot.configNeutralMode(CANJaguar.NeutralMode.kCoast);
            pitchMot.configPotentiometerTurns(10);
        }catch(Exception e){
            System.out.println(e);
            e.printStackTrace();  
        }
         
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        
    }
    
    
    
    
    
    /**
     * sets the position of the pitch motor.  
     * @param position position of the pitch motor. 0 <= position <= 1. Zero is biggest angle, 1 is straight
     */
    public void setPosition(double position){
        position = position * .6 + 3.75;
        try{
            pitchMot.setX(position);
        }catch(Exception e){
            System.out.println(e);
            e.printStackTrace();  
        }
    }
    
    public boolean onTarget(){
        double x = 0.05;
        try{
            x = Math.abs(pitchMot.getX() - pitchMot.getPosition());
        }catch(Exception e){
            e.printStackTrace();  
        }
        return  x < 0.04;
    }
    
    public void enable(){
       try{
            pitchMot.enableControl();
        }catch(Exception e){
            e.printStackTrace();
        } 
    }
    
    
    public void disable(){
        try{
            pitchMot.disableControl();
        }catch(Exception e){
            e.printStackTrace();   
        }
    }
    
}

