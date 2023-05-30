package controller;

import model.Post;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class PostController {
    String INSERT_POST = "INSERT INTO datasearch VALUES(?,?,?,?)";

    public boolean insertNewPost(Post post) throws Exception {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = DBUtil.getMySQlConnection();
            preparedStatement
                    = conn.prepareStatement(INSERT_POST);

            preparedStatement.setInt(1, post.getId());
            preparedStatement.setInt(2, post.getUserId());
            preparedStatement.setString(3, post.getTitle());
            preparedStatement.setString(4, post.getBody());

            return ( preparedStatement.executeUpdate() > 0 );

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return false;
    }
}
