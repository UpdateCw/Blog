/**
 * 
 */
package com.update.framework.action;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.update.framework.model.ResponseData;

/**
 * @author cw
 * @date 2016年11月10日
 * @vsersion 1.0
 * DOTO (带有Json的控制类)
 */
@ParentPackage("json-default")
@Result(name = "json", type = "json", params={"root", "responseData"})
public  class JsonAction extends BaseAction {
    /**
     * @Fields serialVersionUID : 对象序列化
     */
	private static final long serialVersionUID = -4587450597849978374L;
	/**
	 * json 对象
	 */
	protected ResponseData responseData =  new ResponseData();
	/**
	 * @return the responseData
	 */
	public ResponseData getResponseData() {
		return responseData;
	}

	/**
	 * @param responseData the responseData to set
	 */
	public void setResponseData(ResponseData responseData) {
		this.responseData = responseData;
	}
}
