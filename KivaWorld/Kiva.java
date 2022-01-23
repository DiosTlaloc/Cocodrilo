
/**
 * Kiva holds the state and logic of the Kiva Robot; where it is located, which direction it is facing,
 * whether it is carrying a pod, and whether it has successfully dropped the pod.
 * Kiva Robot always starts facing UP, not carrying a pod and not having successfully dropped the pod.
 * 
 * @author (Gustavo Ordaz) 
 * @version (9/27/2021)
 */

import edu.duke.Point;

public class Kiva {
    private Point currentLocation;
    private FacingDirection directionFacing;
    private FloorMap map;
    private boolean carryingPod;
    private boolean successfullyDropped;
    private long motorLifetime;
    
    /**
     * Constructor: instantiate the Kiva Robot with default parameters given a FloorMap object
     * @param map the FloorMap object that Kiva Robot is to navigate.
     */
    public Kiva(FloorMap map)
    {
        this.map = map;
        currentLocation = map.getInitialKivaLocation();
        directionFacing = FacingDirection.UP;
        carryingPod = false;
        successfullyDropped = false;
        motorLifetime = 0;
    }
    
    /**
     * Constructor: instantiate the Kiva Robot with default parameters given a FloorMap object and initial location of the Kiva Robot
     * @param map the FloorMap object that Kiva Robot is to navigate.
     * @param initialLocation the initial location of the Kiva Robot.
     */
    public Kiva(FloorMap map, Point initialLocation)
    {
        this.map = map;
        currentLocation = initialLocation;
        directionFacing = FacingDirection.UP;
        carryingPod = false;
        successfullyDropped = false;
        motorLifetime = 0;
    }
    
    /**
     * Access the motorLifettime of the Kiva Robot
     * @return long the motorLifetime.
     */
    public long getMotorLifetime()
    {
        return motorLifetime;
    }
    
    /**
     * Access the current location of the Kiva Robot
     * @return edu.Duke.Point a point representing the current location.
     */
    public Point getCurrentLocation()
    {
        return currentLocation;
    }
    
    /**
     * Access the direction the Kiva Robor is facing.
     * @return FacingDirection, an enum containing the drection the Robot is facing
     */
    public FacingDirection getDirectionFacing()
    {
        return directionFacing;
    }
    
    /**
     * Access the state that describes if Kiva Robot carries a pod or not
     * @return boolean, true if Kiva Robot is carrying a pod
     */
    public boolean isCarryingPod()
    {
        return carryingPod;
    }
    
    /**
     * Access the state that describes if Kiva Robot dropped the pod successfully in the drop zone.
     * @return boolean, true if the pod was dropped successfully.
     */
    public boolean isSuccessfullyDropped()
    {
        return successfullyDropped;
    }
    
    private void incrementMotorLifetime()
    {
        motorLifetime += 1000;
        
        long lifetime = 20000 * 60 * 60 * 1000L;
        if (motorLifetime >= lifetime) {
            System.out.println("Kiva Robot is at or has exceeded its lifetime!!!");
        }
    }
    
    /**
     * Implements the logic for any KivaCommand. move() throws and exception when an illegal action is performed.
     * IllegalMoveException, is appropriate for attempts to move the Robot off the warehouse floor or into and obstacle.
     * NoPodException, is expected when there is an attempt to TAKE at a location without POD.
     * IllegalDropZoneException, occurs when it is attempted to drop a pod anywhere else but a drop zone.
     * @param KivaCommand the command to be performed
     */
    public void move(KivaCommand command)
    {
        if (command == KivaCommand.FORWARD) {
            goingForward();
            incrementMotorLifetime();
        }
        if (command == KivaCommand.TURN_LEFT) {
            turningLeft();
            incrementMotorLifetime();
        }
        if (command == KivaCommand.TURN_RIGHT) {
            turningRight();
            incrementMotorLifetime();
        }
        if (command == KivaCommand.TAKE) {
            takingPod();
        }
        if (command == KivaCommand.DROP) {
            droppingPod();
        }
        
    }
    
    private void goingForward()
    {
        int x = currentLocation.getX() + directionFacing.getDelta().getX();
        int y = currentLocation.getY() + directionFacing.getDelta().getY();
        Point location = new Point(x, y);
        
        boolean onFloorX = (x >= 0 && x <= map.getMaxColNum());
        boolean onFloorY = (y >= 0 && y <= map.getMaxRowNum());
        boolean onFloor = onFloorX && onFloorY;
        if (!onFloor) {
            throw new IllegalMoveException("Kiva has been moved out of the floor");
        } else {
            FloorMapObject obstacle = map.getObjectAtLocation(location);
            if (obstacle == FloorMapObject.OBSTACLE) {
                throw new IllegalMoveException(String.format("CAN'T MOVE: There is an %s at location %s", obstacle, location));
            } else if (carryingPod == true && obstacle == FloorMapObject.POD) {
                throw new IllegalMoveException(String.format("POD COLLITION: There is a %s at location %s", obstacle, location));
            } else {
                currentLocation = location;
            }
        }
    }
    
    private void turningLeft()
    {
        FacingDirection direction = null;
        if (directionFacing == FacingDirection.UP) {
            direction = FacingDirection.LEFT;
        }
        if (directionFacing == FacingDirection.LEFT) {
            direction = FacingDirection.DOWN;
        }
        if (directionFacing == FacingDirection.DOWN) {
            direction = FacingDirection.RIGHT;
        }
        if (directionFacing == FacingDirection.RIGHT) {
            direction = FacingDirection.UP;
        }
        directionFacing = direction;
    }
    
    private void turningRight()
    {
        FacingDirection direction = null;
        if (directionFacing == FacingDirection.UP) {
            direction = FacingDirection.RIGHT;
        }
        if (directionFacing == FacingDirection.LEFT) {
            direction = FacingDirection.UP;
        }
        if (directionFacing == FacingDirection.DOWN) {
            direction = FacingDirection.LEFT;
        }
        if (directionFacing == FacingDirection.RIGHT) {
            direction = FacingDirection.DOWN;
        }
        directionFacing = direction;
    }
    
    private void takingPod()
    {
        FloorMapObject pod = map.getObjectAtLocation(currentLocation);
        if (pod != FloorMapObject.POD) {
            throw new NoPodException(String.format("CAN'T TAKE POD: The location at %s is %s", currentLocation, pod));
        } else {
            carryingPod = true;
        }
    }
    
    private void droppingPod()
    {
        FloorMapObject dropZone = map.getObjectAtLocation(currentLocation);
        if (dropZone != FloorMapObject.DROP_ZONE) {
            throw new IllegalDropZoneException(String.format("NOT A DROP ZONE: The location at %s is %s", currentLocation, dropZone));
        } else {
            if (carryingPod == false) {
                throw new IllegalMoveException(String.format("KIVA IS NOT CARRYING A POD: The location at %s is %s", currentLocation, dropZone));
            } else {
                successfullyDropped = true;
                carryingPod = false;
            }
        }
    }
}
