package com.xeg.servers.chat.domain.repository.impl;

import com.xeg.servers.chat.domain.entity.XegText;
import com.xeg.servers.chat.domain.mapper.XegTextMapper;
import com.xeg.servers.chat.domain.repository.XegTextRepo;
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
