import javafx.application.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Worker;
import javafx.scene.Group;
import javafx.scene.Scene; 
import javafx.scene.control.*; 
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.event.ActionEvent; 
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage; 
import javafx.scene.image.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import java.awt.Color;
import java.io.*;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.*;
import javax.swing.JLabel;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import netscape.javascript.JSObject;
public class Reminder {
	static int cm = 1;
	static int cy = 1;
	private static ArrayList<Event> events = new ArrayList<Event>();
	public static void addEvent(Event e) {
		events.add(e);
		e.setFdate(e.getDate());
	}
	public static void compare() {
		Date e1 = new Date();
		for(int i = 0; i < events.size(); i ++) {
			int j = e1.compareTo(events.get(i).getFdate());
			if(j == 0) {
				System.out.println(events.get(i));
				if(events.get(i).getName().equals("Shreemandam")) {
					events.get(i).setCM(cm);
					cm++;
				} else {
					events.get(i).setCY(cy);
					cy++;
				}
			}
		}
	}
	
	public void start(Stage s) {
		s.setTitle("CouponReminder");
		
		GridPane rootNode = new GridPane();
        rootNode.setPadding(new Insets(15));
        rootNode.setHgap(5);
        rootNode.setVgap(5);
        rootNode.setAlignment(Pos.CENTER);
        
        rootNode.add(new Label("Welcome to Coupon Reminder"), 5, 0);
        
        MenuItem item1 = new MenuItem("Add Coupon");
        MenuItem item2 = new MenuItem("Find Coupon");
        
        MenuButton menuButton = new MenuButton("What do you want to do?", null, item1, item2);
        
        rootNode.add(menuButton, 0, 0);
        
        item1.setOnAction(new item1Handler());
        item2.setOnAction(new item2Handler());
        
        Scene scene = new Scene(rootNode, 500, 200);
        s.setScene(scene);
		s.show();
        
	}
	public static void main(String args[])
    { 	
//		Date de = new Date();
//		Date ed = new Date(2020, 1, 23);
//        Event e = new Event("Sriram", "Anniversary", de, ed);
//        addEvent(e);
//        compare();
//        System.out.println(e.getFdate());
		launch(args);
    } 
	class item1Handler implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e) {
			try {
				
			}catch(Exception e1) {
				
			}
		}
		
	}
	
	class item2Handler implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e) {
			try {
				
			}catch(Exception e1) {
				
			}
		}
		
	}
}
