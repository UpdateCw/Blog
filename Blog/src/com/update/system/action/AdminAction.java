package com.update.system.action;

import java.util.List;
import java.util.logging.Logger;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.update.entity.Admin;
import com.update.framework.action.BaseAction;
import com.update.framework.common.CustomException;
import com.update.framework.until.Constant;
import com.update.system.service.AdminService;
import com.update.system.service.LogService;
import com.update.system.service.TypeService;

/**
 * @author cw
 * @date 2016年6月12日 下午2:01:21
 *
 */
@Namespace(value = "/user")
@Results({
		@Result(name="input",location="/pages/login.jsp",type="redirect"),
		@Result(name="isMain",location="/pages/articleAdd.jsp")
		})
public class AdminAction extends BaseAction {
    private Logger logger=Logger.getLogger(this.getClass().getName()); 
	
	private static final long serialVersionUID = 7675610277124547364L;
	
	@Resource
	private AdminService adminService;
	
	@Resource
	private TypeService typeService;
	
	@Resource
	private LogService logService;

	
	private Admin admin;

	
	/**
	 *首页
	 * @throws Exception 
	 */
	@Action("login")
	public  String login() throws Exception{
		List<Admin> adminList=adminService.findAdminByLoginName(admin.getUsername());
		if(adminList==null||adminList.size()==0){
			throw new CustomException("此用户名账号不存在");
		}
		
		Admin newAdmin=adminList.get(0);
		if(!admin.getUsername().equalsIgnoreCase(newAdmin.getUsername())
	      ||!admin.getPassword().equals(admin.getPassword())){
			throw new CustomException("用户密码错误");
		}
		
		if(admin!=null){
			getSession().setAttribute(Constant.LOGIN, admin);
			logger.info("Operation： login success");
			page=typeService.selectTypeList();
			return "isMain";
		}
		return "input";
	}
	
	
	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
}
