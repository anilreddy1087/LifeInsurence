package com.gofortrainings.newsportal.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class ResetPassword {
	
	
	    @ValueMapValue
	    private String resetPassword;
	    
	    @ValueMapValue
	    private String userId;
	    
	    @ValueMapValue
	    private String oldPassword;

	    private String newPassword;

	    public String getResetPassword() {
	        return resetPassword;
	    }

	    public String getUserId() {
	        return userId;
	    }

	    public String getOldPassword() {
	        return oldPassword;
	    }

	    public String getNewPassword() {
	        return newPassword;
	    }
	}



