package JavaFinalProject;
import java.util.List;


	public interface HotelManagementAdminDAO {
		/**
		 * method to add username and passowrd of admin details to databse
		 * @param RNo
		 * @param isReservation
		 * @return
		 */
		public void selectRecord(AdminLoginDetails objAdminModel);
		
		
		public List<ReservationDetails> getAllReservations(int RNo, boolean isReservation);
		   /**
		    * This method retrieves a customer record based on the given customer number.
		    * @param CNo Represents the primary key, customer number.
		    * @return a customer object
		    */
		  // public ReservationDetails getReservationsById(int RNo);
		   
		//public void insertReservation(NewReservations updateObj);
		
		   /**
		    * This method inserts a customer record into the database
		    * @param aCustomer a customer object
		    * @return whether the insertion is successful or not
		    * 
		    * 
		    */
		   public boolean insertReservation(ReservationDetails aReservation);
		   
		   /**
		    * This method updates a customer record in the database
		    * @param aCustomer a customer object
		    * @return whether the update is successful or not
		    */
		   public boolean updateReservation(ReservationDetails aReservation,String Checkin,String checkout);
		   
		   /**
		    * This method deletes a customer record based on the given reservation id.
		    * @param CNo Represent the primary key, customer number.
		    * @return whether the deletion is successful or not.
		    */
		   public boolean deleteReservation(int RNo);
		   
		   public ReservationDetails GetHotelId(String hotelname);
		   
		   public int GetUserId(String firstname,String Lastname);
		   
		   public int InsertUser(String firstname,String Lastname);
		
	}

