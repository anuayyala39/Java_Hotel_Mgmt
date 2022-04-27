package JavaFinalProject;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.stage.Stage;

public class AddNewReservationController {

    @FXML
    private Button addRecordButton;

    @FXML
    private Button backButton;

    @FXML
    private Label bookingEndDateLabel;

    @FXML
    private Label bookingStartDateLabel;

    @FXML
    private TextField endDateTextBox;

    @FXML
    private Label firstNameLabel;

    @FXML
    private TextField firstNameTextBox;

    @FXML
    private Label hotelIDLabel;

    @FXML
    private TextField hotelIDTextBox;

    @FXML
    private Button hotelNameButton;

    @FXML
    private Label hotelNameLabel;

    @FXML
    private TextField hotelNameTextBox;

    @FXML
    private Label lastNameLabel;

    @FXML
    private TextField lastNameTextBox;
    
    @FXML
    private Label priceLabel;

    @FXML
    private TextField priceTextBox;
    @FXML
    private ComboBox<String> roomTypeComboBox;

    @FXML
    private Label roomTypeLabel;


    @FXML
    private TextField startDateTextBox;
    public int Hotelid=0;
    public String Location;
    double   totalPrice = 0;
    
    /**
     *  //method to add items to combo box.
     */
    public void initialize() {
	    	// this items are for configuring the combo box
    	roomTypeComboBox.getItems().addAll(
	    			"Single Occupancy","Double Occupancy");
	    }
    /**
     * Action Listener for the combo box
     */
    public void comboboxListener(ActionEvent e) {
    	//apply discount as selected in combo box and call the setdiscount method.
    	
    	if(roomTypeComboBox.getValue()=="Single Occupancy") {
    		totalPrice=Double.parseDouble(priceTextBox.getText());
    	}
    	else if(roomTypeComboBox.getValue()=="Double Occupancy") {
    		totalPrice=Double.parseDouble(priceTextBox.getText())+50;
    		
    
    }
    	priceTextBox.setText(String.valueOf(totalPrice)); 
		
    }
    
    
    public void hotelNameButton(ActionEvent e) {
    	HotelManagementAdminDAOImpl kb = new HotelManagementAdminDAOImpl();
    	ReservationDetails objGetHotel=kb.GetHotelId(hotelNameTextBox.getText());
    	//kb.insertReservation(updateObj);
    	 hotelIDTextBox.setText(String.valueOf(objGetHotel.getHotelId()));
    	 Hotelid=objGetHotel.getHotelId();
    	 Location=objGetHotel.getLocation();
    	
    }

   


    public void addButtonListener(ActionEvent e) throws IOException {
    	HotelManagementAdminDAOImpl kb = new HotelManagementAdminDAOImpl();
    	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

    	ReservationDetails reservationObj = new ReservationDetails();
    	 
    	lastNameTextBox.getText();
    	startDateTextBox.getText();
    	firstNameTextBox.getText();
    	endDateTextBox.getText();
    	
    	Date startDate = null;
    	Date  endDate = null;
		try {
			startDate = formatter.parse(startDateTextBox.getText());
			  endDate = formatter.parse(endDateTextBox.getText());
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	
    	reservationObj.setStartDate(startDate);
    	reservationObj.setEndDate(endDate);
    	reservationObj.setLastName(lastNameTextBox.getText());
    	reservationObj.setfirstName(firstNameTextBox.getText());
    	reservationObj.setLocation(Location);
    	reservationObj.setHotelId(Hotelid);
    	reservationObj.setPrice(totalPrice);
    	reservationObj.setRoomType(roomTypeComboBox.getValue());
    	
    	//getRoomType()
	     //aReservation.getPrice()+"')";
    	boolean b=kb.insertReservation(reservationObj );
    	System.out.println("=="+b);
	    
    	
    	
    	    	 
    	    }
    	    

    /**
     * Move back to the Admin Search scene.
     * @param e
     */
    
    public void startOverButtonListener(ActionEvent e) {
    	// the FXML loader object to load the UI design
    	FXMLLoader loader = new FXMLLoader();
    	// specify the file location
    	loader.setLocation(getClass().getResource("AdminSearch.fxml"));
    	
		// try-catch for possible errors in reading the FXML file.
    	try {
    		// the object representing the root node of the scene; load the UI
    		Parent parent = loader.load();
   	
			// set the scene
			Scene scene = new Scene(parent);
    	   	
	    	// get the current window; i.e. the stage
	    	Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
	    	// change the title of the window
	    	stage.setTitle("Admin Search");
	    	// set the scene for the stage
	    	stage.setScene(scene);
	    	// show the stage
	    	stage.show();
			} catch (IOException e1) {
				
				System.out.print(e1.getMessage());
			}
    }
    



}
