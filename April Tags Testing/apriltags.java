import java.lang.annotation.Target;

public class apriltags {
    public static AprilTagFieldLayout aprilTagFieldLayout = new ApriltagFieldLayout("2023-chargedup.json");//load map field
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
    double skew = target.getSkew();  //Get skew of target
    Transform3d pose = target.getCameraToTarget(); //Tells you info to go to a target
    int targetID = target.getFiducialId(); //Get id of target
    double distanceToTarget = PhotonUtils.getDistanceToPose(robotPose, targetPose); //get distance to target
    Rotation2d targetYaw = PhotonUtils.getYawToPose(robotPose, targetPose); //get yaw difference between target and robot pose
    AprilTagFieldLayout aprilTagFieldLayout = new ApriltagFieldLayout(AprilTagFieldLayout.loadFromResource(AprilTagFields.k2023ChargedUp.m_resourceFile));//load map field

}
}