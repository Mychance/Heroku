package com.alibaba.webx.tutorial2.app1.module.action;

import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.Navigator;
import com.alibaba.citrus.turbine.dataresolver.FormGroup;
import com.alibaba.webx.tutorial2.app1.RegisterObject;

public class RegisterAction {
	public void doCheck(@FormGroup("register")RegisterObject param,Navigator nav,Context context){
		String name = param.getName();
		String pwd = param.getPwd();
		String repwd = param.getRepwd();
		System.out.println(pwd+repwd);
		if(pwd.equals(repwd)){
			nav.redirectTo("app1Link").withTarget("hello").withParameter("name",name);
		}else{
			context.put("errorMsg", "密码与确认密码不一样");
		}
	}
}
