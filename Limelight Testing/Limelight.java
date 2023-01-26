import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import java.lang.annotation.Target;

private static class Limelight {
    private Limelight_Getters(NetworkTableEntry tx, NetworkTableEntry ta) {
        NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight"); // New network table instance, and reading in the data table from limelight.
        this.tx = tx; // Horizontal offset from crosshair to the target
        this.ta = ta; // Target area

    } 
}

private static class Photongetters {
    private static PhotonCamera camera = new PhotonCamera ("Microsoft_LifeCam_HD-3000"); //network table that photonvision sends info over
    private static Transform3d robotToCam = new Transform3d(new Translation3d(0.5, 0.0, 0.5), new Rotation3d(0,0,0)); //Translation is for how much forward, left, and up from center the camera is
    private static ArrayList<Pair<PhotonCamera, Transform3d>> camList = new ArrayList<Pair<PhotonCamera, Transform3d>>();

    private enum Dataddy{
        x("tx"),
        y("ty"),
        Area("ta");
        
        
        private final String str;

        Dataddy(String str) {
            this.str = str;
        }    
    }
    

    
    private double getDouble(Data val) { // Data val just represents the values in the networking table API (tx, ty, etc)
        return table.getEntry(val).getDouble(0.0); // Get the value based off the enum DATA (0.0 is how you read it in networking tables)
    }

    private static double getX() {
        tx = getDouble(Dataddy.x);
        return tx;
    }

    private static double getY() {
        ty = getDouble(Dataddy.y);
        return ty;
    }
     
    private static double getArea() {
        Area = getDouble(Dataddy.Area);
        return area;
    }
    
    private static void main(String[] args) {
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