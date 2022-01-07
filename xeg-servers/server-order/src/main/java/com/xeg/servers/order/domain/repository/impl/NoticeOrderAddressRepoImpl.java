package com.xeg.servers.order.domain.repository.impl;

import com.xeg.servers.order.domain.entity.NoticeOrderAddress;
import com.xeg.servers.order.domain.mapper.NoticeOrderAddressMapper;
import com.xeg.servers.order.domain.repository.NoticeOrderAddressRepo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
	* @author xian
	* @date   2021年11月4日 下午5:45:48
	* @version v1.0.0
	* @Description	短工大厅工作地点和接送地点 服务实现类
	* NoticeOrderAddressRepoImpl.java 
	* Modification History:
	* Date                         Author          Version          Description
	---------------------------------------------------------------------------------*
	* 2021年11月4日 下午5:45:48       xian            v1.0.0           Created
 */
@Service
public class NoticeOrderAddressRepoImpl extends ServiceImpl<NoticeOrderAddressMapper, NoticeOrderAddress> implements NoticeOrderAddressRepo {

}
