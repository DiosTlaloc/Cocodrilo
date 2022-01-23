
/**
 * Write a description of KivaConstructorTest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.Point;

public class KivaConstructorTest {
    String defaultLayout = "" 
                            + "-------------\n"
                            + "        P   *\n"
                            + "   **       *\n"
                            + "   **       *\n"
                            + "  K       D *\n"
                            + " * * * * * **\n"
                            + "-------------\n";
    FloorMap defaultMap = new FloorMap(defaultLayout);
    
    public void testSingleArgumentConstructor()
    {
        // GIVEN
        // The default map we define earlier
        
        // WHEN
        // We create a Kiva with the single argument constructor
        Kiva kiva = new Kiva(defaultMap);
        
        //THEN
        //initial kiva location is (2, 4)
        Point initialLocation = kiva.getCurrentLocation();
        Point expectedLocation = new Point(2, 4);
        if (sameLocation(initialLocation, expectedLocation)) {
            System.out.println("testSingleArgumentConstructor SUCCESS");
        } else {
            System.out.println(String.format("testSingleArgumentConstructor FAIL: %s != (2, 4)!", initialLocation ));
        }
    }
    
    public void testTwoArgumentConstructor()
    {
        Point location = new Point(5, 6);
        Kiva kiva = new Kiva(defaultMap, location);
        
        Point initialLocation = kiva.getCurrentLocation();
        Point expectedLocation = location;
        if (sameLocation(initialLocation, expectedLocation)) {
            System.out.println("testTwoArgumentConstructor SUCCESS");
        } else {
            System.out.println(String.format("testTwoArgumentConstructor FAIL: %s != (2, 4)!", initialLocation ));
        }
    }
    
    public boolean sameLocation(Point a, Point b) 
    {
        return a.getX() == b.getX() && a.getY() == b.getY();
    }

}
