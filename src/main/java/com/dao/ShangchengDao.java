package com.dao;

import com.entity.ShangchengEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ShangchengVO;
import com.entity.view.ShangchengView;


/**
 * 商城
 * 
 * @author 
 * @email 
 * @date 2021-04-16 17:50:16
 */
public interface ShangchengDao extends BaseMapper<ShangchengEntity> {
	
	List<ShangchengVO> selectListVO(@Param("ew") Wrapper<ShangchengEntity> wrapper);
	
	ShangchengVO selectVO(@Param("ew") Wrapper<ShangchengEntity> wrapper);
	
	List<ShangchengView> selectListView(@Param("ew") Wrapper<ShangchengEntity> wrapper);

	List<ShangchengView> selectListView(Pagination page,@Param("ew") Wrapper<ShangchengEntity> wrapper);
	
	ShangchengView selectView(@Param("ew") Wrapper<ShangchengEntity> wrapper);
	
}
