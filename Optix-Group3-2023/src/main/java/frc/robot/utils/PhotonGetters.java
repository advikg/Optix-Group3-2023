package frc.robot.utils;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class PhotonGetters {
    
    static NetworkTable table = NetworkTableInstance.getDefault().getTable("photonvision"); // New network table instance, and reading in the data table from limelight.
    
    public enum Data{
        x("tx"),
        y("ty"),
        area("ta");
        
        
        public final String str;

        Data(String str) {
            this.str = str;
        }    
    }
    

    private static double getDouble(Data val) { // Data val just represents the values in the networking table API (tx, ty, etc)
        return table.getEntry(val.str).getDouble(0.0); // Get the value based off the enum DATA (0.0 is how you read it in networking tables)
    }

    private static double getX(double tx) {
        tx = getDouble(Data.x);
        return tx;
    }

    private static double getY(double ty) {
        ty = getDouble(Data.y);
        return ty;
    }
     
    private static double getArea(double area) {
        area = getDouble(Data.area);
        return area;
    }
}