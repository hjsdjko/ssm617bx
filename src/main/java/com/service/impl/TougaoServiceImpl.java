package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.TougaoDao;
import com.entity.TougaoEntity;
import com.service.TougaoService;
import com.entity.vo.TougaoVO;
import com.entity.view.TougaoView;

@Service("tougaoService")
public class TougaoServiceImpl extends ServiceImpl<TougaoDao, TougaoEntity> implements TougaoService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<TougaoEntity> page = this.selectPage(
                new Query<TougaoEntity>(params).getPage(),
                new EntityWrapper<TougaoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<TougaoEntity> wrapper) {
		  Page<TougaoView> page =new Query<TougaoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<TougaoVO> selectListVO(Wrapper<TougaoEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public TougaoVO selectVO(Wrapper<TougaoEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<TougaoView> selectListView(Wrapper<TougaoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public TougaoView selectView(Wrapper<TougaoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
