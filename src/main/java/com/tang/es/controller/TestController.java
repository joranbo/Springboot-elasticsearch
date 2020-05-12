package com.tang.es.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tang.es.model.TestPo;
import com.tang.es.serviceImpl.TestServiceImpl;
import com.tang.es.utils.ActionResult;
import com.tang.es.utils.ActionResult.ActionResultBuilder;
import com.tang.es.utils.ActionResult.ActionResultStatus;

/** 
 * ClassName: TestController
 * Function: TODO ADD FUNCTION. 
 * date: 2020年5月6日 下午3:55:06
 * 
 * @author tangjiandong
 */
@RestController
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	private TestServiceImpl testService;
	
	
	/**
	 * addTestPo
	 * (保存对象)
	 * 
	 * @param testPo  参数对象
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/addTestPo")
	public String addTestPo(TestPo testPo)
	{
		ActionResult ar = ActionResult.success().build();
		
		if(StringUtils.isEmpty(testPo)) 
		{
			ar.setErrorCode(ActionResultStatus.valueOf(ActionResultStatus.VALIDATE_ERROR.getReasonPhrase()).getStatusCode());
			ar.setErrorMsg("校验异常，参数为空!");
			return JSON.toJSONString(ar);
		}
		
		try {
		 testService.save(testPo);
		} catch (Exception e) {
			e.printStackTrace();
			ar.setErrorCode(ActionResultStatus.valueOf(ActionResultStatus.BUSINESS_ERROR.getReasonPhrase()).getStatusCode());
			ar.setErrorMsg("数据保存异常,请检查数据问题!");
		}
		return JSON.toJSONString(ar);
	}
	
	
	/**
	 * deleteById
	 * (根据id删除)
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/deleteById")
	public String deleteById(String id)
	{
		ActionResult ar = ActionResult.success().build();
		
		if(StringUtils.isEmpty(id)) 
		{
			ar.setErrorCode(ActionResultStatus.valueOf(ActionResultStatus.VALIDATE_ERROR.getReasonPhrase()).getStatusCode());
			ar.setErrorMsg("校验异常，参数为空!");
			return JSON.toJSONString(ar);
		}
		
		try {
		 testService.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
			ar.setErrorCode(ActionResultStatus.valueOf(ActionResultStatus.BUSINESS_ERROR.getReasonPhrase()).getStatusCode());
			ar.setErrorMsg("数据删除异常!");
		}
		return JSON.toJSONString(ar);
	}
	
	
	/**
	 * findByName
	 * (根据分页参数查询分页数据)
	 * 
	 * @param name
	 * @param pageable
	 * @return
	 */
	@RequestMapping("/findByName")
	public String findByName(String name, Pageable pageable)
	{
		ActionResult ar = ActionResult.success().build();
		
		if(StringUtils.isEmpty(name) || StringUtils.isEmpty(pageable)) 
		{
			ar.setErrorCode(ActionResultStatus.valueOf(ActionResultStatus.VALIDATE_ERROR.getReasonPhrase()).getStatusCode());
			ar.setErrorMsg("校验异常，参数为空!");
			return JSONObject.toJSON(ar).toString();
		}
		
		try {
		 Page<TestPo> findByName = testService.findByName(name, pageable);
		 ar.setData(findByName);
		} catch (Exception e) {
			e.printStackTrace();
			ar.setErrorCode(ActionResultStatus.valueOf(ActionResultStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()).getStatusCode());
			ar.setErrorMsg(ActionResultStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
		}
		
		return  JSONObject.toJSON(ar).toString();
	}
	
	/**
	 * selectTestPo
	 * (查询对象)
	 * 
	 * @param testPo  参数对象
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/findById")
	public String findById(String id)
	{
		ActionResult ar = ActionResult.success().build();
		
		if(StringUtils.isEmpty(id)) 
		{
			ar.setErrorCode(ActionResultStatus.valueOf(ActionResultStatus.VALIDATE_ERROR.getReasonPhrase()).getStatusCode());
			ar.setErrorMsg("校验异常，参数为空!");
			return JSON.toJSONString(ar);
		}
		
		try {
		    Optional<TestPo> findById = testService.findById(id);
		    ar.setData(findById.get());
		} catch (Exception e) {
			e.printStackTrace();
			ar.setErrorCode(ActionResultStatus.valueOf(ActionResultStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()).getStatusCode());
			ar.setErrorMsg(ActionResultStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
		}
		
		return JSON.toJSONString(ar);
	}

}
