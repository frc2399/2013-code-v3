
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.CANJaguar.ControlMode;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.DigitalInput;

/**
 *
 * @author Jessie
 */
public class Climbing extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    
    public CANJaguar climbingMot1;
    public CANJaguar climbingMot2;
    
    public DigitalInput topLimit1;
    public DigitalInput topLimit2;
    public DigitalInput bottomLimit1;
    public DigitalInput bottomLimit2;
    
    
    
    public Climbing(){
        
        try{
            climbingMot1 = new CANJaguar(RobotMap.climbingMot1);
            climbingMot2 = new CANJaguar(RobotMap.climbingMot2);
        }catch(Exception e){
            System.out.println(e);
        }
         
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void setSpeed1(double speed){
        
        try{
            climbingMot1.setX(speed);
        }catch(Exception e){
            e.printStackTrace();
        }
         
    }
    public void setSpeed2(double speed){
        
        try{
            climbingMot2.setX(speed);
        }catch(Exception e){
            e.printStackTrace();
        }
         
    }
    
    public boolean getTopLimit1(){
        return topLimit1.get();
    }
    
    public boolean getBottomLimit1(){
        return bottomLimit1.get();
    }
    
    public boolean getTopLimit2(){
        return topLimit2.get();
    }
    
    public boolean getBottomLimit2(){
        return bottomLimit2.get();
    }
    
}

