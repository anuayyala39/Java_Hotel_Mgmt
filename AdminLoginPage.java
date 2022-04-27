package JavaFinalProject;
	import javafx.stage.Stage;
	import javafx.application.Application;
	import javafx.stage.Stage;
	import javafx.event.ActionEvent;
	import javafx.event.EventHandler;
	import javafx.fxml.FXMLLoader;
	import javafx.scene.Parent;
	import javafx.scene.Scene;
	import javafx.scene.control.Button;
	import javafx.scene.control.Label;
	import javafx.scene.control.TextField;
	import javafx.scene.layout.GridPane;
	import javafx.scene.layout.HBox;
	import javafx.scene.layout.StackPane;
	import javafx.scene.layout.VBox;

	import java.io.IOException;
	import java.sql.SQLException;
	public class AdminLoginPage extends javafx.application.Application{


		@Override
		
		public void start(Stage primaryStage) {
			try {
				// load the fxml file to define the UI
				Parent parent = FXMLLoader.load(getClass().getResource("AdminLogin.fxml"));
				// establish the scene
				Scene scene = new Scene(parent);
				// set the scene to stage
				primaryStage.setScene(scene);
				
			} catch (IOException e) {
				// Print the error message to console
				System.out.print(e.getMessage());
			}
			// set the title of the window
					primaryStage.setTitle(" Admin Login");
					
					// show the stage
					primaryStage.show();
		}

		public static void main(String[] args) {
			launch(args);
		}
	}

	




