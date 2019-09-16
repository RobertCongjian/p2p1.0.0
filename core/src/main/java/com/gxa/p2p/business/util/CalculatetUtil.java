package com.gxa.p2p.business.util;


import com.gxa.p2p.common.util.SysConstant;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 计算器Util
 * 
 * @author Stef
 * 
 */
public class CalculatetUtil {

	public static final BigDecimal ONE_HUNDRED = new BigDecimal("100.0000");
	public static final BigDecimal NUMBER_MONTHS_OF_YEAR = new BigDecimal("12.0000");
	public static final BigDecimal ACCOUNT_MANAGER_CHARGE_RATE = new BigDecimal("0.0500");
	public static final BigDecimal INTEREST_MANAGER_CHARGE_RATE = new BigDecimal("0.1000");

	/**
	 * 获取月利率
	 */
	public static BigDecimal getMonthlyRate(BigDecimal yearRate) {
		if (yearRate == null)
			return BigDecimal.ZERO;
		return yearRate.divide(ONE_HUNDRED).divide(NUMBER_MONTHS_OF_YEAR, SysConstant.OPERATION_SCALE, RoundingMode.HALF_UP);
	}

	/**
	 * 计算借款总利息
	 * 
	 * @param returnType
	 *            还款类型
	 * @param bidRequestAmount
	 *            借款金额
	 * @param yearRate
	 *            年利率
	 * @param monthes2Return
	 *            还款期限
	 * @return
	 */
	public static BigDecimal calTotalInterest(int returnType, BigDecimal bidRequestAmount, BigDecimal yearRate, int monthes2Return) {
		BigDecimal totalInterest = BigDecimal.ZERO;
		BigDecimal monthlyRate = getMonthlyRate(yearRate);
		if (returnType == SysConstant.RETURN_TYPE_MONTH_INTEREST_PRINCIPAL) {// 按月分期
			// 只借款一个月
			if (monthes2Return == 1) {
				totalInterest = bidRequestAmount.multiply(monthlyRate).setScale(SysConstant.OPERATION_SCALE, RoundingMode.HALF_UP);
			} else {
				BigDecimal temp1 = bidRequestAmount.multiply(monthlyRate);
				BigDecimal temp2 = (BigDecimal.ONE.add(monthlyRate)).pow(monthes2Return);
				BigDecimal temp3 = (BigDecimal.ONE.add(monthlyRate)).pow(monthes2Return).subtract(BigDecimal.ONE);
				// 算出每月还款
				BigDecimal monthToReturnMoney = temp1.multiply(temp2).divide(temp3, SysConstant.OPERATION_SCALE, RoundingMode.HALF_UP);
				// 算出总还款
				BigDecimal totalReturnMoney = monthToReturnMoney.multiply(new BigDecimal(monthes2Return));
				// 算出总利息
				totalInterest = totalReturnMoney.subtract(bidRequestAmount);
			}
		} else if (returnType == SysConstant.RETURN_TYPE_MONTH_INTEREST) {// 按月到期
			BigDecimal monthlyInterest = DecimalFormatUtil.amountFormat(bidRequestAmount.multiply(monthlyRate));
			totalInterest = monthlyInterest.multiply(new BigDecimal(monthes2Return));
		}
		return DecimalFormatUtil.formatBigDecimal(totalInterest, SysConstant.STORE_SCALE);
	}

	}
