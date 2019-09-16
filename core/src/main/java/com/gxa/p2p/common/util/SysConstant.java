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


	//定义存储精度
	public static final int STORE_SCALE = 4;

	//  定义运算精度
	public static final int OPERATION_SCALE = 8;


	//定义显示精度

	public static final int DISPLAY_SCALE = 2;

	/**
	 * 定义初始授信额度
	 */
	public static final BigDecimal INIT_BORROW_LIMIT = new BigDecimal(
			"5000.0000");


	/**
	 * 发送手机验证码的时间间隔
	 */
	public static final long SEND_VERIFYCODE_INTERVAL  =  30 ; //秒

	/**
	 * 手机验证码的有效时间
	 */
	public static final long VERIFYCODE_VALID_TIME  =  84600 ; //秒


    public static final long EMAIL_VALID_DAY = 1;


	/**
	 * 用户信用借款的对用风控的最低分数
	 */
	public static final int CREDIT_BORROW_SCORE  =  30 ;



	// --------------------还款类型---------------------------
	public final static int RETURN_TYPE_MONTH_INTEREST_PRINCIPAL = 0; // 还款方式
	// 按月分期还款(等额本息)
	public final static int RETURN_TYPE_MONTH_INTEREST = 1; // 还款方式
	// 按月到期还款(每月还利息,到期还本息)

	// ---------------------标的类型--------------------------
	public final static int BIDREQUEST_TYPE_NORMAL = 0; // 普通信用标

	// ---------------------借款状态---------------------------
	public final static int BIDREQUEST_STATE_PUBLISH_PENDING = 0; // 待发布
	public final static int BIDREQUEST_STATE_BIDDING = 1; // 招标中
	public final static int BIDREQUEST_STATE_UNDO = 2; // 已撤销
	public final static int BIDREQUEST_STATE_BIDDING_OVERDUE = 3; // 流标
	public final static int BIDREQUEST_STATE_APPROVE_PENDING_1 = 4; // 满标1审
	public final static int BIDREQUEST_STATE_APPROVE_PENDING_2 = 5; // 满标2审
	public final static int BIDREQUEST_STATE_REJECTED = 6; // 满标审核被拒绝
	public final static int BIDREQUEST_STATE_PAYING_BACK = 7; // 还款中
	public final static int BIDREQUEST_STATE_COMPLETE_PAY_BACK = 8; // 已还清
	public final static int BIDREQUEST_STATE_PAY_BACK_OVERDUE = 9; // 逾期
	public final static int BIDREQUEST_STATE_PUBLISH_REFUSE = 10; // 发标审核拒绝状态

	public static final BigDecimal SMALLEST_BID_AMOUNT = new BigDecimal(
			"50.0000");// 系统规定的最小投标金额
	public static final BigDecimal SMALLEST_BIDREQUEST_AMOUNT = new BigDecimal(
			"500.0000");// 系统规定的最小借款金额
	public static final BigDecimal SMALLEST_CURRENT_RATE = new BigDecimal(
			"5.0000");// 系统最小借款利息
	public static final BigDecimal MAX_CURRENT_RATE = new BigDecimal("20.0000");// 系统最大借款利息
}
