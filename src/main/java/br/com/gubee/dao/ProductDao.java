package br.com.gubee.dao;

import br.com.gubee.domain.Product;
import br.com.gubee.factory.ConnectionFactory;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {

    public void save(Product product) {

        String sql = "INSERT INTO products(product_name,description,targetMarket,stack)" + " VALUES(?,?,?,?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, product.getProductName());
            pstm.setString(2, product.getDescription());
            pstm.setArray(3, (Array) product.getTargetMarket());
            pstm.setArray(4, (Array) product.getStack());
            pstm.execute();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {

                e.printStackTrace();
            }
        }
    }

    public void removeById(int id) {

        String sql = "DELETE FROM products WHERE id = ?";

        Connection conn = null;

        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void update(Product product) {

        String sql = "UPDATE products SET product_name = ?, description = ?, targetMarket = ?, stack = ?" + " WHERE id = ?";

        Connection conn = null;

        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, product.getProductName());
            pstm.setString(2, product.getDescription());
            pstm.setArray(3, (Array) product.getTargetMarket());
            pstm.setArray(4, (Array) product.getStack());
            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {

                    pstm.close();
                }

                if (conn != null) {
                    conn.close();
                }

            } catch (Exception e) {

                e.printStackTrace();
            }
        }
    }

    public List<Product> getProducts() {

        String sql = "SELECT * FROM products";

        List<Product> products = new ArrayList<Product>();

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);

            rset = pstm.executeQuery();
            while (rset.next()) {

                Product product = new Product();
                product.setId(rset.getInt("id"));
                product.setProductName(rset.getString("product_name"));
                product.setDescription(rset.getString("description"));
                product.setTargetMarket((List<String>) rset.getArray("targetMarket"));
                product.setStack((List<String>) rset.getArray("stack"));
                products.add(product);
            }
        } catch (Exception e) {

            e.printStackTrace();
        } finally {

            try {

                if (rset != null) {
                    rset.close();
                }

                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return products;
    }
}
