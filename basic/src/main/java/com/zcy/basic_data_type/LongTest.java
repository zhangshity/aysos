package com.zcy.basic_data_type;


/**
 * 三目运算符 : 两侧类型相同 (编译器以左侧为准)
 */
public class LongTest {

    Long oeaWorkStatus = 3L;
    Long oeaEmailStatus = null;

    public void setOeaEmailStatus(Long oeaEmailStatus) {
        this.oeaEmailStatus = oeaEmailStatus;
    }

    public Long getOeaWorkStatus() {
        return oeaWorkStatus;
    }


    /**
     * 一个关于三目运算符的测试(以包装类型Long为例子)
     * @param args
     */
    public static void main(String[] args) {
        LongTest longTest = new LongTest();


        // 会出现空指针(冒号左边默认long,故会装箱,同理右边也会对null装箱)，三目运算符两边为相同类型类型 (以冒号左边为准编译)
        /**
         * 0L为long 编译器默认加Long.valueOf()  <-  :  -> 同理 编译器理解为long,默认加Long.valueOf(),如果为null,NullPointerException
         */
        longTest.setOeaEmailStatus(longTest.getOeaWorkStatus() == 0L ? 0L : (longTest.getOeaWorkStatus() == 1L ? 1L : null));
        System.out.println(longTest.oeaEmailStatus);


        // 无指针，三目运算符两边为相同类型类型 (以冒号左边为准编译)
        /**
         * 0L为Long   <-  :  -> 同理 编译器理解为Long, 子三目为1L,默认加Long.valueOf(), 为null,直接返回
         */
        longTest.setOeaEmailStatus(longTest.getOeaWorkStatus() == 0L ? Long.valueOf(0L) : (longTest.getOeaWorkStatus() == 1L ? 1L : null));
        System.out.println(longTest.oeaEmailStatus);

        // 会出现空指针，三目运算符两边为相同类型类型 (子三目怎么包装,最后编译器都会加上Long.valueOf())
        /**
         * 0L为long 编译器默认加Long.valueOf()  <-  :  -> 同理 编译器理解为long,默认加Long.valueOf(),子三目为1L Long直接返回,为nullye直接返回;但是还是要被包装无法避免NullPointerException
         */
        longTest.setOeaEmailStatus(longTest.getOeaWorkStatus() == 0L ? 0L : (longTest.getOeaWorkStatus() == 1L ? Long.valueOf(1L) : null));
        System.out.println(longTest.oeaEmailStatus);









    }
}
