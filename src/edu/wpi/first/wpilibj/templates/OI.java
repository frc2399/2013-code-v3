
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.DigitalIOButton;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.templates.commands.TestVision;
import edu.wpi.first.wpilibj.templates.commands.Shoot;
import edu.wpi.first.wpilibj.templates.commands.GyroReset;
import edu.wpi.first.wpilibj.templates.commands.JoystickDrive;
import edu.wpi.first.wpilibj.templates.commands.PIDYaw;
import edu.wpi.first.wpilibj.templates.commands.Fire;
import edu.wpi.first.wpilibj.templates.commands.CloseLoopAngleDrive;
import edu.wpi.first.wpilibj.templates.commands.LoaderTester;
import edu.wpi.first.wpilibj.templates.commands.PIDPitch;
import edu.wpi.first.wpilibj.templates.commands.Lift;
import edu.wpi.first.wpilibj.templates.commands.TestPitch;
import edu.wpi.first.wpilibj.templates.commands.PIDStrafe;
import edu.wpi.first.wpilibj.templates.commands.SetLEDColour;
import edu.wpi.first.wpilibj.templates.commands.NewTestVision;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // Another type of button you can create is a DigitalIOButton, which is
    // a button or switch hooked up to the cypress module. These are useful if
    // you want to build a customized operator interface.
    // Button button = new DigitalIOButton(1);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
    
    
    Joystick driveyStick = new Joystick(3);
    Joystick leftStick = new Joystick(1);
    Joystick rightStick = new Joystick(2);
    
    public static int fastShootButtNum = 4;
    public static int medShootButtNum = 5;
   // public static int slowShootButtNum = 9;
    public static int shootOffButtNum = 2;
    
    public static int turnButtNum = 3;
    public static int backwardsJoystickDriveButtNum = 8;
    
    public static int fieldOrientButtNum = 3;
    public static int joystickDriveButtNum = 4;
    public static int gyroResetButtNum = 2;
    
    public static int fireButtNum = 1;
    public static int closeLoopDriveButtNum = 11;
    public static int loaderTestButtNum = 9;
    public static int manPitchOnDownTestButtNum = 11;
    public static int manPitchOnUpTestButtNum = 8;
    public static int manPitchOffTestButtNum = 10;
    
    public static int liftOnUpButtNum = 6;
    public static int liftOnDownButtNum = 7;
    public static int liftOffButtNum =11;
    
    public static int aimButtNum = 2;
    public static int strafeButtNum = 6;
    public static int strafe2ButtNum = 7;
    public static int setLEDRedButtNum = 2;
    public static int setLEDBlueButtNum = 3;
    public static int setLEDGreenButtNum = 4;
    public static int setLEDAmberButtNum = 5;
    public static int setAllLEDButtNum = 1;
    
    public static int imageProcessingNum = 6;
    
    public static int aimTopNum = 8;
    public static int aimMiddleNum = 9;
    
    
    
    private final JoystickButton fastShootButt = new JoystickButton(rightStick, fastShootButtNum); 
    private final JoystickButton medShootButt = new JoystickButton(rightStick, medShootButtNum); 
    //private final JoystickButton slowShootButt = new JoystickButton(driveyStick, slowShootButtNum); 
    private final JoystickButton shootOffButt = new JoystickButton(rightStick, shootOffButtNum);
    
    private final JoystickButton backwardsJoystickDriveButt = new JoystickButton(rightStick, backwardsJoystickDriveButtNum);
    private final JoystickButton fireButt = new JoystickButton(rightStick, fireButtNum);
    private final JoystickButton closeLoopDriveButt = new JoystickButton(driveyStick, closeLoopDriveButtNum);
    private final JoystickButton loaderTestButt = new JoystickButton(leftStick, loaderTestButtNum);
    private final JoystickButton manPitchOnDownTestButt = new JoystickButton(rightStick, manPitchOnDownTestButtNum);
    private final JoystickButton manPitchOnUpTestButt = new JoystickButton(rightStick, manPitchOnUpTestButtNum);
    private final JoystickButton manPitchOffTestButt = new JoystickButton(rightStick, manPitchOffTestButtNum);
    
    private final JoystickButton liftOnUpButt = new JoystickButton(rightStick, liftOnUpButtNum);
    private final JoystickButton liftOnDownButt = new JoystickButton(rightStick, liftOnDownButtNum);
    private final JoystickButton liftOffButt = new JoystickButton(leftStick, liftOffButtNum);
    
    
    private final JoystickButton joystickDriveButt = new JoystickButton(driveyStick, joystickDriveButtNum);
    private final JoystickButton fieldOrientButt = new JoystickButton(driveyStick, fieldOrientButtNum);
    private final JoystickButton gyroResetButt = new JoystickButton(driveyStick, gyroResetButtNum);
    
    
    private final JoystickButton aim = new JoystickButton(driveyStick, aimButtNum);
    private final JoystickButton strafe = new JoystickButton(leftStick, strafeButtNum);
    private final JoystickButton strafe2 = new JoystickButton(leftStick, strafe2ButtNum);
    
    private final JoystickButton setLEDRed = new JoystickButton(leftStick, setLEDRedButtNum);
    private final JoystickButton setLEDBlue = new JoystickButton(leftStick, setLEDBlueButtNum);
    private final JoystickButton setLEDGreen = new JoystickButton(leftStick, setLEDGreenButtNum);
    private final JoystickButton setLEDAmber = new JoystickButton(leftStick, setLEDAmberButtNum);
    //private final JoystickButton setAllLEDButt = new JoystickButton(rightStick, setAllLEDButtNum);
    
    private final JoystickButton imageProcessing = new JoystickButton( leftStick, imageProcessingNum);
    
    private final JoystickButton aimTopButt = new JoystickButton( leftStick, aimTopNum);
    private final JoystickButton aimMiddleButt = new JoystickButton( leftStick, aimMiddleNum);
    
    
    Shoot fastShootOn = new Shoot(1);
    Shoot medShootOn = new Shoot(.75);
    Shoot slowShootOn = new Shoot(.5);
    Shoot shootOff = new Shoot(0);
    PIDYaw turn = new PIDYaw(90);
    JoystickDrive joystickDrive = new JoystickDrive(1, false);
    JoystickDrive backwardsJoystickDrive = new JoystickDrive(-1, true);
    JoystickDrive fieldOrient = new JoystickDrive(1, true);
    GyroReset gyroReset = new GyroReset();
    Fire fireOn = new Fire();
    CloseLoopAngleDrive closeLoopDrive = new CloseLoopAngleDrive(0);
    TestVision testVision = new TestVision(); 
    NewTestVision newTestVision = new NewTestVision(false, false, true);
    PIDStrafe strafes = new PIDStrafe(2);
    PIDStrafe strafess = new PIDStrafe( -2);
    CloseLoopAngleDrive clad = new CloseLoopAngleDrive(0);
    LoaderTester loaderTester = new LoaderTester();
    PIDPitch manPitch = new PIDPitch(0, true, false);
    PIDPitch manPitchOff = new PIDPitch(0, false, true);
    Lift liftUp = new Lift(0.75);
    Lift liftOff = new Lift(0.0);
    Lift liftDown = new Lift(-0.75);
    TestPitch testPitchOnDown = new TestPitch(0.3);
    TestPitch testPitchOnUp = new TestPitch(-0.3);
    SetLEDColour setRed = new SetLEDColour(true, false, false, false);
    SetLEDColour setBlue = new SetLEDColour(false, true, false, false);
    SetLEDColour setGreen = new SetLEDColour(false, false, true, false);
    SetLEDColour setAmber = new SetLEDColour(false, false, false, true);
    SetLEDColour setAllLED = new SetLEDColour(true, true, true, true);
    
    NewTestVision setAimTop = new NewTestVision(true, false, false);
    NewTestVision setAimMiddle = new NewTestVision(false, true, false);
    
    

    public OI(){
        fastShootButt.whenPressed(fastShootOn);
        medShootButt.whenPressed(medShootOn);
        //slowShootButt.whenPressed(slowShootOn);
        shootOffButt.whenPressed(shootOff);
        //backwardsJoystickDriveButt.whenPressed(backwardsJoystickDrive);
        
        joystickDriveButt.whenPressed(joystickDrive);
        fieldOrientButt.whenPressed(fieldOrient);
        gyroResetButt.whenPressed(gyroReset);
        
        fireButt.whenPressed(fireOn);
        //closeLoopDriveButt.whenPressed(closeLoopDrive);
        //aim.whenPressed(clad);
        //aim.whileHeld(testVision);
        //aim.whenReleased(joystickDrive);
        //strafe.whileHeld(strafes);
        //strafe2.whileHeld(strafess);
        //loaderTestButt.whenPressed(loaderTester);
        
        manPitchOnDownTestButt.whenPressed(manPitch);
        manPitchOffTestButt.whenPressed(manPitchOff);
        //manPitchOnDownTestButt.whenPressed(testPitchOnDown);
        //manPitchOnUpTestButt.whenPressed(testPitchOnUp);
        
        
        liftOnUpButt.whenPressed(liftUp);
        liftOnDownButt.whenPressed(liftDown);
        liftOffButt.whenPressed(liftOff);
        
        setLEDRed.whenPressed(setRed);
        setLEDBlue.whenPressed(setBlue);
        setLEDGreen.whenPressed(setGreen);
        setLEDAmber.whenPressed(setAmber);
        //etAllLEDButt.whenPressed(setAllLED);
        
        imageProcessing.whenPressed(newTestVision);
        
        aimTopButt.whenPressed(setAimTop);
        aimMiddleButt.whenPressed(setAimMiddle);
    }
    
    

    public double getForwardSpeed(){
        return -driveyStick.getRawAxis(2);
    }
    
    public double getSideSpeed(){
        return -driveyStick.getRawAxis(1);
    }
    
    public double getTwistSpeed(){
        return -driveyStick.getRawAxis(3); 
    }

    public double getDriveyStickThrottle(){
        return driveyStick.getRawAxis(4);
    }
    
    public double getLeftStickThrottle(){
        return leftStick.getRawAxis(3);
    }
    
    public double getRightStickThrottle(){
        return rightStick.getRawAxis(3);
    }
}

