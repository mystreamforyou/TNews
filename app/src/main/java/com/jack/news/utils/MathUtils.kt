package com.jack.news.utils

import java.math.RoundingMode
import java.text.DecimalFormat

/**
 * Description: News
 * Copyright  : Copyright (c) 2017
 * Author     : liujianguang
 * Date       : 2017/10/20
 **/

object MathUtils {

    fun formatValue(value: String): String {
        var dis = StringBuffer()
        val tmpV = value.toInt()
        when {
            tmpV >= 10000 -> {
                dis.append(getFloatRound(tmpV.toDouble() / 10000))
                dis.append("万")
            }
            else -> {
                dis.append(tmpV)
            }
        }
        return dis.toString()
    }

    /**
     * 给参数返回指定小数点后 a 位的四舍五入
     * @param sourceData 要取舍的原数据
     * @return 舍取后的 数据
     */
    fun getFloatRound(sourceData: Double): String {
        val b = DecimalFormat("#0.0")
        b.roundingMode = RoundingMode.HALF_UP
        return b.format(sourceData)
    }

}