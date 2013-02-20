
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.CANJaguar.ControlMode;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 */
public class Climbing2 extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public CANJaguar climbingMot2;
    
    public Climbing2(){
        
        try{
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
            climbingMot2.setX(speed);
        }catch(Exception e){
            
        }
    }
    
}



