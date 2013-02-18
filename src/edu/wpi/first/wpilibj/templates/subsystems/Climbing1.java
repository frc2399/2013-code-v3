
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.CANJaguar.ControlMode;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 */
public class Climbing1 extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public CANJaguar climbingMot1;
    
    public Climbing1(){
        
        try{
            climbingMot1 = new CANJaguar(RobotMap.climbingMot1);
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    
}

