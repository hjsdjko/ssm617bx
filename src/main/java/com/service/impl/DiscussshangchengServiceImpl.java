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


import com.dao.DiscussshangchengDao;
import com.entity.DiscussshangchengEntity;
import com.service.DiscussshangchengService;
import com.entity.vo.DiscussshangchengVO;
import com.entity.view.DiscussshangchengView;

@Service("discussshangchengService")
public class DiscussshangchengServiceImpl extends ServiceImpl<DiscussshangchengDao, DiscussshangchengEntity> implements DiscussshangchengService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussshangchengEntity> page = this.selectPage(
                new Query<DiscussshangchengEntity>(params).getPage(),
                new EntityWrapper<DiscussshangchengEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussshangchengEntity> wrapper) {
		  Page<DiscussshangchengView> page =new Query<DiscussshangchengView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussshangchengVO> selectListVO(Wrapper<DiscussshangchengEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussshangchengVO selectVO(Wrapper<DiscussshangchengEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussshangchengView> selectListView(Wrapper<DiscussshangchengEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussshangchengView selectView(Wrapper<DiscussshangchengEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
