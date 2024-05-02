package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.TougaoEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.TougaoVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.TougaoView;


/**
 * 投稿
 *
 * @author 
 * @email 
 * @date 2021-04-16 17:50:16
 */
public interface TougaoService extends IService<TougaoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<TougaoVO> selectListVO(Wrapper<TougaoEntity> wrapper);
   	
   	TougaoVO selectVO(@Param("ew") Wrapper<TougaoEntity> wrapper);
   	
   	List<TougaoView> selectListView(Wrapper<TougaoEntity> wrapper);
   	
   	TougaoView selectView(@Param("ew") Wrapper<TougaoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<TougaoEntity> wrapper);
   	
}

