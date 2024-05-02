package com.dao;

import com.entity.FenleilanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.FenleilanVO;
import com.entity.view.FenleilanView;


/**
 * 分类栏
 * 
 * @author 
 * @email 
 * @date 2021-04-16 17:50:16
 */
public interface FenleilanDao extends BaseMapper<FenleilanEntity> {
	
	List<FenleilanVO> selectListVO(@Param("ew") Wrapper<FenleilanEntity> wrapper);
	
	FenleilanVO selectVO(@Param("ew") Wrapper<FenleilanEntity> wrapper);
	
	List<FenleilanView> selectListView(@Param("ew") Wrapper<FenleilanEntity> wrapper);

	List<FenleilanView> selectListView(Pagination page,@Param("ew") Wrapper<FenleilanEntity> wrapper);
	
	FenleilanView selectView(@Param("ew") Wrapper<FenleilanEntity> wrapper);
	
}
