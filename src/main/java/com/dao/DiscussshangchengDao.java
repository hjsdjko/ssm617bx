package com.dao;

import com.entity.DiscussshangchengEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussshangchengVO;
import com.entity.view.DiscussshangchengView;


/**
 * 商城评论表
 * 
 * @author 
 * @email 
 * @date 2021-04-16 17:50:16
 */
public interface DiscussshangchengDao extends BaseMapper<DiscussshangchengEntity> {
	
	List<DiscussshangchengVO> selectListVO(@Param("ew") Wrapper<DiscussshangchengEntity> wrapper);
	
	DiscussshangchengVO selectVO(@Param("ew") Wrapper<DiscussshangchengEntity> wrapper);
	
	List<DiscussshangchengView> selectListView(@Param("ew") Wrapper<DiscussshangchengEntity> wrapper);

	List<DiscussshangchengView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussshangchengEntity> wrapper);
	
	DiscussshangchengView selectView(@Param("ew") Wrapper<DiscussshangchengEntity> wrapper);
	
}
