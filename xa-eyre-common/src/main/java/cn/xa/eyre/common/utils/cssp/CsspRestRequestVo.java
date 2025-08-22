package cn.xa.eyre.common.utils.cssp;

import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
public class CsspRestRequestVo<T> {
	@NotBlank(message="appKey 不能为空")
	private String appKey;
	@NotBlank(message="userName 不能为空")
	@Length(max=32,message="userName 长度不超过32")
	private String userName;
	@NotBlank(message="nonce 不能为空")
	private String nonce;
	@NotBlank(message="createTime 不能为空")
	private String createTime;
	@NotBlank(message="passwdDigest 不能为空")
	private String passwdDigest;
	private String groupType;
	@Valid
	@NotNull(message="parameter 不能为空")
	private T parameter;

	public CsspRestRequestVo() {
	}

	public CsspRestRequestVo(String appKey, String userName, String nonce, String createTime, String passwdDigest, String groupType) {
		this.appKey = appKey;
		this.userName = userName;
		this.nonce = nonce;
		this.createTime = createTime;
		this.passwdDigest = passwdDigest;
		this.groupType = groupType;
	}

	public String getAppKey() {
		return appKey;
	}

	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getNonce() {
		return nonce;
	}

	public void setNonce(String nonce) {
		this.nonce = nonce;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getPasswdDigest() {
		return passwdDigest;
	}

	public void setPasswdDigest(String passwdDigest) {
		this.passwdDigest = passwdDigest;
	}

	public String getGroupType() {
		return groupType;
	}

	public void setGroupType(String groupType) {
		this.groupType = groupType;
	}

	public T getParameter() {
		return parameter;
	}

	public void setParameter(T parameter) {
		this.parameter = parameter;
	}
}
