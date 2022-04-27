package JavaFinalProject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.unlv.mis768.labwork15.CustomerOrderTable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableRow;

import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.cell.*;
import javafx.stage.Stage;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.*;

	public class SearchByReservationIdController{

	    @FXML
	    private TableColumn<ReservationDetails, Double> amountColumn;

	    @FXML
	    private Button deleteButton;

	    @FXML
	    private Button editButon;

	    @FXML
	    private TableColumn<ReservationDetails, Date> endDateColumn;

	    @FXML
	    private TableColumn<ReservationDetails, Integer> hotelIdColumn;

	    @FXML
	    private TableColumn<ReservationDetails, String> nameColumn;

	    @FXML
	    private TableColumn<ReservationDetails, Integer> reservationIdCoulmn;

	    @FXML
	    private TableColumn<ReservationDetails, Date> startDateColumn;

	    @FXML
	    private TableView<ReservationDetails> tableView;

	    public int rowSelect=0;
	    
	    public ReservationDetails selectedReservation =new ReservationDetails() ;
	    
	    /** For setting up initial values
		 */
	   

		public void initialize() { // set up the columns in the table
			 
			
			reservationIdCoulmn.setCellValueFactory(new PropertyValueFactory<ReservationDetails, Integer>("reservationId"));
			startDateColumn.setCellValueFactory(new PropertyValueFactory<ReservationDetails, Date>("startDate"));
			endDateColumn.setCellValueFactory(new PropertyValueFactory<ReservationDetails, Date>("endDate"));
		     amountColumn.setCellValueFactory(new  PropertyValueFactory<ReservationDetails, Double>("Price"));
			  hotelIdColumn.setCellValueFactory(new PropertyValueFactory<ReservationDetails, Integer>("hotelId"));
			  nameColumn.setCellValueFactory(new  PropertyValueFactory<ReservationDetails, String>("lastName"));
		  }

		public void initData(	List<ReservationDetails> reservationList) {
			tableView.setRowFactory(tv -> {
                TableRow<ReservationDetails> row = new TableRow<>();
                row.setOnMouseClicked(event -> {
                    if (event.getClickCount() == 1 && (! row.isEmpty()) ) {
                    	ReservationDetails rowData = row.getItem();
                    	rowSelect=rowData.getReservationId();
                    	this.selectedReservation=rowData;
                        System.out.println("Double click on: "+rowSelect);
                    }
                });
                return row ;
            });
			tableView.getItems().add(new ReservationDetails(reservationList.get(0).getReservationId(),reservationList.get(0).getLocation(), reservationList.get(0).getStartDate(),reservationList.get(0).getEndDate(),reservationList.get(0).getRoomType(),reservationList.get(0).getPrice(),reservationList.get(0).getHotelId(),reservationList.get(0).getLastName()));
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
	    
	    public void deleteButtonListener() {
	    	HotelManagementAdminDAOImpl kb = new HotelManagementAdminDAOImpl();
	    	System.out.println(rowSelect);
	    	kb.deleteReservation(rowSelect );
	     	HotelManagementAdminDAOImpl obj = new HotelManagementAdminDAOImpl();	
	       	List<ReservationDetails> getAllReservations= new ArrayList<ReservationDetails>();
	       	getAllReservations=obj.getAllReservations(rowSelect,true);
	       	//if(getAllReservations)
	       	if(getAllReservations.size()==0) {
	       	tableView.getItems().clear();
	       	}else {
	       		initData(	getAllReservations);
	       	}
	    	
	    }
	    public void changeSceneToUpdateRecord(ActionEvent e) throws IOException {
	    	// the FXML loader object to load the UI design
	    	FXMLLoader loader = new FXMLLoader();
	    	// specify the file location
	    	loader.setLocation(getClass().getResource("UpdateRecord.fxml"));
	    	
			// try-catch for possible errors in reading the FXML file.
	    	try {
	    		// the object representing the root node of the scene; load the UI
	    		Parent parent = loader.load();
	   	
				// set the scene
				Scene scene = new Scene(parent);
				
				// access the controller class for the next window via the FXML loader
				UpdateRecordController controller = loader.getController();
			    // call the method in the controller class for the next window
			    // so that the data can be passed
				System.out.println("hotelid=="+selectedReservation.getHotelId());
			    controller.initialize(selectedReservation,true);   	
		    	// get the current window; i.e. the stage
		    	Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		    	// change the title of the window
		    	stage.setTitle("Update Record");
		    	// set the scene for the stage
		    	stage.setScene(scene);
		    	// show the stage
		    	stage.show();
				} catch (IOException e1) {
					
					System.out.print(e1.getMessage());
				}
	}
	}
