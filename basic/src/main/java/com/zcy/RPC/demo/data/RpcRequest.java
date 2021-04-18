package com.zcy.RPC.demo.data;

import java.io.Serializable;

/**
 * @ Author: chunyang.zhang
 * @ Description: 《请求对象》
 * @ Date: Created in 15:32 2019-08-14
 * @ Modified: By:
 */
public class RpcRequest implements Serializable {

    //接口名称,用于反射
    private String interfaceName;
    //调用方法
    private String method;
    //参数类型
    private Class<?>[] parameterTypes;
    //参数
    private Object[] params;

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Class<?>[] getParameterTypes() {
        return parameterTypes;
    }

    public void setParameterTypes(Class<?>[] parameterTypes) {
        this.parameterTypes = parameterTypes;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }
}
