
package imagemove1;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;


public class Blast implements Runnable {
    public Thread t;
    public ImageView Iq;
    public AnchorPane r;
    public double a;
    public double b;
    public Blast(ImageView Iq1,double a1,double b1,AnchorPane root){
        Iq=Iq1;
        a=a1;
        b=b1;
        r=root;
        t=new Thread(this,"thread demo");
        r.getChildren().add(Iq);
        t.start();
    }
   
    @Override
    public void run() {
        
        
      
        try {
            System.out.println("mama");
            
            
            Iq.setX(a);
            Iq.setY(b);
            Thread.sleep(1000);
            Iq.setX(1500);
            Iq.setY(1500);
            
        } catch (InterruptedException ex) {
            Logger.getLogger(Blast.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
}
