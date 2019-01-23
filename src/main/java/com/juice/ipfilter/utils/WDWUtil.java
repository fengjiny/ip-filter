package com.juice.ipfilter.utils;

/**
 * Created by fjy on 2017/01/24.
 */
public class WDWUtil {
    public static boolean isExcel2003(String filePath)
    {

        return filePath.matches("^.+\\.(?i)(xls)$");

    }

    /**
     *
     * @描述：是否是2007的excel，返回true是2007
     *
     * @参数：@param filePath　文件完整路径
     *
     * @参数：@return
     *
     * @返回值：boolean
     */

    public static boolean isExcel2007(String filePath)
    {

        return filePath.matches("^.+\\.(?i)(xlsx)$");

    }
}
