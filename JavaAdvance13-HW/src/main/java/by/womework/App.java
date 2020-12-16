package by.womework;

import java.io.IOException;
import java.sql.SQLException;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class App extends Application {
	Button buttonOk = new Button("Confirm");
	Label labelLogin = new Label("Login");
	Label labelPassword = new Label("Password");
	TextField loginField = new TextField();
	PasswordField passwordField = new PasswordField();
	
	@Override
	public void start(Stage primaryStage) {
		try {
			GridPane root = new GridPane();
			root.setAlignment(Pos.CENTER);
			root.setVgap(10);
			root.setHgap(10);
			root.setPadding(new Insets(25,25,25,25));
			root.add(labelLogin, 0, 0);
			root.add(loginField, 1, 0);			
			root.add(labelPassword, 0, 1);
			root.add(passwordField, 1, 1);
			
			HBox hBox = new HBox();
			hBox.setAlignment(Pos.CENTER_RIGHT);
			hBox.getChildren().add(buttonOk);
			root.add(hBox, 1, 2);				
			
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	        primaryStage.setTitle("Authentication");
			primaryStage.setScene(scene);
			primaryStage.show();
			
			buttonOk.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent event) {
					boolean success = false;
					try {
						Class.forName("com.mysql.jdbc.Driver").newInstance();
					} catch (Exception e) {		
						Alert alert = new Alert(AlertType.ERROR, "Error Driver load");
						alert.showAndWait();
					}	
					
					DataBase database = new DataBase();
				    try {
						if (database.getConnection()) {
							success = database.checkUser(loginField.getText(), passwordField.getText());			
							Alert alert = new Alert(AlertType.INFORMATION, success ? "Success" : "Failed");
							alert.showAndWait();				    			
						} else {
							Alert alert = new Alert(AlertType.ERROR, "Error to Connect to database");
							alert.showAndWait();
						}
					} catch (IOException | SQLException e) {
						Alert alert = new Alert(AlertType.ERROR, "Error to Connect to database");
						alert.showAndWait();
					}									
				}
			});
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
