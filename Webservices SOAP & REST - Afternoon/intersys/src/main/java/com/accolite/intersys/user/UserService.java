package com.accolite.intersys.user;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;



@Repository
public class UserService {
    
	@Autowired
    JdbcTemplate jdbcTemplate;

    public class EmployeeRowMapper implements RowMapper < User > {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setId(rs.getString("id"));
            user.setName(rs.getString("name"));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));
            user.setType(rs.getString("type"));
            user.setGender(rs.getString("gender"));
            user.setAge(rs.getInt("age"));
            user.setFeedback(rs.getString("feedback"));
            
            return user;
        }
    }

    public List < User > findAll() {
    
        return jdbcTemplate.query("select * from user", new EmployeeRowMapper());
    }

  
	
	
	
	public User findById(String id) {

		List<User> res =  jdbcTemplate.query("select * from user where user.id ="+id+";", new EmployeeRowMapper());
        		
        return res.get(0);
        		
        	
    }
	

    public int deleteById(String id) {
        return jdbcTemplate.update("delete from user where id=?", new Object[] {
            id
        });
    }

    public int insert(User employee) {
        return jdbcTemplate.update("insert into user (id, name, email, password, type, gender, age, feedback) " + "values(?, ?, ?, ?, ?, ?, ?, ?)",
            new Object[] {
                employee.getId(), employee.getName(),  employee.getEmail(), employee.getPassword(), employee.getType(), 
                employee.getGender(), employee.getAge(), employee.getFeedback()
            });
    }

    public int update(User employee, String id) {
        return jdbcTemplate.update("update user " + " set name=?, email=?, password=?, type=?, gender=?, age=?, feedback=? " + " where id = ?",
            new Object[] {
                employee.getName(), employee.getEmail(), employee.getPassword(), employee.getType(), 
                employee.getGender(), employee.getAge(), employee.getFeedback(), employee.getId()
            });
    }
}
