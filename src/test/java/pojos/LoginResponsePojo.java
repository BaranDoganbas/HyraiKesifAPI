package pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginResponsePojo{
	private Result result;
	private Integer nbNotOpenedNotifications;
	private UserInfo userInfo;
	private Object companyInfo;
	private Object errorCode;
	private List<Object> errors;
	private List<Object> notifications;
	private Boolean status;


}