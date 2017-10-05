/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mapper;

import Data.Connector;
import entities.Bottom;
import entities.Topping;
import entities.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is responsible for getting single elements and lists out of
 * toppings and bottoms.
 *
 * Instantiated from:
 *
 * Presentation Layer: Login_regitration and GeneratOrderline
 *
 * Data Layer: OrderMapper
 *
 * @author Christian
 */
public class CupcakeMapper {

    public static CupcakeMapper createCupcakeMapper() {
        CupcakeMapper cm = new CupcakeMapper();
        return cm;
    }

    /**
     * @return a List of Toppings from the DB, is also used to get store
     * information in the dropdown menu.
     */
    public List<Topping> getListOfTops() {
        List<Topping> output = new ArrayList<Topping>();
        try {
            String sql = "SELECT topping_id "
                    + "FROM cupcake.toppings";
            PreparedStatement pstmt = Connector.getConnection().prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            Topping mytop = null;
            int toppint_id = 0;
            while (rs.next()) {
                toppint_id = rs.getInt("topping_id");
                mytop = Topping.createTopping(toppint_id);
                mytop = this.getToppingByToppingId(mytop);
                output.add(mytop);
            }
        } catch (Exception e) {
            return null;
        }

        return output;
    }

    /**
     * @return a List of Toppings from the DB, is also used to get store
     * information in the dropdown menu.
     */
    public List<Bottom> getListOfBots() {
        List<Bottom> output = new ArrayList<Bottom>();
        try {
            String sql = "SELECT bottom_id "
                    + "FROM cupcake.bottoms";
            PreparedStatement pstmt = Connector.getConnection().prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            Bottom mybot = null;
            int bottom_id = 0;
            while (rs.next()) {
                bottom_id = rs.getInt("bottom_id");
                mybot = Bottom.createBottom(bottom_id);
                mybot = this.getBottomByBottomId(mybot);
                output.add(mybot);
            }
        } catch (Exception e) {
            return null;
        }
        return output;
    }

    /**
     * @param topping is used to get the id from the topping, so that we can
     * find the specific topping in the DB with its name and price.
     * @return A topping found from the id and name and price have been set.
     */
    public Topping getToppingByToppingId(Topping topping) {
        Topping output = topping;
        try {
            String sql = "SELECT name, price "
                    + "FROM cupcake.toppings where topping_id ="
                    + topping.getId();
            PreparedStatement pstmt = Connector.getConnection().prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            String name = "";
            double price = 0;
            while (rs.next()) {
                name = rs.getString("name");
                price = rs.getDouble("price");
            }
            output.setName(name);
            output.setPrice(price);
        } catch (Exception e) {
            return null;
        }
        return output;
    }

    /**
     * @param id The id of the topping so we can create a object of the topping.
     * @return The topping with name, price and its id.
     */
    public Topping getToppingByToppingId(int id) {
        Topping output = Topping.createTopping(id);
        try {
            String sql = "SELECT name, price "
                    + "FROM cupcake.toppings where topping_id ="
                    + id;
            PreparedStatement pstmt = Connector.getConnection().prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            String name = "";
            double price = 0;
            while (rs.next()) {
                name = rs.getString("name");
                price = rs.getDouble("price");
            }
            output.setName(name);
            output.setPrice(price);
        } catch (Exception e) {
            return null;
        }
        return output;
    }

    /**
     * @param bottom is used to get the id from the bottom, so that we can
     * find the specific bottom in the DB with its name and price.
     * @return A bottom found from the id and name and price have been set.
     */

    public Bottom getBottomByBottomId(Bottom bottom) {
        Bottom output = bottom;
        try {
            String sql = "SELECT name, price "
                    + "FROM cupcake.bottoms where bottom_id ="
                    + bottom.getId();
            PreparedStatement pstmt = Connector.getConnection().prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            String name = "";
            double price = 0;
            while (rs.next()) {
                name = rs.getString("name");
                price = rs.getDouble("price");
            }
            output.setName(name);
            output.setPrice(price);
        } catch (Exception e) {
            return null;
        }
        return output;
    }

    /**
     * @param id The id of the bottom so we can create a object of the bottom.
     * @return The bottom with name, price and its id.
     */
    public Bottom getBottomByBottomId(int id) {
        Bottom output = Bottom.createBottom(id);
        try {
            String sql = "SELECT name, price "
                    + "FROM cupcake.bottoms where bottom_id ="
                    + id;
            PreparedStatement pstmt = Connector.getConnection().prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            String name = "";
            double price = 0;
            while (rs.next()) {
                name = rs.getString("name");
                price = rs.getDouble("price");
            }
            output.setName(name);
            output.setPrice(price);
        } catch (Exception e) {
            return null;
        }
        return output;
    }

}
