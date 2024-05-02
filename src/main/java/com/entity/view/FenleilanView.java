package com.entity.view;

import com.entity.FenleilanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 分类栏
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-04-16 17:50:16
 */
@TableName("fenleilan")
public class FenleilanView  extends FenleilanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public FenleilanView(){
	}
 
 	public FenleilanView(FenleilanEntity fenleilanEntity){
 	try {
			BeanUtils.copyProperties(this, fenleilanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
