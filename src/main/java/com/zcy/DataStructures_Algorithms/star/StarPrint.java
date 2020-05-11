package com.zcy.DataStructures_Algorithms.star;

/**
 * @ Author: chunyang.zhang
 * @ Description:
 * @ Date: Created in 00:19 2020/5/12
 * @ Modified: By:
 */
// n=4 :
//      *
//     **
//    ***
//   ****
// n=5 :
//       *
//      **
//     ***
//    ****
//   *****
public class StarPrint {

    //=====================正三角=========================
    public static void upTriangle(int lineNumber) {
        int n = lineNumber;
        for (int i = 0; i < n; i++) { //控制行
            for (int j = 0; j < n - i; j++) { //控制列 1部分" "
                System.out.print(" ");
            }
            for (int k = 0; k <= i; k++) {  //控制列 2部分"*"
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }

    //=====================倒三角=========================
    public static void downTriangle(int lineNumber) {
        int n = lineNumber;
        for (int i = 0; i < n; i++) { //行
            for (int j = 0; j < n - i; j++) { //控制"*"
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }

    //=====================金字塔=========================
    public static void pyramid(int lineNumber) {
        int n = lineNumber;
        for (int i = 0; i < n; i++) { //控制行数
            for (int j = 0; j < n - i; j++) { //控制" "
                System.out.print(" ");
            }
            for (int k = 0; k < 2 * i + 1; k++) { //控制"*"
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }


    public static void main(String[] args) {
        upTriangle(20);
        downTriangle(20);
        pyramid(20);
    }

}




