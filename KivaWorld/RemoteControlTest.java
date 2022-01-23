
/**
 * Write a description of RemoteControlTest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.Arrays;

public class RemoteControlTest {
    
    public void testRemoteControl()
    {
        RemoteControl control = new RemoteControl();
        
        String directions = "FFFTRF";
        KivaCommand[] commands = control.convertToKivaCommand(directions);
        
        System.out.println(Arrays.toString(commands));
        
        directions = "B";
        commands = control.convertToKivaCommand(directions);
        
        System.out.println(Arrays.toString(commands));
    }

}
