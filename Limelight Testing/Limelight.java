import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import java.lang.annotation.Target;

public class Limelight {
    public Limelight_Getters(NetworkTableEntry tx, NetworkTableEntry ta) {
        NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight"); // New network table instance, and reading in the data table from limelight.
        this.tx = tx; // Horizontal offset from crosshair to the target
        this.ta = ta; // Target area

    } 
}

public class Photongetters {
    public static PhotonCamera camera = new PhotonCamera ("Microsoft_LifeCam_HD-3000"); //network table that photonvision sends info over
    public static Transform3d robotToCam = new Transform3d(new Translation3d(0.5, 0.0, 0.5), new Rotation3d(0,0,0)); //Translation is for how much forward, left, and up from center the camera is
    public static ArrayList<Pair<PhotonCamera, Transform3d>> camList = new ArrayList<Pair<PhotonCamera, Transform3d>>();
    public static void main(String[] args) {
        camList.add(new Pair<PhotonCamera, Transform3d>(camera, robotToCam));
        RobotPoseEstimator robotPoseEstimator = new RobotPoseEstimator(aprilTagFieldLayout, PoseStrategy.CLOSEST_TO_REFERENCE_POSE, camList);
        PhotonPipelineResult result = camera.getLatestResult();{ //run this code in perodic (every 20 ms)
        if (result.hasTargets()) {
            List<PhotonTrackedTarget> targets = result.getTargets(); //if else statement for code above
        }
        double target_x = target.getYaw(); // Get the yaw position of target
        double target_y = target.getPitch(); //Get pitch of target
        double area = target.getArea(); //Get area of target
        int targetID = target.getFiducialId();
    }
    }  
}