package com.tang.es.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.stereotype.Component;


/** 
 * ClassName: TestPo
 * Function: TODO ADD FUNCTION. 
 * date: 2020年5月6日 下午3:44:51
 * 
 * @author tangjiandong
 * 
 * shards 主分片数量
 * replicas 副分片数量
 * 
 * 7.x 版本移除了type
 */
@Document(indexName="testpo", shards=5, replicas=2)
public class TestPo implements Serializable{
	
	/** 
	 * serialVersionUID:(用一句话描述这个变量表示什么). 
	 */
	private static final long serialVersionUID = 1L;
	

	@Id
	@Field(type = FieldType.Keyword, index = false)
	private String id;
	
	@Field(type = FieldType.Text, analyzer="ik_smart", searchAnalyzer="ik_smart")
	private String name;
	
	@Field(type = FieldType.Integer)
	private int age;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/**
	 * @param obj
	 * @return
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TestPo other = (TestPo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	/**
	 * @return
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TestPo [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	

}
