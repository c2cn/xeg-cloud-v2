package com.xeg.servers.user.domain.mapper;

import com.xeg.servers.user.domain.entity.TestA;

import java.math.BigDecimal;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xxx
 * @since 2021-11-08
 */
public interface TestAMapper extends BaseMapper<TestA> {
	@Update("update test_a set balance = balance - ${amount} where user_id = ${userId} ")
	void testUpdateA(@Param("userId") Long userId, @Param("amount") BigDecimal amount);
	
	@Select("select * from test_a where user_id = ${userId} for update ")
	TestA selectTestA(@Param("userId") Long userId);
	
	
	@Insert("insert into test_b(user_id, user_name) select user_id, user_name from test_a where user_id = 1 ")
	void testSelectInsert();
	
	@Insert("insert into test_b(user_id, user_name) values (3, 'u3') ")
	void testSelectInsert2();
	
	@Insert("insert into test_b(user_id, user_name) select 2, user_name from test_a where user_id = 1 ")
	void testSelectInsert3();
}
