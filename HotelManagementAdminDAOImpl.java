package JavaFinalProject;
import java.sql.*;
import java.util.*;

import edu.unlv.mis768.labwork18.CoffeeDBConstants;
import edu.unlv.mis768.labwork18.CoffeeDBUtil;
import edu.unlv.mis768.labwork18.Customer;
import java.text.SimpleDateFormat;
/**
 * This class implements the Interface HotelManagementAdminDAO.
 * @author  Aparna Ayyalasomayajula
 * @version 1.0
 */
public class HotelManagementAdminDAOImpl implements HotelManagementAdminDAO {

		@Override
		public void selectRecord(AdminLoginDetails objAdminModel) {
		

        // Step 1: Establishing a Connection and 
        // try-with-resource statement will auto close the connection.
			try {
				Connection conn = HotelManagementDBUtil.getDBConnection();
				Statement stmt = conn.createStatement(
	            		ResultSet.TYPE_SCROLL_INSENSITIVE,
	            		ResultSet.CONCUR_READ_ONLY);
				
				String SELECT_QUERY = "Select count(Admin_id) Id from "+ HotelmanagementDBConstants.ADMIN_TABLE_NAME+" where username = ? and password = ?";
			System.out.println(SELECT_QUERY);
			
			
	        
			// instantiate a PrepareStatement object using the SQL command
			PreparedStatement  prepStmt = conn.prepareStatement(SELECT_QUERY);
	         //  ResultSet result = stmt.executeQuery(SELECT_QUERY);
			prepStmt.setString(1,objAdminModel.getUsername());
			prepStmt.setString(2,objAdminModel.getPassword());
			ResultSet result = prepStmt.executeQuery();
			
            int rowCount=0;

            while(result.next())
            {
            	rowCount=rowCount+1;
               System.out.println(result.getInt("Id"));
                            
            }
			prepStmt.close();
	            HotelManagementDBUtil.closeDBConnection(conn);
            
        } catch (SQLException ex) {
            // print SQL exception information
        	System.out.println("ERROR: " + ex.getMessage());
        }
    }


		@Override
		public List<ReservationDetails> getAllReservations(int RNo, boolean isReservation) {
		
			// Create a array list for the data.
	        List <ReservationDetails>reservationList = new ArrayList<ReservationDetails>();
	        
		ReservationDetails aReservation =  new ReservationDetails();
		try {
			Connection conn = HotelManagementDBUtil.getDBConnection();
			Statement stmt = conn.createStatement(
            		ResultSet.TYPE_SCROLL_INSENSITIVE,
            		ResultSet.CONCUR_READ_ONLY);
			
			
			String sql = "select r.Reservation_id,r.check_in,r.check_out,C.last_name,Price,hd.hotelID,r.Location,r.Room_type ";
			       sql=sql+ "from hotelmanagement.reservation as r ";
			       sql=sql+ "inner join hotelmanagement.hoteldetails as hd on r.hotelID = hd.hotelID ";
			       sql=sql+ "inner join hotelmanagement.Customer as C on C.user_id = r.user_id ";
			       
					if (isReservation) {
						sql=sql+  " WHERE "+HotelmanagementDBConstants.RESERVATION_PK_NAME+" = "+RNo;
					}
					else {
						sql=sql+  " WHERE r.hotelID = "+RNo;
					}
					System.out.println(sql);
			//Execute the query.
            ResultSet result = stmt.executeQuery(sql);
            
           
            int rowCount=0;
            
            while(result.next())
            {
            	rowCount=rowCount+1;
               System.out.println(result.getInt("Reservation_id"));
               System.out.println(result.getString("Location"));
               // create a new object and fill the field with the values from the result set.
               aReservation  = new ReservationDetails(result.getInt("Reservation_id"), result.getString("Location"), result.getDate("check_in"), result.getDate("check_out"), result.getString("Room_type"), result.getDouble("Price"),result.getInt("hotelId"),result.getString("last_name"));
               reservationList.add(aReservation);
               System.out.println(reservationList);
                            
            }
            
            stmt.close();
            HotelManagementDBUtil.closeDBConnection(conn);
   
			
		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
		}
		return reservationList;
	}
		@Override
		public int GetUserId(String firstname,String Lastname) {
			int userid=0;
			try {
				Connection conn = HotelManagementDBUtil.getDBConnection();
				Statement stmt = conn.createStatement();
				String sql = "select user_id,first_name,last_name ";
			       sql=sql+ "from hotelmanagement.customer  where first_name = ? and  last_name = ? ";
			       
			       PreparedStatement  prepStmt = conn.prepareStatement(sql);
			       
					prepStmt.setString(1,firstname);
					prepStmt.setString(2,Lastname);
					
					ResultSet result = prepStmt.executeQuery();
		            while(result.next())
		            {
		            	userid=result.getInt("user_id");
		            	
		               System.out.println(result.getInt("user_id"));
		                            
		            }
					prepStmt.close();
			        HotelManagementDBUtil.closeDBConnection(conn);
			} catch (Exception ex) {
				System.out.println("ERROR: " + ex.getMessage());
			}
			return userid;
		}
		@Override
		public int InsertUser(String firstname,String Lastname) {
			int userid=0;
			
			try {
				
				Connection conn = HotelManagementDBUtil.getDBConnection();
				Statement stmt = conn.createStatement();
				
				
				String sql = "INSERT INTO " + HotelmanagementDBConstants.CUSTOMER_TABLE_NAME +
						"(first_name,last_name,username,passowrd)"+
						     " VALUES ('"+
						     firstname+"', '"+
						     Lastname+"', '"+
						     firstname+"', '"+
                             Lastname+"')";
				System.out.println(sql);
				//Execute the query.
				int rows = stmt.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS);
				
				ResultSet rs = stmt.getGeneratedKeys();
				if (rs.next()) {
					userid = rs.getInt(1);
				  
				}

				
	            stmt.close();
	            HotelManagementDBUtil.closeDBConnection(conn);
	   
				
			} catch (Exception ex) {
				System.out.println("ERROR: " + ex.getMessage());
			}
			
