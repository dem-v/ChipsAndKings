/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chipsandkings;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import org.thehecklers.dialogfx.DialogFX;

/**
 *
 * @author v
 */
public class ChipsAndKings extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        MainGameboard.main(new String[4]);
        try {
            PrepareSets();
        } catch (IOException ex) {
            Logger.getLogger(ChipsAndKings.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    
    /*public class InitSetter {*/
    
    public void PrepareSets() throws IOException{
        /*switch (ChooseFirstPlayerColor()) {
            case 1:

                break;
            default:

        }*/
        ChooseFirstPlayerColor();
        ImageIcon kb = new ImageIcon(getClass().getResource("/chipsandkings/images/_kb.png"));
        kb = new ImageIcon(kb.getImage().getScaledInstance(59, 59,  BufferedImage.SCALE_SMOOTH)); // scale it the smooth way  
        //kb.getImage().flush();
        
        ImageIcon pb = new ImageIcon(getClass().getResource("/chipsandkings/images/_pb.png"));
        pb = new ImageIcon(pb.getImage().getScaledInstance(59, 59,  BufferedImage.SCALE_SMOOTH)); // scale it the smooth way  
        //pb = new ImageIcon(newimg2);
        //pb.getImage().flush();
        
        ImageIcon kw = new ImageIcon(getClass().getResource("/chipsandkings/images/_kw.png"));
        kw = new ImageIcon(kw.getImage().getScaledInstance(59, 59,  BufferedImage.SCALE_SMOOTH)); // scale it the smooth way  
        //kw = new ImageIcon(newimg2);
        //kw.getImage().flush();
        
        ImageIcon pw = new ImageIcon(getClass().getResource("/chipsandkings/images/_pw.png"));
        pw = new ImageIcon(pw.getImage().getScaledInstance(59, 59,  BufferedImage.SCALE_SMOOTH)); // scale it the smooth way  
        //pw = new ImageIcon(newimg2);
        //pw.getImage().flush();
        
        new MainGameboard().setInitIcons(pw, pb, kw, kb);
    }
    
    public int ChooseFirstPlayerColor(){
        int a = (int)Math.round(Math.random());
        DialogFX dialog = new DialogFX();
        dialog.setTitleText("Player1 color is: ");
        String msg = "";
        switch(a){
            case 1: 
                msg = "White";
                break;
            default:
                msg = "White";
        }
        dialog.setMessage(msg);
        dialog.showDialog();
        return a; 
    }
    
    
}
