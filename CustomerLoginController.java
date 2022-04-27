package JavaFinalProject;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CustomerLoginController {

    @FXML
    private Button adminLoginButton;

    @FXML
    private Button loginButton;

    @FXML
    private Label passwordLabel;

    @FXML
    private TextField passwordTextBox;

    @FXML
    private Button signupButton;

    @FXML
    private Label usernameLabel;

    @FXML
    private TextField usernameTextBox;
    
    @FXML
    public void changeSceneToAdminLogin(ActionEvent e) throws IOException {
    	
	
    	
    	FXMLLoader loader = new FXMLLoader();
    	// specify the file location for the FXML file for the next window
    	loader.setLocation(getClass().getResource("AdminLogin.fxml"));
    	// load the UI for the next window
    	Parent parent = loader.load();
    	// set the scene
    	Scene scene = new Scene(parent);
    	// access the controller class for the next window via the FXML loader
    	//AdminSearchController controller = loader.getController();
    	// call the method in the controller class for the next window
    	// so that the data can be passed
    	//controller.initData();

    	// get the current stage, using the ActionEvent object
    	Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
    	// change the title
    	stage.setTitle("Admin Login");
    	// set the new scene to the stage
    	stage.setScene(scene);
    	// show the stage
    	stage.show();
    }

	
    public void changeSceneToSignup(ActionEvent e) throws IOException {
    	
	
    	
    	FXMLLoader loader = new FXMLLoader();
    	// specify the file location for the FXML file for the next window
    	loader.setLocation(getClass().getResource("CustomerSignup.fxml"));
    	// load the UI for the next window
    	Parent parent = loader.load();
    	// set the scene
    	Scene scene = new Scene(parent);
    	// access the controller class for the next window via the FXML loader
    	//AdminSearchController controller = loader.getController();
    	// call the method in the controller class for the next window
    	// so that the data can be passed
    	//controller.initData();

    	// get the current stage, using the ActionEvent object
    	Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
    	// change the title
    	stage.setTitle("Signup");
    	// set the new scene to the stage
    	stage.setScene(scene);
    	// show the stage
    	stage.show();
    }
    public void changeSceneToCustomerSearch(ActionEvent e) throws IOException {
    	
	
    	
    	FXMLLoader loader = new FXMLLoader();
    	// specify the file location for the FXML file for the next window
    	loader.setLocation(getClass().getResource("CustomerSearch.fxml"));
    	// load the UI for the next window
    	Parent parent = loader.load();
    	// set the scene
    	Scene scene = new Scene(parent);
    	// access the controller class for the next window via the FXML loader
    	//AdminSearchController controller = loader.getController();
    	// call the method in the controller class for the next window
    	// so that the data can be passed
    	//controller.initData();

    	// get the current stage, using the ActionEvent object
    	Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
    	// change the title
    	stage.setTitle("Search");
    	// set the new scene to the stage
    	stage.setScene(scene);
    	// show the stage
    	stage.show();
    }
}
