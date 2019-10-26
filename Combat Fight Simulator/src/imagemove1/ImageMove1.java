
package imagemove1;
 

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


class EnemyPlane1 
{
    
    public ImageView ii;    
    EnemyPlane1(double x,double y,AnchorPane root,Image II)
    {
        ii=new ImageView(II);
        root.getChildren().add(ii);
        ii.setX(x);
        ii.setY(y);
                    
    }
    public double gettx()
    {
        return ii.getX();
    }
    public double getty()
    {
        return ii.getY();
    }
    public void updatepos()
    {      
        ii.setX(ii.getX()-1);
    }
}


class Bullet extends Circle{
    Bullet(double x,double y,AnchorPane root, double radius,Color color){
        super(x,y,radius,color);
        boolean add = root.getChildren().add(this);
    }
    public double getx()
    {
        return super.getCenterX();
    }
    public double gety()
    {
        return super.getCenterY();
    }
    public void updateCenter(){
        setCenterX(getCenterX()+5);
       
    }
    public void updateCenter1(){
        setCenterX(getCenterX()-5);
    }
}


public class ImageMove1 extends Application {
   
    static double bx=129,by=545,x=0;
    int count=0,count1=0,cc1=1,cc2=1;
    int score=0;
    int c=0;
    
    @Override
    public void start(Stage primaryStage) {
        
        try{
        
                VBox roott = new VBox();
        
                   Text fps=new Text(1170,30,"X");
                   Text fps1=new Text(591,30,"Mission");
        Image image=new Image("1st page.png",1400, 700, false ,true);
        BackgroundImage backgroundImage = new BackgroundImage( image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background background = new Background(backgroundImage);
       
        Button newgame = new Button();   
        Button exit = new Button();
        newgame.setText("\t\t\tNEWGAME\t\t\t");
        exit.setText("\t\t\tEXIT\t\t\t\t\t");
        
        exit.setOnAction(e->{
            System.exit(0);
        });
        
      
        //for the first scene
        
        roott.setBackground(background);
        roott.setAlignment(Pos.CENTER);
        roott.getChildren().addAll(newgame,exit);
       

        
        Scene scene1 = new Scene(roott, 1400, 700);
        
        
        //2nd page button
        VBox root1= new VBox();
        
        Button freeflight = new Button();
        Button mission = new Button();
        Button player = new Button();
        Button settings = new Button();
        Button back = new Button();
        
        
        freeflight.setText("\t\t\tFreeFlight\t\t\t\t");
        mission.setText("\t\t\tMission\t\t\t\t");
        player.setText("\t\t\tPlayer\t\t\t\t");
        settings.setText("\t\t\tSettings\t\t\t\t");
        back.setText("\t\t\tBack\t\t\t\t\t");
        
        freeflight.setOnAction(e-> {
           Media music3=new Media("file:///F:/COMBAT/CombatSound/2ndpage.mp3");
           MediaPlayer m3=new MediaPlayer(music3);
           m3.setAutoPlay(true);   
           m3.setVolume(0.10);
           FreeFlight ob= new FreeFlight();
           ob.start(primaryStage);
           
           
        });
        
        back.setOnAction(e-> {
            
            primaryStage.setScene(scene1);
        });
        
        //2nd scene layout
        
        Image image1=new Image("3rd page.jpg",1400,700,false,true);
        BackgroundImage backgroundImage1 = new BackgroundImage( image1, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background background1 = new Background(backgroundImage1);
        
        
        root1.setBackground(background1);
        root1.setAlignment(Pos.CENTER);
        root1.getChildren().addAll(freeflight, mission, player, settings, back);
        
        Scene scene2 = new Scene(root1, 1400, 700);
          
        
        newgame.setOnAction(e-> {
            
            primaryStage.setScene(scene2);
        });
        
         
        AnchorPane root = new AnchorPane();
         
        Image I=new Image("back1.jpg");
        Image I2=new Image("back2.jpg");
        Image I3= new Image("runway.jpg");
        Image I4= new Image("runway.jpg");
        
        ImageView iv00= new ImageView(I);
        ImageView iv11= new ImageView(I2); 
        ImageView iv12= new ImageView(I3);
        ImageView iv13= new ImageView(I4);
        
        Button Back = new Button();
        Back.setText("Back");
        
        
        iv00.setX(0);
        iv11.setX(1400);
        iv12.setX(0);
        iv13.setX(1400);
        
        iv00.setY(0);
        iv11.setY(0);
        iv12.setY(700-150);
        iv13.setY(700-150);
        new AnimationTimer()
        {
            double posX1 = iv00.getX() , posX2 = iv11.getX() ,posX3 = iv12.getX(), posX4 = iv13.getX();
            
            
            @Override
            public void handle(long now)
            {
                
                //System.out.println(c);
                c++;
                //System.out.println("hihih");
                iv00.setX(posX1);
                iv11.setX(posX2);
                iv12.setX(posX3);
                iv13.setX(posX4);
                
                posX1-=4 ;
                posX2-=4;
                posX3-=4;
                posX4-=4;
                
                if(posX1==-1400) posX1=1400 ;
                if(posX2==-1400) posX2 =1400 ;
                
                
              //  if(posX3==-1400 && count<3) posX3 =1400 ;
              //  if(posX4==-1400&& count<3) posX4 =1400 ;
                
            }
        }.start();
        
     //   System.out.println(c);
        
        fps.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
        fps1.setFont(Font.font("Tahoma", FontWeight.NORMAL, 30));
        
        Scene scene = new Scene(root, 1400, 700, Color.WHITE);
        
        mission.setOnAction(e-> {
            Media music10=new Media("file:///F:/COMBAT/CombatSound/freeflight.mp3");
            MediaPlayer m10=new MediaPlayer(music10);
            m10.setAutoPlay(true);
            primaryStage.setScene(scene);
        });
        
        Back.setOnAction(e-> {
            System.out.println("kikiki");
            primaryStage.setScene(scene2);
        });
        
        Back.setAlignment(Pos.BOTTOM_RIGHT);
        
        
        root.getChildren().addAll(iv00,iv11,iv12, iv13);
       
        Image iv1 = new Image("pilotplane1.png", 250, 220, false, true);
        ImageView iv2 = new ImageView(iv1);
        iv2.setX(0);
        iv2.setY(365);
        root.getChildren().addAll(iv2,Back);  
        
        
        Bullet b1=new Bullet(2000,2000,root,3,Color.BLACK);
        Bullet b2=new Bullet(2000,2000,root,3,Color.BLACK);
        Bullet b3=new Bullet(2000,2000,root,3,Color.BLACK);
        
        scene.setOnMouseClicked(event->{
             System.out.println(event.getX()+" "+event.getY());
        });
        
        
        Bullet []b=new Bullet[100];
        for(int bb=0;bb<100;bb++)
        {
               b[bb]=new Bullet(1500,1500,root,3,Color.BLACK);
               
        }
            
    /*scene.setOnKeyPressed(e->{
        
        if(e.getCode()==KeyCode.RIGHT)
        {
            
            double a=iv2.getX();
            if(a==1400)
            {
                iv2.setX(0);
                bx=113;
                by=94;
            }
            
            else 
            {
                iv2.setX(a+5);
                bx=a+113+5;
            }
        }
        else if(e.getCode()==KeyCode.LEFT)
        {
            double a=iv2.getX();
            if(a>=0)
            {
                iv2.setX(a-5);
                bx=a+113-5;
            }
        }
        else if(e.getCode()==KeyCode.UP)
        {
            double a=iv2.getY();
            if(a>=0)
            {
                iv2.setY(a-5);
                by=a+94-5;
            }
            
            
        }
        else if(e.getCode()==KeyCode.DOWN)
        {
            double a=iv2.getY();
            //if(a==800) {iv2.setY(0); by=94; }
            if(a<=600) { iv2.setY(a+5); by=a+5+94; }
        }
        else if(e.getCode()==KeyCode.ENTER)
        {
            double t1=bx; double t2=by;
            Bullet b=new Bullet(t1,t2,root,5,Color.BLACK);
            Media music=new Media("file:///C:/Users/Susmi/Downloads/gunsound.mp3");
        MediaPlayer m=new MediaPlayer(music);
        m.setAutoPlay(true);
            
            new AnimationTimer() {

            @Override
            public void handle(long now) {
                
                b.updateCenter();
                //double c1=b.getCenterX();
                //double c2=b.getCenterY();
                
            }
        }.start();
           
                
    }
            
    });*/
    root.getChildren().addAll(fps,fps1);
    int j=0,kk=1,i=0;
   
        double c1,c2;
        Image k=new Image("enemy.png",180,75,false,true);
        EnemyPlane1 ee=new EnemyPlane1(2000+kk*(i*5+j)*700,95,root,k);
        EnemyPlane1 ee1=new EnemyPlane1(1800+kk*(i*5+j)*700,295,root,k);
        
        new AnimationTimer()
        {
            @Override
            public void handle(long now)
            {
                ee.updatepos();
                ee1.updatepos();
                b1.updateCenter1();
                b2.updateCenter1();
                fps.setText(String.format("Score : "+"%d",score));
                if(ee.gettx()==800)
                {
                    b1.setCenterX(800);
                    b1.setCenterY(ee.getty()+100);
                }
                if(ee1.gettx()==900)
                {
                    b2.setCenterX(800);
                    b2.setCenterY(ee1.getty()+100);
                }
                if(b2.getCenterX()==iv2.getX()+200  && b2.getCenterY()<=iv2.getY()+73 && b2.getCenterY()>=iv2.getY()+63)
                {
                   // System.exit(0);
                    score=score-10;
                }
                if(b1.getCenterX()==iv2.getX()+200 && b1.getCenterY()<=iv2.getY()+73 && b1.getCenterY()>=iv2.getY()+63 )
                {
                    //System.exit(0);
                    score=score-10;
                }
                /*if(ee.ii.getX()<=iv2.getX()+150 && ee.ii.getX()>=iv2.getX() && ee.ii.getY()+47 >=iv2.getY()+ 47 && ee.ii.getY()<=iv2.getY()+120)
                {
                    System.exit(0);
                }*/
                
                if(score==100)
                {
                    
                }
                for(int m=0;m<count;m++)
                {
                    if((b[m].getCenterX()>=ee.ii.getX()&& b[m].getCenterX()<=ee.ii.getX()+7 )&& b[m].getCenterY()<=ee.ii.getY()+80 && b[m].getCenterY()>=ee.ii.getY()+30)
                    {
                        System.out.println("hello");
                        b[m].setCenterX(1800);
                        ee.ii.setX(1400);
                        ee.ii.setY(525);
                        score=score+10;
                        Media music22=new Media("file:///F:/COMBAT/CombatSound/gunsound.mp3");
                        MediaPlayer m22=new MediaPlayer(music22);
                        m22.setAutoPlay(true); 
                        //cc1=0;
                    
                    
                        //ee.updatepos();
                   
                    }
                    if((b[m].getCenterX()>=ee1.ii.getX()&& b[m].getCenterX()<=ee1.ii.getX()+7 )&& b[m].getCenterY()<=ee1.ii.getY()+80 && b[m].getCenterY()>=ee1.ii.getY()+30)
                    {
                        System.out.println("hello");
                        b[m].setCenterX(1800);
                        ee1.ii.setX(1400);
                        ee1.ii.setY(125);
                        score=score+10;
                        Media music33=new Media("file:///F:/COMBAT/CombatSound/gunsound.mp3");
                        MediaPlayer m33=new MediaPlayer(music33);
                        m33.setAutoPlay(true);
                        //cc2=0;  
                    
                        //ee1.updatepos();
                   
                }
                }
                /*if(cc1==0)
                {
                    ee.ii.setX(1500);
                    ee.ii.setY(525);
                    cc1=0;
                }*/
                if(ee.ii.getX()<-100)
                {
                    ee.ii.setX(1400);
                    ee.ii.setY(225);
                
                }
               /* if(cc2==0)
                {
                    ee1.ii.setX(1600);
                    ee1.ii.setY(225);
                    cc2=0;
                }*/
                if(ee1.ii.getX()<-100)
                {
                    ee1.ii.setX(1400);
                    ee1.ii.setY(435);
                
                }
                scene.setOnKeyPressed((KeyEvent e)->{
        
                if(null!=e.getCode())
                    switch (e.getCode()) {
                        case RIGHT:{
                            double a=iv2.getX();
                            if(a==1400)
                            {
                                
                                iv2.setX(0);
                                bx=129;
                                by=545;
                            }
                            
                            else
                            {
                                iv2.setX(a+5);
                                bx=a+129+5;
                            }                   break;
                            }
                        case LEFT:{
                            double a=iv2.getX();
                            if(a>=0)
                            {
                                iv2.setX(a-5);
                                bx=a+129-5;
                            }                   break;
                            }
                        case UP:{
                            double a=iv2.getY();
                            if(a>=0)
                            {
                                iv2.setY(a-5);
                                by=a+545-365-5;
                            }                   break;
                            }
                        case DOWN:{
                            double a=iv2.getY();
                            if(c>=707){
                            if(a<=600) { iv2.setY(a+5); by=a+5+545-365 ; }
                                break;
                            } break;
                            /*else {
                                iv2.setY(a);
                                break;
                            }*/
                            
                        }
                        case ENTER:
                            
                            b[count].setCenterX(bx);
                            b[count].setCenterY(by);
                            count++;
                            count1++;
                                 Media music=new Media("file:///F:/COMBAT/CombatSound/gunsound.mp3");
                                 MediaPlayer m1=new MediaPlayer(music);
                                 m1.setAutoPlay(true);
                            break;
                        default:
                            break;
                    }
        
            
    });
               for(int m=0;m<count;m++)
                {
                    b[m].updateCenter();
                }
                          
            }
        }.start();

        
    Media music2=new Media("file:///F:/COMBAT/CombatSound/1stpage.mp3");
    MediaPlayer m2=new MediaPlayer(music2);
    m2.setAutoPlay(true); 
   /* Media music3=new Media("file:///C:/Users/User/Downloads/2stpage.mp3");
    MediaPlayer m3=new MediaPlayer(music3);
    m3.setAutoPlay(true);   */
        
    primaryStage.setScene(scene1);
    
    primaryStage.show();
}
        catch (Exception e) { }

            }
    

    public static void main(String[] args) {
        launch(args);
    }
    
}
