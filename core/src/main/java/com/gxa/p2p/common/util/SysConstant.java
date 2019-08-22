package com.gxa.p2p.common.util;

import java.math.BigDecimal;

/**
 * 系统中的常量
 * 
 * @author novo
 * 
 */
public class SysConstant {

	/**
	 * 定义系统级别的0
	 */
	public static final BigDecimal ZERO = new BigDecimal("500000.0000");
	/**
	 * 定义存储精度
	public static final int STORE_SCALE = 4;
	/**
	 * 定义运算精度
	 */
	public static final int OPERATION_SCALE = 8;
	/**
	 * 定义显示精度
	 */
	public static final int DISPLAY_SCALE = 2;

	/**
	 * 定义初始授信额度
	 */
	public static final BigDecimal INIT_BORROW_LIMIT = new BigDecimal(
			"5000.0000");


}
