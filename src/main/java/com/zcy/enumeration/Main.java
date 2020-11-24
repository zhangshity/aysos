package com.zcy.enumeration;


public class Main {
    public static void main(String[] args) {

        System.out.println(ChannelTypeEnum.RECONCILIATION.name());
        System.out.println(ChannelTypeEnum.valueOf("RECONCILIATION"));
        System.out.println(ChannelTypeEnum.RECONCILIATION.getCode());
        System.out.println(ChannelTypeEnum.RECONCILIATION.getMessage());
    }
}
