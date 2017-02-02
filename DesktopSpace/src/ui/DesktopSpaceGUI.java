package ui;

import http.APODRequest;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class DesktopSpaceGUI extends Application {

    Stage window;
    Button button;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        APODRequest request = new APODRequest();
        String imageURL = request.getImageURL();
        
        Image image = new Image(imageURL);
         
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        System.out.println(image.getWidth());
        System.out.println(image.getHeight());
        
        Group root = new Group();
        Scene scene = new Scene(root);
        HBox box = new HBox();
        box.getChildren().add(imageView);
        root.getChildren().add(box);

        stage.setTitle("ImageView");
        stage.initStyle(StageStyle.UNDECORATED);
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getBounds();

        //set Stage boundaries to visible bounds of the main screen
        stage.setX(primaryScreenBounds.getMinX());
        stage.setY(primaryScreenBounds.getMinY());
        stage.setWidth(primaryScreenBounds.getWidth());
        stage.setHeight(primaryScreenBounds.getHeight());
        stage.setScene(scene); 
        stage.show(); 
    }
    
    private Rectangle2D calculateImageBorder(int imageWidth, int imageHeight, int screenWidth, int screenHeight){
    	
		return null;
    	
    }


}