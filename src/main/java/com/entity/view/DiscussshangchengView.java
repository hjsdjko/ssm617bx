package com.entity.view;

import com.entity.DiscussshangchengEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 商城评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-04-16 17:50:16
 */
@TableName("discussshangcheng")
public class DiscussshangchengView  extends DiscussshangchengEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussshangchengView(){
	}
 
 	public DiscussshangchengView(DiscussshangchengEntity discussshangchengEntity){
 	try {
			BeanUtils.copyProperties(this, discussshangchengEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
