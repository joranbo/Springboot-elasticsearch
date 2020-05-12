package com.tang.es.utils;

import java.io.Serializable;

/** 
 * ClassName: ActionResult
 * Function: TODO ADD FUNCTION. 
 * date: 2020年5月9日 下午5:20:14
 * 
 * @author tangjiandong
 */
public class ActionResult implements Serializable{
	
	
	
	/** 
	 * serialVersionUID:(用一句话描述这个变量表示什么). 
	 */
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * 结果状态
	 */
	private ActionResultStatus status  = ActionResultStatus.SUCCESS;
	
	/**
	 * 结果代码
	 */
	private String statusCode = String.valueOf(ActionResultStatus.valueOf(ActionResultStatus.SUCCESS.getReasonPhrase()).getStatusCode());
	
	/**
	 * 错误代码
	 */
	private Integer errorCode;
	
	/**
	 * 错误跟踪信息
	 */
	private String errorTrace;
	
	/**
	 * 错误信息
	 */
	private String errorMsg;
	
	/**
	 * 返回的数据
	 */
	private Object data;
	
	
	
	private static ActionResultBuilder builder;
	
	private static ActionResultBuilder createActionResult()
	{
		builder = ActionResultBuilder.newInstance();
		return builder;
	}
	
	public static ActionResultBuilder withStatus(ActionResultStatus status)
	{
		createActionResult().withStatus(status);
		return builder;
	}
	
	public static ActionResultBuilder success()
	{
		return withStatus(ActionResultStatus.SUCCESS);
	}
	
	/**
	 * 
	 * ClassName: ActionResultBuilder
	 * Function: 返回实例
	 * date: 2020年5月9日 下午6:03:05
	 * 
	 * @author tangjiandong
	 */
   public static  class ActionResultBuilder
   {
	   private ActionResult actionResult;
	   
	   protected ActionResultBuilder()
	   {
		   actionResult  = new ActionResult();
	   }
	   
	   public ActionResult build()
	   {
		   return actionResult;
	   }
	   
	   protected static ActionResultBuilder newInstance()
	   {
		   return new ActionResultBuilder();
	   }
	   
	   public ActionResultBuilder withStatus(ActionResultStatus status)
	   {
		   actionResult.setStatus(status);
		   return builder;
	   }
	   
	   public ActionResultBuilder withData(Object data)
	   {
		   actionResult.setData(data);
		   return builder;
	   }
   }
	

	/**
	 * ActionResultStatus
	 * ClassName: ActionResultStatus
	 * Function: 状态枚举 
	 * date: 2020年5月9日 下午5:27:24
	 * 
	 * @author tangjiandong
	 */
	public enum ActionResultStatus
	{
		/**
		 * 成功
		 */
		SUCCESS(200, "SUCCESS"),
		
		/**
		 * 服务器内部错误
		 */
		INTERNAL_SERVER_ERROR(500, "INTERNAL_SERVER_ERROR"),
		
		/**
		 * 业务异常
		 */
		BUSINESS_ERROR(501, "BUSINESS_ERROR"),
		
		
		/**
		 * 校验异常
		 */
		VALIDATE_ERROR(502, "VALIDATE_ERROR"),
		
		
		/**
		 * 错误请求
		 */
		BAD_REQUEST(400, "BAD_REQUEST"),
		
		
		/**
		 * 不可接收
		 */
		NOT_ACCEPTABLE(406, "NOT_ACCEPTABLE"),
		
		
		/**
		 * 没有权限
		 */
		UNAUTHORIZED(401, "UNAUTHORIZED"),
		
		/**
		 * 没有登录
		 */
		NOT_LOGIN(4010, "NOT_LOGIN"),
		
		
		/**
		 * 禁止
		 */
		FORBIDDEN(403, "FORBIDDEN");
		
		
		/**
		 * 状态代码
		 */
		private final int code;
		
		/**
		 * 原因描述
		 */
		private final String reason;
		
		ActionResultStatus(final int statusCode, final String reasonPhrase)
		{
			this.code = statusCode;
			this.reason = reasonPhrase;
		}

		/**
		 * @return the code
		 */
		public int getStatusCode() 
		{
			return code;
		}

		
		public String getReasonPhrase()
		{
			return toString();
		}
		
		
		@Override
		public String toString()
		{
			return reason;
		}
		
		
		/**
		 * 
		 * (通过code查找对象)
		 * 
		 * @param code
		 * @return
		 */
		public static ActionResultStatus fromStatusCode(final int code)
		{
			for (ActionResultStatus s : ActionResultStatus.values())
			{
				if(s.code == code)
				{
					return s;
				}
			}
			return null;
		}
	}
	
	
	/**
	 * @return the status
	 */
	public ActionResultStatus getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(ActionResultStatus status) {
		this.status = status;
	}
	


	/**
	 * @return the statusCode
	 */
	public String getStatusCode() {
		return statusCode;
	}

	/**
	 * @param statusCode the statusCode to set
	 */
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	/**
	 * @return the errorCode
	 */
	public Integer getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}


	/**
	 * @return the errorTrace
	 */
	public String getErrorTrace() {
		return errorTrace;
	}

	/**
	 * @param errorTrace the errorTrace to set
	 */
	public void setErrorTrace(String errorTrace) {
		this.errorTrace = errorTrace;
	}

	/**
	 * @return the errorMsg
	 */
	public String getErrorMsg() {
		return errorMsg;
	}

	/**
	 * @param errorMsg the errorMsg to set
	 */
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}


	/**
	 * @return the data
	 */
	public Object getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(Object data) {
		this.data = data;
	}

}
