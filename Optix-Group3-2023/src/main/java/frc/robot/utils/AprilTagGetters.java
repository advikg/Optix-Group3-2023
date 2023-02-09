package frc.robot.utils;
import java.io.IOException;
import java.util.ArrayList;

import org.photonvision.PhotonCamera;
import org.photonvision.PhotonPoseEstimator;
import org.photonvision.PhotonPoseEstimator.PoseStrategy;
import org.photonvision.targeting.PhotonPipelineResult;
import org.photonvision.targeting.PhotonTrackedTarget;

import edu.wpi.first.apriltag.AprilTagFieldLayout;
import edu.wpi.first.apriltag.AprilTagFields;
import edu.wpi.first.math.Pair;
import edu.wpi.first.math.geometry.Rotation3d;
import edu.wpi.first.math.geometry.Transform3d;
import edu.wpi.first.math.geometry.Translation3d;

import frc.robot.Constants.*;

/**
 * @author Advik Garg
 * @author Akhil Singamneni
 * 
 * 
 * 
 * 
 * 
 * 
 */


public class AprilTagGetters {
    public void estimatePose(PhotonCamera camera, Transform3d robotToCam, ArrayList<Pair<PhotonCamera, Transform3d>> camList, AprilTagFieldLayout aprilTagFieldLayout) {
        camera.setPipelineIndex(VisionConstants.apriltag_pipeline_index);
        camList.add(new Pair<PhotonCamera, Transform3d>(camera, robotToCam));
        PhotonPoseEstimator robotPoseEstimator = new PhotonPoseEstimator(aprilTagFieldLayout, PoseStrategy.CLOSEST_TO_REFERENCE_POSE, camera, robotToCam);
    }
    public static double[] getAprilTagX(PhotonCamera camera) {
        camera.setPipelineIndex(VisionConstants.apriltag_pipeline_index);
        double target_x = 0.0;
        double target_fiducial_id = 0;
        double[] x_and_id = {target_fiducial_id, target_x};
        PhotonPipelineResult result = camera.getLatestResult(); //run this code in perodic (every 20 ms)
        if (result.hasTargets()) {
            PhotonTrackedTarget target = result.getBestTarget();; //if else statement for 22code above
            target_x = target.getYaw();
            target_fiducial_id = target.getFiducialId();
            x_and_id[0] = target_fiducial_id;
            
            x_and_id[1] = target_x;
        }
        return x_and_id;
    }
    // double target_x = target.getYaw(); // Get the yaw position of target
    // double target_y = target.getPitch(); //Get pitch of target
    // double area = target.getArea(); //Get area of target
    // double skew = target.getSkew();  //Get skew of target
    // Transform3d pose = target.getCameraToTarget(); //Tells you info to go to a target
    // int targetID = target.getFiducialId(); //Get id of target
    // double distanceToTarget = PhotonUtils.getDistanceToPose(robotPose, targetPose); //get distance to target
    // Rotation2d targetYaw = PhotonUtils.getYawToPose(robotPose, targetPose); //get yaw difference between target and robot pose
    }

