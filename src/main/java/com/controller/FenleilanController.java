package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.FenleilanEntity;
import com.entity.view.FenleilanView;

import com.service.FenleilanService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 分类栏
 * 后端接口
 * @author 
 * @email 
 * @date 2021-04-16 17:50:16
 */
@RestController
@RequestMapping("/fenleilan")
public class FenleilanController {
    @Autowired
    private FenleilanService fenleilanService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,FenleilanEntity fenleilan, 
		HttpServletRequest request){

        EntityWrapper<FenleilanEntity> ew = new EntityWrapper<FenleilanEntity>();
		PageUtils page = fenleilanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fenleilan), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,FenleilanEntity fenleilan, HttpServletRequest request){
        EntityWrapper<FenleilanEntity> ew = new EntityWrapper<FenleilanEntity>();
		PageUtils page = fenleilanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fenleilan), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( FenleilanEntity fenleilan){
       	EntityWrapper<FenleilanEntity> ew = new EntityWrapper<FenleilanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( fenleilan, "fenleilan")); 
        return R.ok().put("data", fenleilanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(FenleilanEntity fenleilan){
        EntityWrapper< FenleilanEntity> ew = new EntityWrapper< FenleilanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( fenleilan, "fenleilan")); 
		FenleilanView fenleilanView =  fenleilanService.selectView(ew);
		return R.ok("查询分类栏成功").put("data", fenleilanView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        FenleilanEntity fenleilan = fenleilanService.selectById(id);
        return R.ok().put("data", fenleilan);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        FenleilanEntity fenleilan = fenleilanService.selectById(id);
        return R.ok().put("data", fenleilan);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody FenleilanEntity fenleilan, HttpServletRequest request){
    	fenleilan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(fenleilan);

        fenleilanService.insert(fenleilan);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody FenleilanEntity fenleilan, HttpServletRequest request){
    	fenleilan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(fenleilan);

        fenleilanService.insert(fenleilan);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody FenleilanEntity fenleilan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(fenleilan);
        fenleilanService.updateById(fenleilan);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        fenleilanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<FenleilanEntity> wrapper = new EntityWrapper<FenleilanEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = fenleilanService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
