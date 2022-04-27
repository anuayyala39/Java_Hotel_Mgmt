package JavaFinalProject;
import java.io.IOException;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.*;

public class AdminLoginController {

    @FXML
    private Label passwordLabel;

    @FXML
    private TextField passwordtextField;

    @FXML
    private Button submitButton;

    @FXML
    private Label usernameLabel;

    @FXML
    private TextField usernameTextField;

	    /**
	     * Event handler for the "Submit" Button 
	     * It will redirect to next page Admin Search
	     * @throws IOException 
	     * @throws SQLException 
	     */
    @FXML
	    public void changeSceneToAdminSearch(ActionEvent e) throws IOException {
	    	
    	HotelManagementAdminDAOImpl jdbc = new HotelManagementAdminDAOImpl();
	    	AdminLoginDetails kb = new AdminLoginDetails(usernameTextField.getText(),passwordtextField.getText());
	       
			jdbc.selectRecord(kb);
			
	    	// prepare the string to be sent to the next window
	    	//String item = "";
	   
	    	
	    	
	    	FXMLLoader loader = new FXMLLoader();
	    	// specify the file location for the FXML file for the next window
	    	loader.setLocation(getClass().getResource("AdminSearch.fxml"));
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
	    	stage.setTitle("Admin Search");
	    	// set the new scene to the stage
	    	stage.setScene(scene);
	    	// show the stage
	    	stage.show();
	    }
	
		
    }
