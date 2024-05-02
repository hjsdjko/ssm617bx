package com.dao;

import com.entity.TougaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.TougaoVO;
import com.entity.view.TougaoView;


/**
 * 投稿
 * 
 * @author 
 * @email 
 * @date 2021-04-16 17:50:16
 */
public interface TougaoDao extends BaseMapper<TougaoEntity> {
	
	List<TougaoVO> selectListVO(@Param("ew") Wrapper<TougaoEntity> wrapper);
	
	TougaoVO selectVO(@Param("ew") Wrapper<TougaoEntity> wrapper);
	
	List<TougaoView> selectListView(@Param("ew") Wrapper<TougaoEntity> wrapper);

	List<TougaoView> selectListView(Pagination page,@Param("ew") Wrapper<TougaoEntity> wrapper);
	
	TougaoView selectView(@Param("ew") Wrapper<TougaoEntity> wrapper);
	
}
