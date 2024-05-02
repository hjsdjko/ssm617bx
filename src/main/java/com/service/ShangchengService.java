package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShangchengEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ShangchengVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ShangchengView;


/**
 * 商城
 *
 * @author 
 * @email 
 * @date 2021-04-16 17:50:16
 */
public interface ShangchengService extends IService<ShangchengEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShangchengVO> selectListVO(Wrapper<ShangchengEntity> wrapper);
   	
   	ShangchengVO selectVO(@Param("ew") Wrapper<ShangchengEntity> wrapper);
   	
   	List<ShangchengView> selectListView(Wrapper<ShangchengEntity> wrapper);
   	
   	ShangchengView selectView(@Param("ew") Wrapper<ShangchengEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShangchengEntity> wrapper);
   	
}

