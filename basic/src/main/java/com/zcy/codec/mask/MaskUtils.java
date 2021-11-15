package com.zcy.codec.mask;

import org.apache.commons.lang3.StringUtils;


/**
 * 脱敏工具 （字符串）
 */
public class MaskUtils {

    /**
     * 银行卡号脱敏
     */
    public static String cardNoMask(String cardNo) {
        if (!StringUtils.isNumeric(cardNo)) {
            return cardNo;
        }
        return mask(cardNo, 6, 4);
    }

    /**
     * 身份证号码脱敏
     */
    public static String idCardNoMask(String idCardNo) {
        if (StringUtils.length(idCardNo) != 18) {
            return idCardNo;
        }
        return mask(idCardNo, 3, 4);
    }

    /**
     * 手机号脱敏
     */
    public static String mobileNoMask(String mobileNo) {
        return mask(mobileNo, 3, 4);
    }

    /**
     * 中文姓名脱敏
     */
    public static String chineseNameMask(String chineseNameCharacter) {
        if (StringUtils.length(chineseNameCharacter) < 2) {
            return chineseNameCharacter;
        }

        if (StringUtils.length(chineseNameCharacter) == 2) {
            return mask(chineseNameCharacter, 1, 0);
        }

        return mask(chineseNameCharacter, 1, 1);
    }


    //-----------------------------------------------------------------------
    // Core Method

    public static String mask(String str, int leftLen, int rightLen) {
        return mask(str, leftLen, rightLen, "*");
    }

    /**
     * 脱敏字符串
     *
     * @param str      待脱敏字符串
     * @param leftLen  左边保留长度
     * @param rightLen 右边保留长度
     * @param padStr   脱敏替代字符
     * @return 脱敏后字符串, 如果待脱敏字符串为{@code ""}或{@code null},则直接返回
     */
    public static String mask(String str, int leftLen, int rightLen, String padStr) {
        // "" | " " | "  " | null 不做处理，返回原始值
        if (StringUtils.isBlank(str)) {
            return str;
        }

        String left = StringUtils.left(str, leftLen);
        String right = StringUtils.right(str, rightLen);
        String middle = StringUtils.leftPad("", str.length() - leftLen - rightLen, padStr);

        return left + middle + right;
    }


    //-----------------------------------------------------------------------
    // 测试
    public static void main(String[] args) {
        String str = "6217211107001880725";
        String maskStr = MaskUtils.cardNoMask(str);

//        String str = "440101198512318623";
//        String maskStr = MaskUtils.idCardNoMask(str);

//        String str = "18218978666";
//        String maskStr = MaskUtils.mobileNoMask(str);

//        String str = "张三";
//        String str = "李四光";
//        String str = "王二麻子";
//        String str = "爱新觉罗溥仪";
//        String maskStr = MaskUtils.chineseNameMask(str);


        System.out.println("Str: " + str + " Length: " + StringUtils.length(str) + "\n"
                + ">>>>>>>>>>>>>> mask >>>>>>>>>>>>>>\n"
                + "Str: " + maskStr + " Length: " + StringUtils.length(maskStr));
    }
}
