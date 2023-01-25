import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import java.lang.annotation.Target;

public static class Limelight {
    public Limelight_Getters(NetworkTableEntry tx, NetworkTableEntry ta) {
        NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight"); // New network table instance, and reading in the data table from limelight.
        this.tx = tx; // Horizontal offset from crosshair to the target
        this.ta = ta; // Target area

    } 
}

public static class Photongetters {
    public static PhotonCamera camera = new PhotonCamera ("Microsoft_LifeCam_HD-3000"); //network table that photonvision sends info over
    public static Transform3d robotToCam = new Transform3d(new Translation3d(0.5, 0.0, 0.5), new Rotation3d(0,0,0)); //Translation is for how much forward, left, and up from center the camera is
    public static ArrayList<Pair<PhotonCamera, Transform3d>> camList = new ArrayList<Pair<PhotonCamera, Transform3d>>();

    public enum Dataddy{
        x("tx"),
        y("ty"),
        Area("ta");
        
        
        public final String str;

        Dataddy(String str) {
            this.str = str;
        }    
    }
    

    
    private double getDouble(Data val) { // Data val just represents the values in the networking table API (tx, ty, etc)
        return table.getEntry(val).getDouble(0.0); // Get the value based off the enum DATA (0.0 is how you read it in networking tables)
    }

    public static double getX() {
        tx = getDouble(Dataddy.x);
        return tx;
    }

    public static double getY() {
        ty = getDouble(Dataddy.y);
        return ty;
    }
     
    public static double getArea() {
        Area = getDouble(Dataddy.Area);
        return area;
    }
    
    public static void main(String[] args) {
        camList.add(new Pair<PhotonCamera, Transform3d>(camera, robotToCam));
        RobotPoseEstimator robotPoseEstimator = new RobotPoseEstimator(aprilTagFieldLayout, PoseStrategy.CLOSEST_TO_REFERENCE_POSE, camList);
        PhotonPipelineResult result = camera.getLatestResult();{ //run this code in perodic (every 20 ms)
        if (result.hasTargets()) {
            List<PhotonTrackedTarget> targets = result.getTargets(); //if else statement for code above
        }
        target_x = getX();
        target_y = getY();
        target_area = getArea();
        }
    }  
}