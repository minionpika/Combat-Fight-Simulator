
package imagemove1;
 

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class FreeFlight extends Application {
    static double bx=177,by=118;
    @Override
    public void start(Stage primaryStage) {    
        
        Text fps1=new Text(591,30,"Free Flight");
        fps1.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
        /*Media musicfile= new Media("file:///Music");
        MediaPlayer mediaplayer = new MediaPlayer(musicfile);*/
        
        AnchorPane root = new AnchorPane();
        
        
        Image I=new Image("hills 9.jpg");
        Image I2=new Image("hills 10.png");
        ImageView iv00= new ImageView(I);
        ImageView iv11= new ImageView(I2); 
        
        Button Back = new Button();
        Back.setText("Back");
        
        iv00.setX(0);
        iv11.setX(1400);
        iv00.setY(0);
        iv11.setY(0);
        
        new AnimationTimer()
        {
            double posX1 = iv00.getX() , posX2 = iv11.getX() ;
            @Override
            public void handle(long now)
            {
                iv00.setX(posX1);
                iv11.setX(posX2);
                
                posX1-=4 ;
                posX2-=4;
                
                if(posX1==-1400) posX1=1400 ;
                if(posX2==-1400) posX2 =1400 ;
            }
        }.start();
        

        
        Scene scene = new Scene(root, 1400, 700, Color.WHITE);
        root.getChildren().addAll(iv00,iv11);
        Back.setOnAction(e-> {
            System.out.println("kikiki");
            System.exit(0);
        });
        
        Back.setAlignment(Pos.BOTTOM_RIGHT);
    
        Image iv1 = new Image("pilotplane1.png", 280, 220, false, true);
        ImageView iv2 = new ImageView(iv1);
        iv2.setX(0);
        iv2.setY(0);
        root.getChildren().addAll(iv2,Back,fps1);  
     
        scene.setOnMouseClicked(event->{
             System.out.println(event.getX()+" "+event.getY());
        });
    
    
    scene.setOnKeyPressed(e->{
        
        if( null!=e.getCode())
            switch (e.getCode()) {
                case RIGHT:{
                    double a=iv2.getX();
                    if(a==1400)
                    {
                        iv2.setX(0);
                        bx=177;
                        by=118;
                    }
                    
                    else
                    {
                        iv2.setX(a+5);
                        bx=a+177+5;
                    }           break;
                }
                case LEFT:{
                    double a=iv2.getX();
                    if(a>=0)
                    {
                        iv2.setX(a-5);
                        bx=a+177-5;
                    }           break;
                    }
                case UP:{
                    double a=iv2.getY();
                    if(a>=0)
                    {
                        iv2.setY(a-5);
                        by=a+118-5;
                    }           break;
                    }
                case DOWN:{
                    double a=iv2.getY();
                    if(a==800) 
                    {
                        iv2.setY(0); 
                        by=118; 
                    }
                    else { 
                        iv2.setY(a+5); by=a+118+5; 
                    }
                        break;
                    }
                        
                default:
                    break;
            }
                 
    });
    
    Media music2=new Media("file:///F:/COMBAT/CombatSound/freeflight.mp3");
    MediaPlayer m2=new MediaPlayer(music2);
    m2.setAutoPlay(true); 
    
    primaryStage.setScene(scene);
    primaryStage.show();
}

}
