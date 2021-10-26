package TracksRetrofit;

public class Main {
        public static void main(String[] args) {
            Controller controller = new Controller();
            controller.start();
            //controller.getSingleTrack("4");
            //controller.deleteTrack("2");
            //controller.postNewTrack("4","Aitana", "Mon Amour");
            controller.putNewTrack("4","Aitana", "Mon Amour");
            controller.getAllTracks();
        }
    }
