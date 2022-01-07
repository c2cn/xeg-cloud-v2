package com.xeg.cores.mysql;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xeg.cores.base.http.PageVO;
import com.xeg.cores.base.utils.BeanMapper;

/**
 * @Description //TODO
 * @Author Qi Ding
 * @Date 2021/5/23 6:58 下午
 * @Version 1.0
 */
public class PageUtils {
	private PageUtils() {
	}

	public static <S, T> PageVO<T> convert(IPage<S> sPage, Class<S> sClass, Class<T> tClass) {
		PageVO<T> tPage = new PageVO<>();
		tPage.setCurrent(sPage.getCurrent());
		tPage.setPages(sPage.getPages());
		tPage.setSize(sPage.getSize());
		tPage.setTotal(sPage.getTotal());
		if (sPage.getRecords() != null && sPage.getRecords().size() > 0) {
			tPage.setList(BeanMapper.mapList(sPage.getRecords(), sClass, tClass));
		}
		return tPage;
	}
}
