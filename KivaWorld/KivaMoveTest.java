
/**
 * Write a description of KivaMoveTest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.Point;

public class KivaMoveTest {
    // Define the FloorMap we'll use for all the tests
    String defaultLayout = ""
                            + "-------------\n"
                            + "        P   *\n"
                            + "   **       *\n"
                            + "   **       *\n"
                            + "  K       D *\n"
                            + " * * * * * **\n"
                            + "-------------\n";
    FloorMap defaultMap = new FloorMap(defaultLayout);
    
    public void testForwardFromUp()
    {
        // GIVEN
        // A Kiva built with the default map we define earlier
        Kiva kiva = new Kiva(defaultMap);
        
        // WHEN
        // We move one space forward
        kiva.move(KivaCommand.FORWARD);
        
        //THEN
        //The Kiva has moved one spave up
        verifyKivaState("testForwardFromUp", kiva, new Point(2, 3), FacingDirection.UP, false, false);
    }
    
    public void testTurnLeftFromUp()
    {
        // GIVEN
        // A Kiva built with the default map we define earlier
        Kiva kiva = new Kiva(defaultMap);
        
        // WHEN
        // We move one space forward
        kiva.move(KivaCommand.TURN_LEFT);
        
        //THEN
        //The Kiva has turn to the left.
        verifyKivaState("testTurnLeftFromUp", kiva, kiva.getCurrentLocation(), FacingDirection.LEFT, false, false);
    }
    
    public void testTurnLeftFromLeft()
    {
        // GIVEN
        // A Kiva built with the default map we define earlier
        Kiva kiva = new Kiva(defaultMap);
        
        // WHEN
        // We move one space forward
        kiva.move(KivaCommand.TURN_LEFT);
        kiva.move(KivaCommand.TURN_LEFT);
        
        //THEN
        //The Kiva has turn to the left two times.
        verifyKivaState("testTurnLeftFromLeft", kiva, kiva.getCurrentLocation(), FacingDirection.DOWN, false, false);
    }
    
    public void testTurnLeftFromDown()
    {
        // GIVEN
        // A Kiva built with the default map we define earlier
        Kiva kiva = new Kiva(defaultMap);
        
        // WHEN
        // We move one space forward
        kiva.move(KivaCommand.TURN_LEFT);
        kiva.move(KivaCommand.TURN_LEFT);
        kiva.move(KivaCommand.TURN_LEFT);
        
        //THEN
        //The Kiva has turn to the left three times.
        verifyKivaState("testTurnLeftFromDown", kiva, kiva.getCurrentLocation(), FacingDirection.RIGHT, false, false);
    }
    
    public void testTurnLeftFromRight()
    {
        // GIVEN
        // A Kiva built with the default map we define earlier
        Kiva kiva = new Kiva(defaultMap);
        
        // WHEN
        // We move one space forward
        kiva.move(KivaCommand.TURN_LEFT);
        kiva.move(KivaCommand.TURN_LEFT);
        kiva.move(KivaCommand.TURN_LEFT);
        kiva.move(KivaCommand.TURN_LEFT);
        
        //THEN
        //The Kiva has turn to the left four times.
        verifyKivaState("testTurnLeftFromRight", kiva, kiva.getCurrentLocation(), FacingDirection.UP, false, false);
    }
    
    public void testForwardWhileFacingLeft()
    {
        // GIVEN
        // A Kiva built with the default map we define earlier
        Kiva kiva = new Kiva(defaultMap);
        
        // WHEN
        // We turn left and move one space forward
        kiva.move(KivaCommand.TURN_LEFT);
        kiva.move(KivaCommand.FORWARD);
        
        //THEN
        //The Kiva has moved one spave left
        verifyKivaState("testForwardWhileFacingLeft", kiva, new Point(1, 4), FacingDirection.LEFT, false, false);
    }
    
    public void testForwardWhileFacingDown()
    {
        // GIVEN
        // A Kiva built with the default map we define earlier
        Kiva kiva = new Kiva(defaultMap);
        
        // WHEN
        // We turn left and move one space forward
        kiva.move(KivaCommand.TURN_LEFT);
        kiva.move(KivaCommand.TURN_LEFT);
        kiva.move(KivaCommand.FORWARD);
        
        //THEN
        //The Kiva has moved one spave down
        verifyKivaState("testForwardWhileFacingDown", kiva, new Point(2, 5), FacingDirection.DOWN, false, false);
    }
    
    public void testForwardWhileFacingRight()
    {
        // GIVEN
        // A Kiva built with the default map we define earlier
        Kiva kiva = new Kiva(defaultMap);
        
        // WHEN
        // We turn left and move one space forward
        kiva.move(KivaCommand.TURN_LEFT);
        kiva.move(KivaCommand.TURN_LEFT);
        kiva.move(KivaCommand.TURN_LEFT);
        kiva.move(KivaCommand.FORWARD);
        
        //THEN
        //The Kiva has moved one spave right
        verifyKivaState("testForwardWhileFacingRight", kiva, new Point(3, 4), FacingDirection.RIGHT, false, false);
    }
    
    public void testTurnRightFromUp()
    {
        // GIVEN
        // A Kiva built with the default map we define earlier
        Kiva kiva = new Kiva(defaultMap);
        
        // WHEN
        // We move one space forward
        kiva.move(KivaCommand.TURN_RIGHT);
        
        //THEN
        //The Kiva has turn to the right.
        verifyKivaState("testTurnRightFromUp", kiva, kiva.getCurrentLocation(), FacingDirection.RIGHT, false, false);
    }
    
    public void testTurnRightFromLeft()
    {
        // GIVEN
        // A Kiva built with the default map we define earlier
        Kiva kiva = new Kiva(defaultMap);
        
        // WHEN
        // We move one space forward
        kiva.move(KivaCommand.TURN_LEFT);
        kiva.move(KivaCommand.TURN_RIGHT);
        
        //THEN
        //The Kiva has turn to the right.
        verifyKivaState("testTurnRightFromLeft", kiva, kiva.getCurrentLocation(), FacingDirection.UP, false, false);
    }
    
    public void testTurnRightFromDown()
    {
        // GIVEN
        // A Kiva built with the default map we define earlier
        Kiva kiva = new Kiva(defaultMap);
        
        // WHEN
        // We move one space forward
        kiva.move(KivaCommand.TURN_LEFT);
        kiva.move(KivaCommand.TURN_LEFT);
        kiva.move(KivaCommand.TURN_RIGHT);
        
        //THEN
        //The Kiva has turn to the right.
        verifyKivaState("testTurnRightFromDown", kiva, kiva.getCurrentLocation(), FacingDirection.LEFT, false, false);
    }
    
    public void testTurnRightFromRight()
    {
        // GIVEN
        // A Kiva built with the default map we define earlier
        Kiva kiva = new Kiva(defaultMap);
        
        // WHEN
        // We move one space forward
        kiva.move(KivaCommand.TURN_LEFT);
        kiva.move(KivaCommand.TURN_LEFT);
        kiva.move(KivaCommand.TURN_LEFT);
        kiva.move(KivaCommand.TURN_RIGHT);
        
        //THEN
        //The Kiva has turn to the right.
        verifyKivaState("testTurnRightFromRight", kiva, kiva.getCurrentLocation(), FacingDirection.DOWN, false, false);
    }
    
    public void testTakeOnPod()
    {
        // GIVEN
        // A Kiva built with the default map we define earlier
        Kiva kiva = new Kiva(defaultMap);
        
        // WHEN
        // We move one space forward
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.TURN_RIGHT);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.TAKE);
        
        //THEN
        //The Kiva has taken the pod
        verifyKivaState("testTakeOnPod", kiva, defaultMap.getPodLocation(), FacingDirection.RIGHT, true, false);
    }
    
    public void testDropOnDropZone()
    {
        // GIVEN
        // A Kiva built with the default map we define earlier
        Kiva kiva = new Kiva(defaultMap);
        
        // WHEN
        // We move one space forward
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.TURN_RIGHT);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.TAKE);
        kiva.move(KivaCommand.TURN_RIGHT);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.TURN_LEFT);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.DROP);
        
        //THEN
        //The Kiva has taken the pod
        verifyKivaState("testDropOnDropZone", kiva, defaultMap.getDropZoneLocation(), FacingDirection.RIGHT, false, true);
    }
    
    public void testMoveOutOfBounds()
    {
        // GIVEN
        // A Kiva built with the default map we define earlier
        Kiva kiva = new Kiva(defaultMap);
        
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.TURN_LEFT);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        System.out.println("testMoveOutOfBounds: (Espect an IllegalMoveException)");
        kiva.move(KivaCommand.FORWARD);
        
        // this only runs if no exception was thrown
        System.out.println("testMoveOutOfBounds: FAIL!!");
        System.out.println("Moved outside the FloorMap!");
    }
    
    public void testObstacleChecking()
    {
        // GIVEN
        // A Kiva built with the default map we define earlier
        Kiva kiva = new Kiva(defaultMap);
        
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.TURN_RIGHT);
        System.out.println("testObstacleChecking: (Espect an IllegalMoveException)");
        kiva.move(KivaCommand.FORWARD);
        
        // this only runs if no exception was thrown
        System.out.println("testMoveObstacleChecking: FAIL!!");
        System.out.println("There is an obstacle in this location!");
    }
    
    public void testPodCollitionChecking()
    {
        // GIVEN
        // A Kiva built with the default map we define earlier
        Kiva kiva = new Kiva(defaultMap);
        
        // WHEN
        // We move one space forward
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.TURN_RIGHT);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.TAKE);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.TURN_RIGHT);
        kiva.move(KivaCommand.TURN_RIGHT);
        System.out.println("testPodCollitionChecking: (Espect an IllegalMoveException)");
        kiva.move(KivaCommand.FORWARD);
        
        // this only runs if no exception was thrown
        System.out.println("testPodCollitionChecking: FAIL!!");
        System.out.println("Kiva is already carrying a pod!");
    }
    
    public void testPodPresenceChecking()
    {
        // GIVEN
        // A Kiva built with the default map we define earlier
        Kiva kiva = new Kiva(defaultMap);
        
        // WHEN
        // We move one space forward
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        System.out.println("testPodPresenceChecking: (Espect a NoPodException)");
        kiva.move(KivaCommand.TAKE);
        
        // this only runs if no exception was thrown
        System.out.println("testPodPresenceChecking: FAIL!!");
        System.out.println("This location does not contain a pod!");
    }
    
    public void testExistingDropZoneChecking()
    {
        // GIVEN
        // A Kiva built with the default map we define earlier
        Kiva kiva = new Kiva(defaultMap);
        
        // WHEN
        // We move one space forward
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        System.out.println("testExistingDropZoneChecking: (Espect an IllegalDropZoneException)");
        kiva.move(KivaCommand.DROP);
        
        // this only runs if no exception was thrown
        System.out.println("testExistingDropZoneChecking: FAIL!!");
        System.out.println("This location is not a drop zone!");
    }
    
    public void testFutilityChecking()
    {
        // GIVEN
        // A Kiva built with the default map we define earlier
        Kiva kiva = new Kiva(defaultMap);
        
        // WHEN
        // We move one space forward
        kiva.move(KivaCommand.TURN_RIGHT);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        kiva.move(KivaCommand.FORWARD);
        System.out.println("testFutilityChecking: (Espect and IllegalMoveException)");
        kiva.move(KivaCommand.DROP);
        
        // this only runs if no exception was thrown
        System.out.println("testFutilityChecking: FAIL!!");
        System.out.println("Kiva is not carrying a pod!");
    }
    
    
   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public boolean sameLocation(Point a, Point b) 
    {
        return a.getX() == b.getX() && a.getY() == b.getY();
    }
    
    private void verifyKivaState(
                        String testName,
                        Kiva actual,
                        Point expectLocation,
                        FacingDirection expectDirection,
                        boolean expectCarry,
                        boolean expectDropped)
    {
        Point actualLocation = actual.getCurrentLocation();
        if (sameLocation(actualLocation, expectLocation)) {
            System.out.println(String.format("%s: current location SUCCESS", testName));
        } else {
            System.out.println(String.format("%s: current location FAIL!", testName));
            System.out.println(String.format("Expected %s, got %s", expectLocation, actualLocation));
        }
        
        FacingDirection actualDirection = actual.getDirectionFacing();
        if (actualDirection == expectDirection) {
            System.out.println(String.format("%s: facing direction SUCCESS", testName));
        } else {
            System.out.println(String.format("%s: facing direction FAIL!", testName));
            System.out.println(String.format("Expected %s, got %s", expectDirection, actualDirection));
        }
        
        boolean actualCarry = actual.isCarryingPod();
        if (actualCarry == expectCarry) {
            System.out.println(String.format("%s: carrying pod SUCCESS", testName));
        } else {
            System.out.println(String.format("%s: carring pod FAIL!", testName));
            System.out.println(String.format("Expected %s, got %s", expectCarry, actualCarry));
        }
        
        boolean actualDropped = actual.isSuccessfullyDropped();
        if (actualDropped == expectDropped) {
            System.out.println(String.format("%s: successfully dropped SUCCESS", testName));
        } else {
            System.out.println(String.format("%s: successfully dropped FAIL!", testName));
            System.out.println(String.format("Expected %s, got %s", expectDropped, actualDropped));
        }
        
    }
                        
                        

}
