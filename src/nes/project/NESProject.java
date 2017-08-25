/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nes.project;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

/**
 *
 * @author lain
 */
public class NESProject extends Application {
    
    File selectedFile;
    Button fileSelectorButton;
    VBox romHolderBox=new VBox();
    ROMObject currentROM;
    ROMCore myROMCore=new ROMCore();
    Label ROMPathLabel=new Label();
    
    private String hashConverter(byte[] hashBytes)
    {
        StringBuilder sb=new StringBuilder();
        for(byte b : hashBytes)
        {
            int newB=(int)b+128;
            sb.append(Integer.toHexString(newB));
        }
        return sb.toString();
    }
    
    @Override
    public void start(Stage primaryStage) {
        ScrollPane romHolder=new ScrollPane();
        romHolder.setContent(romHolderBox);
        VBox root = new VBox();
        HBox top = new HBox();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select ROM");
        fileChooser.getExtensionFilters().addAll(
            new ExtensionFilter("NES ROM ", "*.nes"),
            new ExtensionFilter("All Files", "*.*"));
        fileSelectorButton=new Button("Select ROM");
        fileSelectorButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                selectedFile = fileChooser.showOpenDialog(primaryStage);
                MessageDigest md;
                try 
                {
                    md = MessageDigest.getInstance("MD5");
                    try (InputStream is = new FileInputStream(selectedFile))
                    {
                        DigestInputStream dis = new DigestInputStream(is, md);
                        byte[] buffer = new byte[8192];
                        try
                        {
                            while (dis.read(buffer) != -1);
                        }
                        finally
                        {
                            dis.close();
                        }
                    } 
                    catch (IOException ex) 
                    {
                        Logger.getLogger(NESProject.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    byte[] digest = md.digest();
                    System.err.println(hashConverter(digest));
                    currentROM=myROMCore.getRightRom(hashConverter(digest));
                    System.err.println(currentROM.getTable());
                    if(!currentROM.getTable().equals("BAD"))
                    {
                        ROMPathLabel.setText(selectedFile.getAbsolutePath());
                        System.out.println("Runnin");
                        for(ROMIndex r : currentROM.getROMIndexs())
                        {
                            TextField t=new TextField();
                            t.setText(r.originalText);
                            t.textProperty().addListener((observable, oldValue, newValue) -> {
                                if(newValue.length()>r.getOriginalText().length())
                                {
                                    t.setText(oldValue);
                                }
                                else if(newValue.length()<r.getOriginalText().length())
                                {
                                    t.setStyle("-fx-text-fill: red");
                                }
                                else
                                {
                                    t.setStyle("-fx-text-fill: black");
                                }
                                for(char c : newValue.toCharArray())
                                {
                                    if(currentROM.getTable().indexOf(c)==-1)
                                    {
                                        t.setText(oldValue);
                                    }
                                }
                                if(t.getText().equals(newValue))
                                {
                                    if(!newValue.equals(r.originalText))
                                    {
                                        r.setChanged(true);
                                    }
                                    else
                                    {
                                        r.setChanged(false);
                                    }
                                    r.setNewText(newValue);
                                }
                            });
                            romHolderBox.getChildren().add(t);
                        }
                    }
                }
                catch (NoSuchAlgorithmException ex)
                {
                    Logger.getLogger(NESProject.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        Button exportRomButton=new Button("Save ROM");
        exportRomButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                try {
                    byte[] data=Files.readAllBytes(selectedFile.toPath());
                    int currentlyUsing=-1;
                    for(int i=0; i<data.length; i++)
                    {
                        for(int currentROMIndex_i=0;currentROMIndex_i<currentROM.getROMIndexs().length; currentROMIndex_i++)
                        {
                            if(currentROM.getROMIndexs()[currentROMIndex_i].isChanged()==true&&i==currentROM.getROMIndexs()[currentROMIndex_i].getHexLocation())
                            {
                                System.err.println("hello");
                                currentlyUsing=currentROMIndex_i;
                            }
                            if(currentlyUsing!=-1)
                            {
                                data[i]=(byte)currentROM.getTable().indexOf(currentROM.getROMIndexs()[currentlyUsing].getNewText().charAt(i-currentROM.getROMIndexs()[currentlyUsing].getHexLocation()));
                                System.err.println(data[i]);
                                if(i==currentROM.getROMIndexs()[currentlyUsing].getHexEnd())
                                {
                                    currentlyUsing=-1;
                                }
                                break;
                            }
                        }
                    }
                    Path file = Paths.get(selectedFile.getCanonicalPath().substring(0,selectedFile.getCanonicalPath().lastIndexOf('.'))+"-modified.nes");
                    Files.write(file, data);
                    //Path output=Path.get(new Path )
                } catch (IOException ex) {
                    Logger.getLogger(NESProject.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        });
        
        top.getChildren().addAll(ROMPathLabel,fileSelectorButton);
        root.getChildren().addAll(top,romHolder,exportRomButton);
        Scene scene = new Scene(root, 200, 200);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
