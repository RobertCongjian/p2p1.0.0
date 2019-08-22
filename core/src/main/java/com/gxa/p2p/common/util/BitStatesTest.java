package com.gxa.p2p.common.util;

/**
 * 用户状态类，记录用户在平台使用系统中所有的状态。
 * 
 * @author novo
 */
public class BitStatesTest {

	public final static Long OP_BIND_PHONE = 1L << 0; // 用户绑定手机状态码
	public final static Long OP_BIND_EMAIL = 1L << 1; // 用户绑定邮箱状态码
	public final static Long OP_USER_INFO = 1L << 2; // 用户填写基本资料
	public final static Long OP_REAL_AUTH = 1L << 3; // 用户是否已经实名认证
	public final static Long OP_VEDIO_AUTH = 1L << 4; // 用户是否已经视频认证
	public final static Long OP_HAS_BIDREQUEST_PROCESS = 1L << 5; // 用户是否已经有一个借款申请在申请流程中
	public final static Long OP_HAS_BIND_BANK = 1L << 6; // 用户是否已经绑定了银行卡
	public final static Long OP_HAS_WITHDRAW_PROCESS = 1L << 7; // 用户是否有提现在审核流程中

	public static void main(String[] args) {

/*		System.out.println(OP_BIND_PHONE + "的二进制是:" + Long.toBinaryString(OP_BIND_PHONE));
		System.out.println(OP_BIND_EMAIL + "的二进制是:" + Long.toBinaryString(OP_BIND_EMAIL));
		System.out.println(OP_USER_INFO + "的二进制是:" + Long.toBinaryString(OP_USER_INFO));
		System.out.println(OP_REAL_AUTH + "的二进制是:" + Long.toBinaryString(OP_REAL_AUTH));
		System.out.println(OP_VEDIO_AUTH + "的二进制是:" + Long.toBinaryString(OP_VEDIO_AUTH));
		System.out.println(OP_HAS_BIDREQUEST_PROCESS + "的二进制是:" + Long.toBinaryString(OP_HAS_BIDREQUEST_PROCESS));
		System.out.println(OP_HAS_BIND_BANK + "的二进制是:" + Long.toBinaryString(OP_HAS_BIND_BANK));
		System.out.println(OP_HAS_WITHDRAW_PROCESS + "的二进制是:" + Long.toBinaryString(OP_HAS_WITHDRAW_PROCESS));*/


		Long sate = 0L;
		System.out.println("初始十进制状态码是：" + sate);
		System.out.println("初始二进制状态码是：" + Long.toBinaryString(sate));

		System.out.println( "-------------添加状态 OP_BIND_PHONE-------------");
		sate = (sate | OP_BIND_PHONE);
		System.out.println("当前十进制状态码是:" + sate);
		System.out.println("当前二进制状态码是:" + Long.toBinaryString(sate));

		System.out.println( "-------------添加状态 OP_BIND_EMAIL-------------");
		sate = (sate | OP_BIND_EMAIL);
		System.out.println("当前十进制状态码是:" + sate);
		System.out.println("当前二进制状态码是:" + Long.toBinaryString(sate));

		System.out.println( "-------------添加状态 OP_USER_INFO-------------");
		sate = (sate | OP_USER_INFO);
		System.out.println("当前十进制状态码是:" + sate);
		System.out.println("当前二进制状态码是:" + Long.toBinaryString(sate));


		System.out.println( "-------------当前状态是否包含 OP_USER_INFO-------------");
		sate = (sate & OP_USER_INFO);
		System.out.println("sate:" + sate);
		System.out.println("当前十进制状态码是:" + (sate != 0));

/*		System.out.println( "-------------当前状态是否包含 OP_USER_INFO-------------");
		sate = (sate & OP_REAL_AUTH);
		System.out.println("sate:" + sate);
		System.out.println("当前十进制状态码是:" + (sate != 0));*/


/*	    System.out.println( "-------------移除状态 OP_BIND_PHONE-------------");
		sate = (sate ^ OP_BIND_PHONE);
		System.out.println("当前十进制状态码是:" + sate);
		System.out.println("当前二进制状态码是:" + Long.toBinaryString(sate));


		System.out.println( "-------------移除状态 OP_BIND_EMAIL-------------");
		sate = (sate ^ OP_BIND_EMAIL);
		System.out.println("当前十进制状态码是:" + sate);
		System.out.println("当前二进制状态码是:" + Long.toBinaryString(sate));


		System.out.println( "-------------移除状态 OP_USER_INFO-------------");
		sate = (sate ^ OP_USER_INFO);
		System.out.println("当前十进制状态码是:" + sate);
		System.out.println("当前二进制状态码是:" + Long.toBinaryString(sate));*/




	}


}
