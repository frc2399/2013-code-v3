/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.Accelerometer;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.Timer;
/**
 *
 * @author Jessie
 */
public class AccelerometerPosition implements PIDSource{
    
    double a;
    double v;
    double vPrev = 0;
    double x;
    double xPrev = 0;
    double t = 0;
    Accelerometer accelerometer;
    Timer timer;
    
    
    public AccelerometerPosition(){
        accelerometer = new Accelerometer(RobotMap.accelerometer);
        timer = new Timer();
        timer.start();
    }
    
    public double pidGet(){
        a = accelerometer.getAcceleration();
        v = (a * (timer.get() * 1000000 - t)) + vPrev;
        x = (.5 * a * ((timer.get() * 1000000 - t) * (timer.get() * 1000000 - t)) + v * (timer.get() * 1000000 - t) + xPrev);
        t = timer.get() * 1000000;
        vPrev = v;
        double xFinal = x;
        xPrev = x;
        return xFinal;
    }
    
    public void reset(){
        v = 0;
        x = 0;
    }
    
    
}
