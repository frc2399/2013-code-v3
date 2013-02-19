
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.commands.ShootOn;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author Jessie
 */
public class Autonomous extends CommandGroup{

    public Autonomous() {
     
        addSequential(new ShootOn(1));
        addSequential(new Fire());
        addSequential(new ShootOff());
    }
}
