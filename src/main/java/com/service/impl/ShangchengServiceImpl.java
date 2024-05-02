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


import com.dao.ShangchengDao;
import com.entity.ShangchengEntity;
import com.service.ShangchengService;
import com.entity.vo.ShangchengVO;
import com.entity.view.ShangchengView;

@Service("shangchengService")
public class ShangchengServiceImpl extends ServiceImpl<ShangchengDao, ShangchengEntity> implements ShangchengService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShangchengEntity> page = this.selectPage(
                new Query<ShangchengEntity>(params).getPage(),
                new EntityWrapper<ShangchengEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShangchengEntity> wrapper) {
		  Page<ShangchengView> page =new Query<ShangchengView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ShangchengVO> selectListVO(Wrapper<ShangchengEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ShangchengVO selectVO(Wrapper<ShangchengEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ShangchengView> selectListView(Wrapper<ShangchengEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShangchengView selectView(Wrapper<ShangchengEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
