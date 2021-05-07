import com.lagou.io.Resources;
import com.lagou.mapper.UserMapper;
import com.lagou.pojo.User;
import com.lagou.sqlSession.SqlSession;
import com.lagou.sqlSession.SqlSessionFactory;
import com.lagou.sqlSession.SqlSessionFactoryBuilder;
import org.dom4j.DocumentException;
import org.junit.Before;

import java.beans.PropertyVetoException;
import java.io.InputStream;

public class Test {

    private  UserMapper mapper;
    @org.junit.Test
    public void testUpdate() throws Exception {
        User user = new User();
        user.setId(1);
        user.setUsername("wanger");
        mapper.updateByCondition(user);
    }

    @Before
    public  void executeBefore() throws Exception {
        InputStream resourceAsSteam = Resources.getResourceAsSteam("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsSteam);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        mapper = sqlSession.getMapper(UserMapper.class);
    }


    @org.junit.Test
    public void testInsert() throws Exception {
        User user = new User();
        user.setId(3);
        user.setUsername("xiaoli");
        mapper.insertUser(user);
    }
    @org.junit.Test
    public void testDelete() throws Exception {
        User user = new User();
        user.setId(3);
        user.setUsername("xiaoli");
        mapper.deleteUser(user);
    }


}
