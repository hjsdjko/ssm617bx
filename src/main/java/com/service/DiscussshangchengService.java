package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussshangchengEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussshangchengVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussshangchengView;


/**
 * 商城评论表
 *
 * @author 
 * @email 
 * @date 2021-04-16 17:50:16
 */
public interface DiscussshangchengService extends IService<DiscussshangchengEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussshangchengVO> selectListVO(Wrapper<DiscussshangchengEntity> wrapper);
   	
   	DiscussshangchengVO selectVO(@Param("ew") Wrapper<DiscussshangchengEntity> wrapper);
   	
   	List<DiscussshangchengView> selectListView(Wrapper<DiscussshangchengEntity> wrapper);
   	
   	DiscussshangchengView selectView(@Param("ew") Wrapper<DiscussshangchengEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussshangchengEntity> wrapper);
   	
}

