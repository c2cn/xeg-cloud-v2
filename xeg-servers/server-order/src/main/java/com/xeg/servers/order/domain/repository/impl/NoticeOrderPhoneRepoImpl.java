package com.xeg.servers.order.domain.repository.impl;

import com.xeg.servers.order.domain.entity.NoticeOrderPhone;
import com.xeg.servers.order.domain.mapper.NoticeOrderPhoneMapper;
import com.xeg.servers.order.domain.repository.NoticeOrderPhoneRepo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
	* @author xian
	* @date   2021年11月4日 下午5:46:36
	* @version v1.0.0
	* @Description	短工大厅电话购买记录 服务实现类
	* NoticeOrderPhoneRepoImpl.java 
	* Modification History:
	* Date                         Author          Version          Description
	---------------------------------------------------------------------------------*
	* 2021年11月4日 下午5:46:36       xian            v1.0.0           Created
 */
@Service
public class NoticeOrderPhoneRepoImpl extends ServiceImpl<NoticeOrderPhoneMapper, NoticeOrderPhone> implements NoticeOrderPhoneRepo {

}
