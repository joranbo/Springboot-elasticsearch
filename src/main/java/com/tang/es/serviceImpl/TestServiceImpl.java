package com.tang.es.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.EscapedErrors;

import com.tang.es.dao.TestDao;
import com.tang.es.model.TestPo;

/** 
 * ClassName: TestServiceImpl
 * Function: TODO ADD FUNCTION. 
 * date: 2020年5月6日 下午3:48:17
 * 
 * @author tangjiandong
 */
@Service("testService")
public class TestServiceImpl {
	
	@Autowired
	private TestDao testDao;
	
	/**
	 * addTestPo
	 * (保存对象)
	 * 
	 * @param testPo  参数对象
	 * @return
	 * @throws Exception
	 */
	public TestPo save(TestPo testPo)throws Exception
	{
		return testDao.save(testPo);
	}
	
	/**
	 * deleteById
	 * (根据id删除)
	 * 
	 * @param id
	 * @throws Exception
	 */
	public void  deleteById(String id)throws Exception
	{
		testDao.deleteById(id);
	}
	
	
	/**
	 * selectTestPo
	 * (查询对象)
	 * 
	 * @param testPo  参数对象
	 * @return
	 * @throws Exception
	 */
	public Optional<TestPo> findById(String id)throws Exception
	{
		return testDao.findById(id);
	}
	
	
	/**
	 * findByName， 会计算分页参数， 比较耗性能
	 * (返回分页数据)
	 * 
	 * @param name 参数
	 * @param pageable  分页参数
	 * @return
	 */
	public Page<TestPo> findByName(String name, Pageable pageable)throws Exception
	{
		
		return testDao.findByName(name, pageable);
	}

}