			return userid;
		}
		@Override
		public ReservationDetails GetHotelId(String hotelname) {
			 int id=0;
			 ReservationDetails obj =new ReservationDetails();
			try {
				
				Connection conn = HotelManagementDBUtil.getDBConnection();
				Statement stmt = conn.createStatement();
				String sql = "select hotelID,Area ";
			       sql=sql+ "from hotelmanagement.hoteldetails as h where hotelName = ? ";
			       
			       PreparedStatement  prepStmt = conn.prepareStatement(sql);
			       
					prepStmt.setString(1,hotelname);
					
					ResultSet result = prepStmt.executeQuery();
		            while(result.next())
		            {
		            	id=result.getInt("hotelID");
		            	obj.setHotelId(id);
		            	obj.setLocation(result.getString("Area"));
		               System.out.println(result.getInt("hotelID"));
		                            
		            }
					prepStmt.close();
			        HotelManagementDBUtil.closeDBConnection(conn);
			} catch (Exception ex) {
				System.out.println("ERROR: " + ex.getMessage());
			}
			
			return obj;
		}

	@Override
	public boolean insertReservation(ReservationDetails aReservation) {
		boolean flag=false;
		try {
			int userid=GetUserId(aReservation.getfirstName(),aReservation.getLastName());
			if(userid==0) {
				userid= InsertUser(aReservation.getfirstName(),aReservation.getLastName());
			}
			Connection conn = HotelManagementDBUtil.getDBConnection();
			Statement stmt = conn.createStatement();
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			String startdate = formatter.format(aReservation.getStartDate());
			String enddate = formatter.format(aReservation.getEndDate());
			java.util.Date dateStr = formatter.parse(startdate);
			java.sql.Date dateStartDB = new java.sql.Date(dateStr.getTime());
			java.util.Date dateendStr = formatter.parse(enddate);
			java.sql.Date dateendDB = new java.sql.Date(dateendStr.getTime());
			
			String sql = "INSERT INTO " + HotelmanagementDBConstants.RESERVATION_TABLE_NAME+
					"(Location,check_in,check_out,Room_type,hotelID,user_id,Price)"+
					     " VALUES ('"+
					     aReservation.getLocation()+"', '"+
					     dateStartDB+"', '"+
					     dateendDB+"', '"+
					     aReservation.getRoomType()+"', '"+
					     aReservation.getHotelId() +"', '"+
					     userid +"', '"+
					     aReservation.getPrice()+"')";
			System.out.println(sql);
			//Execute the query.
			int rows = stmt.executeUpdate(sql);
			
			if (rows ==1)
				flag=true;
			
            stmt.close();
            HotelManagementDBUtil.closeDBConnection(conn);
   
			
		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
		}
		return flag;
	}
	

	@Override
	public boolean updateReservation(ReservationDetails aReservation,String Checkin,String checkout) {
		boolean flag=false;
		try {
			Connection conn = HotelManagementDBUtil.getDBConnection();
			Statement stmt = conn.createStatement();
			
			
			String sql = "UPDATE " + HotelmanagementDBConstants.RESERVATION_TABLE_NAME+
				     " SET "+
				     //Location = '"+  aReservation.getLocation()+"', "+
				     " check_in = '"+ Checkin+"', "+
				     " check_out = '"+ checkout+"', "+
				     //" roomType = '"+aReservation.getRoomType()+"'"+
				     " price = '"+aReservation.getPrice()+"'"+
				     " WHERE Reservation_Id = '"+ aReservation.getReservationId()+"'";
		
			System.out.println(sql);
			//Execute the query.
			int rows = stmt.executeUpdate(sql);
			
			if (rows ==1)
				flag=true;
			
            stmt.close();
            HotelManagementDBUtil.closeDBConnection(conn);
   
			
		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
		}
		return flag;
	}

	@Override
	public boolean deleteReservation(int RNo) {
		boolean flag=false;
		try {
			Connection conn = HotelManagementDBUtil.getDBConnection();
			Statement stmt = conn.createStatement();
			
			
			String sql = "Delete FROM " +HotelmanagementDBConstants.RESERVATION_TABLE_NAME+
				     " WHERE Reservation_Id = '"+ RNo +"'";
		
			System.out.println(sql);
			//Execute the query.
			int rows = stmt.executeUpdate(sql);
			
			if (rows ==1)
				flag=true;
			
            stmt.close();
            HotelManagementDBUtil.closeDBConnection(conn);
   
			
		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
		}
		return flag;
	}


	

	

}
