package com.solvd.it_company.dao.jdbc.mysql.Impl;

import com.solvd.it_company.connection.ConnectionUtil;
import com.solvd.it_company.dao.IServicesDAO;
import com.solvd.it_company.models.Services;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class ServicesDAO implements IServicesDAO {
    List<Services> services = new LinkedList<>();

    @Override
    public Services getServiceById(int id) {
        Connection connection = ConnectionUtil.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Services WHERE id=" + id);
            if (resultSet.next()) {
                System.out.println(getServiceById(resultSet));
                return getServiceById(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Services getServiceById(ResultSet resultSet) throws SQLException{
        Services newService = new Services();
        newService.setId(resultSet.getInt("id"));
        newService.setService_name(resultSet.getString("service_name"));
        newService.setLead_time(resultSet.getString("lead_time"));
        return newService;
    }

    @Override
    public List<Services> getAllServices() {
        PreparedStatement preparedStatement;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM Services");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                services.add(getServiceById(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return services;
    }

    @Override
    public void addService(int id, String service_name, String lead_time) {
        Connection connection = ConnectionUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Services VALUE(default, ?, ?)");
            preparedStatement.setString(1, service_name);
            preparedStatement.setString(2,lead_time);
            if (preparedStatement.executeUpdate() == 1) {
                System.out.println("Insertion is successful.");
            } else
                System.out.println("Insertion was failed.");
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    @Override
    public void updateService(Services services) {
        Connection connection = ConnectionUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Services SET service_name=?, " +
                    "lead_time=? WHERE id=?");
            preparedStatement.setString(1, services.getService_name());
            preparedStatement.setString(2, services.getLead_time());
            preparedStatement.setInt(3, services.getId());
            if (preparedStatement.executeUpdate() == 1) {
                System.out.println("Update process is successful: " + services.getId() + "-" + services.getService_name() + " " + services.getLead_time());
            } else
                System.out.println("Update process was failed: " + services.getId() + "-" + services.getService_name() + " " + services.getLead_time());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteService(int id) {
        Connection connection = ConnectionUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Services WHERE id=" + id);
            if (preparedStatement.executeUpdate() == 1) {
                System.out.println("Delete process is successful.");
            } else
                System.out.println("Delete process was failed.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
