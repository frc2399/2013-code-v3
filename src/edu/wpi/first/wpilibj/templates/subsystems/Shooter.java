
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem; 
import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 */
public class Shooter extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    //might be correct port #
    //if this fails, ask electrical if it is actually plugged into this port
    //might not be a Jag
    
    //public Encoder shootEncoder = new Encoder(RobotMap.shootEncoderA, RobotMap.shootEncoderB);
    public CANJaguar shootMot;
    
    public Shooter(){
        
        try {
            shootMot = new CANJaguar(RobotMap.shootMot);
            //shootMot = new CANJaguar(RobotMap.testShootMot);
            
            shootMot.changeControlMode(CANJaguar.ControlMode.kSpeed);
            //PRACTISE BOT
            //shootMot.configEncoderCodesPerRev(6);
            //COMPETITION BOT USE THIS!!!!!
            shootMot.configEncoderCodesPerRev(360);
            shootMot.configNeutralMode(CANJaguar.NeutralMode.kBrake);
            shootMot.setPID(0.5, 0.03, 0.0);
            shootMot.setSpeedReference(CANJaguar.SpeedReference.kEncoder);
            
        }catch(Exception e){
            System.out.println(e);
        }
         
        
    }

    //not setting a default command at the moment
    //there is no default in 2012 code
    //not sure why, no comments
    //might make never ending things happen!
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    protected double returnPIDInput(){
        //return shootEncoder.pidGet();
        return 0.0;
    }
    
    protected void usePIDOutput(double output){
        //TEST THIS
        //this is really small so that the robot does not decapitatie itself!
        
        try{
            shootMot.setX(output);
        }catch(Exception e){
            
        }
         
        
    }
    
    public void setShooterSpeed(double speed){
        //shootMot.set(speed);

        
        
         try{
            shootMot.setX(speed);
        }catch(Exception e){
            e.printStackTrace();
        }
         
    }
    public double getSpeedSetpoint(){
        double x = -1.0;
        try{
            x =  shootMot.getX();
        }catch(Exception e){
            e.printStackTrace();
        }
        return x;
    }
            
    public double getSpeed(){
        double x = -1.0;
        try{
            x =  shootMot.getSpeed();
        }catch(Exception e){
            
        }
        return x;
    }
    
    public boolean isReady(){
        
        double error = Math.abs(getSpeed() + getSpeedSetpoint());
        if (error <= 300){
            //System.out.println("Shoot Ended; error = " + error);
        
            return true;
        }else{
            //System.out.println("Shoot Ended; error = " + error);
            return false;
        }
    }
    
    
}


