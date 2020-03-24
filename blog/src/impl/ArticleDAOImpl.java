package impl;

import bean.Article;
import dao.ArticleDAO;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArticleDAOImpl implements ArticleDAO {
    private static final String SQL_INSERT_ARTICLE ="INSERT INTO ARTICLE (USERNAME,TITLE,CONTENT) VALUES (?,?,?)" ;
    private static final String SQL_SELECT_ARTICLE_BY_USERNAME ="SELECT * FROM ARTICLE WHERE USERNAME=?";
    private static final String SQL_SELECT_ARTICLE ="SELECT * FROM ARTICLE";

    /**
     *  发表文章
     * @param username 账号
     * @param title 文章标题
     * @param content 文章内容
     * @return
     */
    @Override
    public void insertByTitleAndContent(String username, String title, String content) {
        Connection conn=null;
        PreparedStatement state=null;
        int a=-1;
        try {
            //1.得到数据库的连接对象
            conn = DBUtil.getConnection();
            //2.预编译SQL语句
            state=conn.prepareStatement(SQL_INSERT_ARTICLE);
            //3.填充参数
            state.setString(1,username);
            state.setString(2,title);
            state.setString(3,content);
            //4.执行sql语句，得到结果
            state.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBUtil.releaseResource(conn,state,null);
    }

    /**
     *  根据账号查询文章
     * @param username 账号
     * @return 文章列表
     */
    @Override
    public List<Article> selectArticleByUsername(String username) {
        Connection conn=null;
        PreparedStatement state=null;
        ResultSet result=null;
        List<Article> articleList=new ArrayList<>();

        try {
            //1.得到数据库的连接对象
            conn =DBUtil.getConnection();
            //2.预编译SQL语句
            state=conn.prepareStatement(SQL_SELECT_ARTICLE_BY_USERNAME);
            //3.填充参数
            state.setString(1,username);
            //4.执行sql语句，得到结果
            result=state.executeQuery();
            while(result.next()){
                String title=result.getString("title");
                String content=result.getString("content");
                articleList.add(new Article(title,content));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBUtil.releaseResource(conn,state,result);
        return articleList;
    }

    /**
     *  查询所有文章
     * @return
     */
    @Override
    public List<Article> selectArticle() {
        Connection conn=null;
        PreparedStatement state=null;
        ResultSet result=null;
        List<Article> articleList=new ArrayList<>();

        try {
            //1.得到数据库的连接对象
            conn =DBUtil.getConnection();
            //2.预编译SQL语句
            state=conn.prepareStatement(SQL_SELECT_ARTICLE);
            //3.执行sql语句，得到结果
            result=state.executeQuery();
            while(result.next()){
                String username=result.getString("username");
                String title=result.getString("title");
                String content=result.getString("content");
                articleList.add(new Article(username,title,content));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBUtil.releaseResource(conn,state,result);
        return articleList;
    }

}
