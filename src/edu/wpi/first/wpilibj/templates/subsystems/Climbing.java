
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
            //left
            climbingMot1 = new CANJaguar(RobotMap.climbingMot1);
            //right
            climbingMot2 = new CANJaguar(RobotMap.climbingMot2);
        }catch(Exception e){
            System.out.println(e);
        }
         
        //left top
        topLimit1 = new DigitalInput(RobotMap.liftLimitSwitchTop1);
        //right top
        topLimit2 = new DigitalInput(RobotMap.liftLimitSwitchTop2);
        //left bottom
        bottomLimit1 = new DigitalInput(RobotMap.liftLimitSwitchBottom1);
        //right bottom
        bottomLimit2 = new DigitalInput(RobotMap.liftLimitSwitchBottom2);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void setSpeed1(double speed){
        //left
        
        if(speed < 0){
            if(bottomLimit1.get() == false){
                try{
                    climbingMot1.setX(0);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }else{
                try{
                    climbingMot1.setX(speed);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }else if(speed > 0){
            if(topLimit1.get() == false){
                try{
                    climbingMot1.setX(0);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }else{
                try{
                    climbingMot1.setX(speed);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }else{
            try{
                climbingMot1.setX(0);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    
    
    public void setSpeed2(double speed){
        //right
        
        if(speed < 0){
            if(bottomLimit2.get() == false){
                try{
                    climbingMot2.setX(0);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }else{
                try{
                    climbingMot2.setX(speed);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }else if(speed > 0){
            if(topLimit2.get() == false){
                try{
                    climbingMot2.setX(0);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }else{
                try{
                    climbingMot2.setX(speed);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }else{
            try{
                climbingMot2.setX(0);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
         
    }
    
    public double getSpeed1(){
        double speed = 0.0;
        try{
            speed = climbingMot1.getX();
        }catch(Exception e){
            e.printStackTrace();
        }
        return speed;
                
    }
    
    public double getSpeed2(){
        double speed = 0.0;
        try{
            speed = climbingMot2.getX();
        }catch(Exception e){
            e.printStackTrace();
        }
        return speed;
                
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

