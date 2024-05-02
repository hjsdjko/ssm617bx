package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.FenleilanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.FenleilanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.FenleilanView;


/**
 * 分类栏
 *
 * @author 
 * @email 
 * @date 2021-04-16 17:50:16
 */
public interface FenleilanService extends IService<FenleilanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<FenleilanVO> selectListVO(Wrapper<FenleilanEntity> wrapper);
   	
   	FenleilanVO selectVO(@Param("ew") Wrapper<FenleilanEntity> wrapper);
   	
   	List<FenleilanView> selectListView(Wrapper<FenleilanEntity> wrapper);
   	
   	FenleilanView selectView(@Param("ew") Wrapper<FenleilanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<FenleilanEntity> wrapper);
   	
}

