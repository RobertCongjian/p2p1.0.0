package com.gxa.p2p.business.util;

import com.gxa.p2p.common.util.SysConstant;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 数字格式化工具类
 * */
public class DecimalFormatUtil {
	// 金额
	public static BigDecimal amountFormat(BigDecimal number) {
		number = number.setScale(SysConstant.STORE_SCALE, RoundingMode.HALF_UP);
		return number;
	}


	public static BigDecimal formatBigDecimal(BigDecimal data, int scal) {
		if (null == data)
			return new BigDecimal(0.00);
		return data.setScale(scal, BigDecimal.ROUND_HALF_UP);
	}

}
