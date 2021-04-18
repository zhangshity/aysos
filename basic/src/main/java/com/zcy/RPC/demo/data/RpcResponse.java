package com.zcy.RPC.demo.data;

import java.io.Serializable;

/**
 * @ Author: chunyang.zhang
 * @ Description: 《响应对象》
 * @ Date: Created in 15:37 2019-08-14
 * @ Modified: By:
 */
public class RpcResponse implements Serializable {

    //返回状态,(当然这里可以加入对应的异常等(此处简化))
    private String status;
    //返回数据
    private Object data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
