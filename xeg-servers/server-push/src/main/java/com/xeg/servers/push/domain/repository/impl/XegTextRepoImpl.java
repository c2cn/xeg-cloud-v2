package com.xeg.servers.push.domain.repository.impl;

import com.xeg.servers.push.domain.entity.XegText;
import com.xeg.servers.push.domain.mapper.XegTextMapper;
import com.xeg.servers.push.domain.repository.XegTextRepo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xxx
 * @since 2021-10-27
 */
@Service
public class XegTextRepoImpl extends ServiceImpl<XegTextMapper, XegText> implements XegTextRepo {

}
