
package com.tang.es.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.tang.es.model.TestPo;

/** 
 * ClassName: TestDao
 * Function: TODO ADD FUNCTION. 
 * date: 2020年5月6日 下午3:47:26
 * 
 * @author tangjiandong
 */
@Component
public interface TestDao extends CrudRepository<TestPo, String>{
	
	/**
	 * findByName， 会计算分页参数， 比较耗性能
	 * (返回分页数据)
	 * 
	 * @param name 参数
	 * @param pageable  分页参数, pageable 包含 sort排序字段。传入排序参数就行
	 * @return
	 */
	Page<TestPo> findByName(String name, Pageable pageable);
	
	/**
	 * 
	 * (返回slice类型数据) 不会计算分页参数， 性能比较好
	 * 
	 * @param name
	 * @param pageable
	 * @return
	 */
	//Slice<TestPo> findByName(String name, Pageable pageable);
	
	/**
	 * 
	 * (排序)
	 * 
	 * @param lastname
	 * @param sort 排序参数
	 * @return
	 */
	List<TestPo> findByName(String name, Sort sort);
	
	
	/**
	 * 
	 * (分页参数返回list数据)
	 * 
	 * @param lastname
	 * @param pageable
	 * @return
	 */
	//List<TestPo> findByName(String name, Pageable pageable);
	

}
