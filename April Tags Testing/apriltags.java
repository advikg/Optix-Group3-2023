import java.lang.annotation.Target;

public class apriltags {
    PhotonCamera camera = new PhotonCamera ("Microsoft_LifeCam_HD-3000"); //network table that photonvision sends info over
    PhotonPipelineResult result = camera.getLatestResult(); //run this code in perodic (every 20 ms)
    boolean hasTargets = result.hasTargets();{ //check if there's a target in the result variable
    if (hasTargets) {
        List<PhotonTrackedTarget> targets = result.getTargets(); //if else statement for code above
        var target = result.getBestTarget();
    } }
    
    //THE FOLLOWING CODE IS COPY PASTED STUFF
  /*  AprilTagFieldLayout aprilTagFieldLayout = new ApriltagFieldLayout(AprilTagFieldLayout.loadFromResource(AprilTagFields.k2022RapidReact.m_resourceFile)); /*
resource file should be edited to work with game, also where is the resource file?*/
//Forward Camera
//cam = new PhotonCamera("testCamera"); // can we use existing camera?
//Transform3d robotToCam = new Transform3d(new Translation3d(0.5, 0.0, 0.5), new Rotation3d(0,0,0)); /*Cam mounted facing forward, half a meter forward of center, 
//half a meter up from center.*/
// ... Add other cameras here

// Assemble the list of cameras & mount locations
//var camList = new ArrayList<Pair<PhotonCamera, Transform3d>>();
//camList.add(new Pair<PhotonCamera, Transform3d>(cam, robotToCam));
//RobotPoseEstimator robotPoseEstimator = new RobotPoseEstimator(aprilTagFieldLayout, PoseStrategy.CLOSEST_TO_REFERENCE_POSE, camList);

}


