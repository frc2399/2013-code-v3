
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.CANJaguar.ControlMode;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author Jessie
 */
public class Climbing extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    
    public CANJaguar climbingMot1;
    public CANJaguar climbingMot2;
    
    
    
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
    
    public void setSpeed(double speed){
        
        try{
            climbingMot1.setX(speed);
            climbingMot2.setX(speed);
        }catch(Exception e){
            e.printStackTrace();
        }
         
    }
    
}

