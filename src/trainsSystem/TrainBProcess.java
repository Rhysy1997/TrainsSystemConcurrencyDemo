package trainsSystem;


public class TrainBProcess extends Thread {
    // Note This process is used to emulate a train as it proceeds around the track
    String trainName;
    TrainTrack theTrack;
    //initialise (constructor)   
    public TrainBProcess(String trainName, TrainTrack theTrack) {
        this.trainName = trainName;
        this.theTrack = theTrack;
    }

    @Override
    public void run() {   // start train Process
        // wait for clearance before moving on to the track
        theTrack.trainB_MoveOnToTrack(trainName); // move on to track B
        int circuitCount = 0;
        
        while (circuitCount < 5) { // keep cycling the B track loop 
        	
            theTrack.trainB_MoveAroundToSharedTrack1(trainName); // move around B loop
            theTrack.trainB_MoveAlongSharedTrack1(trainName); // move along shared track
            theTrack.trainB_MoveAroundToSharedTrack2(trainName); // move around A loop
            theTrack.trainB_MoveAlongSharedTrack2(trainName); // move along shared track
            theTrack.trainB_MoveAroundToExit(trainName); // move around to exit
            circuitCount++;
            
        }
        
        theTrack.trainB_MoveOffTrack(trainName); // move off the track
        
    } // end run    

}
