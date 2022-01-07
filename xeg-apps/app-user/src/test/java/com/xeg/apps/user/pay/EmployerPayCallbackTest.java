package com.xeg.apps.user.pay;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.xeg.apps.user.app.pay.EmployerPayCallbackController;
import com.xeg.servers.pay.bean.dto.EmployerPayCallbackDTO;

import lombok.extern.slf4j.Slf4j;

/**
	* @author xian
	* @date   2021年11月4日 下午2:50:05
	* @version v1.0.0
	* @Description	支付测试类
	* EmployerPayCallbackTest.java 
	* Modification History:
	* Date                         Author          Version          Description
	---------------------------------------------------------------------------------*
	* 2021年11月4日 下午2:50:05       xian            v1.0.0           Created
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class EmployerPayCallbackTest {
	@Autowired
	private EmployerPayCallbackController employerPayCallbackController;
	
	
	@Test
	public void payCallback () {
		log.info("payCallback...");
		
		EmployerPayCallbackDTO dto = new EmployerPayCallbackDTO();
		dto.setToken("token123");
		dto.setOrderNo("1");
		dto.setOrderSource(1);
		
		for (int i = 0; i < 100; i++) {
			new Thread(() -> {
				employerPayCallbackController.payCallback(dto);
			}).start();
		}
		
		try {
			Thread.sleep(10 * 1000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
