package MySQL;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestJDBC {
    public static void testInster() throws SQLException {
        //0.现在数据库中创建好数据库和数据表
        //1.创建DataSource对象.这个对象是程序级,每个程序创建一个dataSourse."单例"
        // 如果MysqlDataSource类能成功导入,说明前面的jar包导入没问题
        DataSource dataSource = new MysqlDataSource();
        //2.设置dataSourse的属性,为和数据库连接做准备
        //Mysql是一个服务器,要想访问MySQL,需要知道MySQL的IP地址,端口号,
        // 以及要访问的数据库名,以及用户名和密码
        //IP地址:一台主机的地址.端口号:一台主机上可能同时部署着很多的服务程序,到底要访问哪个服务器,使用端口号来区分
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/java05_10?charcterEncoding=utf8&useSSL=true");
        //必须先转换类型再设置,因为有的数据库不是CS结构
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("1184127373");
        //3.创建Connection对象,用来表示和数据库建立一次链接
        //这个操作可能是操作失败的,会抛出SQLException异常
        Connection connection = dataSource.getConnection();
        //4.链接建立好,就可以操作数据库了.核心就是拼装SQL语句
        //?是占位符,可以把具体的变量替换到?位置上去
        //此处的sql语句可以没有;
        //拼装SQL,并没有真正的执行SQL
        String sql = "insert into java05_10test values(?,?)";
        //用下面语句来辅助拼装sql语句,setxxx的类型,需要和数据库表的类型相匹配
        PreparedStatement statement = connection.prepareStatement(sql);
        //替换第一个?,类型是String
        statement.setString(1,"王维");
        //替换第二个?,类型是int
        statement.setInt(2,36);
        System.out.println(statement);
        //5.执行SQL，
        int ret = statement.executeUpdate();
        System.out.println(ret);
        //6.释放相关资源,一定要先释放statement，再释放connection，
        // 先创建的要后释放，不然可能会存在资源泄露的问题
        statement.close();
        connection.close();
    }

    public static void testselect() throws SQLException {
        //0.现在数据库中创建好数据库和数据表
        //1.创建DataSource对象.这个对象是程序级,每个程序创建一个dataSourse."单例"
        // 如果MysqlDataSource类能成功导入,说明前面的jar包导入没问题
        DataSource dataSource = new MysqlDataSource();
        //2.设置dataSourse的属性,为和数据库连接做准备
        //Mysql是一个服务器,要想访问MySQL,需要知道MySQL的IP地址,端口号,
        // 以及要访问的数据库名,以及用户名和密码
        //IP地址:一台主机的地址.端口号:一台主机上可能同时部署着很多的服务程序,到底要访问哪个服务器,使用端口号来区分
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/java05_10?charcterEncoding=utf8&useSSL=true");
        //必须先转换类型再设置,因为有的数据库不是CS结构
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("1184127373");
        //3.创建Connection对象,用来表示和数据库建立一次链接
        //这个操作可能是操作失败的,会抛出SQLException异常
        Connection connection = dataSource.getConnection();
        //4.拼装SQL语句
        String sql = "select * from java05_10test";
        PreparedStatement statement = connection.prepareStatement(sql);
        //5.此处没有？，不需要替换，直接执行就可
        //resultSet中国就包含了查询结果
          ResultSet resultSet = statement.executeQuery();
        //6.遍历结果集合.类似于迭代器
        while (resultSet.next()){
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            System.out.println(name + ":" + age);
        }
        //7.释放资源.顺序不能颠倒，先创建的最后释放
        resultSet.close();
        statement.close();
        connection.close();

    }
    public static void main(String[] args) throws SQLException {
    testInster();
    testselect();

    }
}
