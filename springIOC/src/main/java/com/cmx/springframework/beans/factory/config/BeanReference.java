package com.cmx.springframework.beans.factory.config;

/**
 * 一个bean对另一个bean的引用
 *
 * @author 小雄不是大雄
 */
public class BeanReference {

	private final String beanName;


	public BeanReference(String beanName) {
		this.beanName = beanName;
	}

	public String getBeanName() {
		return beanName;
	}
}
