package com.example.demo;

import com.example.demo.model.AyUser;
import com.example.demo.service.AyUserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Resource
    private JdbcTemplate jdbcTemplate;

    /**
     * Mysql 集成sping boot简单测试
     */
    @Test
    public void mySqlTest() {
        String sql = "select id,name,password from ay_user";
        List<AyUser> userList = jdbcTemplate.query(sql, new RowMapper<AyUser>() {
            @Override
            public AyUser mapRow(ResultSet resultSet, int i) throws SQLException {
                AyUser user = new AyUser();
                user.setId(resultSet.getString("id"));
                user.setName(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
                return user;
            }
        });
        System.out.println("查询成功：");
        for (AyUser user : userList) {
            System.out.println("[ID]:" + user.getId() + "  [name]:" + user.getName());

        }
    }

    @Test
    public void contextLoads() {
    }

    @Resource
    private AyUserService ayUserService;

    @Test
    public void testRepository() {
        //新增数据
        AyUser ayUser = new AyUser();
        ayUser.setId("03");
        ayUser.setName("test");
        ayUser.setPassword("123");
        ayUserService.save(ayUser);
        //查询所有数据
        List<AyUser> ayUsers = ayUserService.findAll();
        System.out.println("findAll() : " + ayUsers.size());
        //通过name查询数据
        List<AyUser> ayUsers1 = ayUserService.findByName("david");
        System.out.println("findByName() : " + ayUsers1.size());
        Assert.assertEquals("data error", "david", ayUsers1.get(0).getName());
        //通过name模糊查询数据
        List<AyUser> ayUsers2 = ayUserService.findByNameLike("%ja%");
        System.out.println("findByNameLike() : " + ayUsers2.size());
        Assert.assertEquals("data error", "jack", ayUsers2.get(0).getName());
        //通过id 列表查询数据
        List<String> ids = new ArrayList<String>();
        ids.add("01");
        ids.add("02");
        List<AyUser> ayUsers3 = ayUserService.findByIdIn(ids);
        System.out.println("findByIdIn() : " + ayUsers3.size());
        //分页查询数据
        PageRequest pageRequest = new PageRequest(0, 10);
        Page<AyUser> ayUsers4 = ayUserService.findAll(pageRequest);
        System.out.println("findAll(pageRequest) : " + ayUsers4.getTotalPages() + "-" + ayUsers4.getNumberOfElements() + "-" + ayUsers4.getSize());
        //删除数据
        ayUserService.delete("03");
    }

}
