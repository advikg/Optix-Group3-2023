import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class Limelight {
    public Limelight_Getters(NetworkTableEntry tx, NetworkTableEntry ta) {
        NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight"); // New network table instance, and reading in the data table from limelight.
        this.tx = tx; // Horizontal offset from crosshair to the target
        this.ta = ta; // Target area

    } 
}