public static class PhotonGetters {

    private enum Data{
        x("tx"),
        y("ty"),
        Area("ta");
        
        
        private final String str;

        Data(String str) {
            this.str = str;
        }    
    }
    

    private static double getDouble(Data val) { // Data val just represents the values in the networking table API (tx, ty, etc)
        return table.getEntry(val).getDouble(0.0); // Get the value based off the enum DATA (0.0 is how you read it in networking tables)
    }

    private static double getX() {
        tx = getDouble(Data.x);
        return tx;
    }

    private static double getY() {
        ty = getDouble(Data.y);
        return ty;
    }
     
    private static double getArea() {
        Area = getDouble(Data.Area);
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