package utilities;

public class ReusableMethods {
    public static void bekleMethodu(int saniye){
        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {

        }
    }
}
