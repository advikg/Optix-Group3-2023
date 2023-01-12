import java.lang.annotation.Target;

public class apriltags {
    PhotonCamera camera = new PhotonCamera ("Microsoft_LifeCam_HD-3000"); //network table that photonvision sends info over
    PhotonPipelineResult result = camera.getLatestResult(); //run this code in perodic (every 20 ms)
    boolean hasTargets = result.hasTargets(); //check if there's a target in the result variable
    if (hasTargets) {
        List<PhotonTrackedTarget> targets = result.getTargets(); //if else statement for code above
        var target = result.getBestTarget();
    }
}
