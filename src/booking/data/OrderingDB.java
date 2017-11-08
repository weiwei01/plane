
package booking.data;

import java.sql.*;
import java.util.*;
import booking.business.*;

public class OrderingDB
{
    
public static boolean exists(String orderingNumber, String emailAddress)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "SELECT OrderingNumber FROM Orders " +
                "WHERE OrderingNumber = ? and EmailAddress = ?";
        try
        {
            ps = connection.prepareStatement(query);
            ps.setString(1, orderingNumber);
            ps.setString(2, emailAddress);
            rs = ps.executeQuery();
            return rs.next();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return false;
        }
        finally
        {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

public static int deleteOrder(String orderingNumber)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        String query = "DELETE FROM Orders " +
                "WHERE OrderingNumber = ?";
        try
        {
            ps = connection.prepareStatement(query);
            ps.setString(1, orderingNumber);

            return ps.executeUpdate();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return 0;
        }
        finally
        {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

public static int deleteOrdering(String orderNumber)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        String query = "DELETE FROM Ordering " +
                "WHERE OrderNumber = ?";
        try
        {
            ps = connection.prepareStatement(query);
            ps.setString(1, orderNumber);

            return ps.executeUpdate();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return 0;
        }
        finally
        {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

public static int insertOrder(String emailAddress)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query = 
                "INSERT INTO Orders (EmailAddress) " +
                "VALUES (?)";
        try
        {        
            ps = connection.prepareStatement(query);
            ps.setString(1, emailAddress);
            return ps.executeUpdate();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return 0;
        }
        finally
        {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

public static int insertOrdering(Order ordering)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query = 
                "INSERT INTO Ordering (OrderNumber,FirstName,LastName,Address,City,State,ZipCode,nbWays,DepartureCity,ArrivalCity,NumberPassenger,PriceOrder) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        try
        {        
            ps = connection.prepareStatement(query);
            ps.setString(1, ordering.getOrderNumber());
            ps.setString(2, ordering.getFirstName());
            ps.setString(3, ordering.getLastName());
            ps.setString(4, ordering.getAddress());
            ps.setString(5, ordering.getCity());
            ps.setString(6, ordering.getState());
            ps.setString(7, ordering.getZipCode());
            ps.setString(8, ordering.getNbWays());
            ps.setString(9, ordering.getDepartureCity());
            ps.setString(10, ordering.getArrivalCity());
            ps.setString(11, ordering.getNumberPassenger());
            ps.setDouble(12, ordering.getPrice());
            return ps.executeUpdate();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return 0;
        }
        finally
        {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

public static int updateOrdering(Order ordering)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        String query = "UPDATE Ordering SET " +
                "FirstName = ?, " +
                "LastName = ?, " +
                "Address = ?, " +
                "City = ?, " +
                "State = ?, " +
                "ZipCode = ?, " +
                "nbWays = ?, " +
                "DepartureCity = ?, " +
                "ArrivalCity = ?, " +
                "NumberPassenger = ?, " +
                "PriceOrder = ? " +
                "WHERE OrderNumber = ?";
        try
        {
            ps = connection.prepareStatement(query);
            ps.setString(1, ordering.getFirstName());
            ps.setString(2, ordering.getLastName());
            ps.setString(3, ordering.getAddress());
            ps.setString(4, ordering.getCity());
            ps.setString(5, ordering.getState());
            ps.setString(6, ordering.getZipCode());
            ps.setString(7, ordering.getNbWays());
            ps.setString(8, ordering.getDepartureCity());
            ps.setString(9, ordering.getArrivalCity());
            ps.setString(10, ordering.getNumberPassenger());
            ps.setDouble(11, ordering.getPrice()); 
            ps.setString(12, ordering.getOrderNumber());

            return ps.executeUpdate();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return 0;
        }
        finally
        {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

public static int selectLastOrderingNumber()
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        int orderingNumber = 0;
                
        String query = "SELECT max(OrderingNumber) as last_id FROM Orders ";
        
        try
        {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            
            if (rs.next())
            {
                orderingNumber = rs.getInt("last_id");
            }
            
            return orderingNumber;
        }
        catch (SQLException e){
            e.printStackTrace();
            return 0;
        }        
        finally
        {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

public static Double selectPrice(String departureCity, String arrivalCity)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Double price = 0.0;
        
        String query = "SELECT * FROM Listprice " +
                       "WHERE DepartureCity = ? and ArrivalCity = ?";
        try
        {
            ps = connection.prepareStatement(query);
            ps.setString(1, departureCity);
            ps.setString(2, arrivalCity);
            rs = ps.executeQuery();
            
            if (rs.next())
            {
                price = rs.getDouble("Price");
            }
            
            return price;
        }
        catch (SQLException e){
            e.printStackTrace();
            return 0.0;
        }        
        finally
        {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

public static String selectEmailAddress(String orderingNumber)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String emailAddress = null;
                
        String query = "SELECT EmailAddress FROM Orders " +
                       "WHERE OrderingNumber = ?";
        try
        {
            ps = connection.prepareStatement(query);
            ps.setString(1, orderingNumber);
            rs = ps.executeQuery();
            
            if (rs.next())
            {
                emailAddress = rs.getString("EmailAddress");
            }
            
            return emailAddress;
        }
        catch (SQLException e){
            e.printStackTrace();
            return null;
        }        
        finally
        {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

public static Order selectOrder(String orderingNumber)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "SELECT * FROM Ordering " +
                       "WHERE OrderNumber = ?";
        try
        {
            ps = connection.prepareStatement(query);
            ps.setString(1, orderingNumber);
            rs = ps.executeQuery();
            Order order = null;
            
            if (rs.next())
            {
                order = new Order();
                order.setOrderNumber(orderingNumber);
                order.setFirstName(rs.getString("FirstName"));
                order.setLastName(rs.getString("LastName"));
                order.setAddress(rs.getString("Address"));
                order.setCity(rs.getString("City"));
                order.setState(rs.getString("State"));
                order.setZipCode(rs.getString("ZipCode"));
                order.setNbWays(rs.getString("NbWays"));
                order.setDepartureCity(rs.getString("DepartureCity"));             
                order.setArrivalCity(rs.getString("ArrivalCity")); 
                order.setNumberPassenger(rs.getString("NumberPassenger"));
                order.setPrice(rs.getDouble("PriceOrder"));
            }
            
            return order;
        }
        catch (SQLException e){
            e.printStackTrace();
            return null;
        }        
        finally
        {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
}