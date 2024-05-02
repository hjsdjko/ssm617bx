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


import com.dao.FenleilanDao;
import com.entity.FenleilanEntity;
import com.service.FenleilanService;
import com.entity.vo.FenleilanVO;
import com.entity.view.FenleilanView;

@Service("fenleilanService")
public class FenleilanServiceImpl extends ServiceImpl<FenleilanDao, FenleilanEntity> implements FenleilanService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<FenleilanEntity> page = this.selectPage(
                new Query<FenleilanEntity>(params).getPage(),
                new EntityWrapper<FenleilanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<FenleilanEntity> wrapper) {
		  Page<FenleilanView> page =new Query<FenleilanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<FenleilanVO> selectListVO(Wrapper<FenleilanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public FenleilanVO selectVO(Wrapper<FenleilanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<FenleilanView> selectListView(Wrapper<FenleilanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public FenleilanView selectView(Wrapper<FenleilanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
