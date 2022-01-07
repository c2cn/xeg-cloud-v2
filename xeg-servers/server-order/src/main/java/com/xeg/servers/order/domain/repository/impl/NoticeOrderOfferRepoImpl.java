package com.xeg.servers.order.domain.repository.impl;

import com.xeg.servers.order.domain.entity.NoticeOrderOffer;
import com.xeg.servers.order.domain.mapper.NoticeOrderOfferMapper;
import com.xeg.servers.order.domain.repository.NoticeOrderOfferRepo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
	* @author xian
	* @date   2021年11月4日 下午5:46:25
	* @version v1.0.0
	* @Description	短工大厅订单议价表 服务实现类
	* NoticeOrderOfferRepoImpl.java 
	* Modification History:
	* Date                         Author          Version          Description
	---------------------------------------------------------------------------------*
	* 2021年11月4日 下午5:46:25       xian            v1.0.0           Created
 */
@Service
public class NoticeOrderOfferRepoImpl extends ServiceImpl<NoticeOrderOfferMapper, NoticeOrderOffer> implements NoticeOrderOfferRepo {

}
