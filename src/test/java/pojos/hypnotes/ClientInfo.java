package pojos.hypnotes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Ignore;

import java.util.ArrayList;
@Ignore
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientInfo {

    public Boolean isPhoneVerified;
    public Integer clientId;
    public String clientInfosName;
    public String clientInfosSurname;
    public String clientInfosEmail;
    public String clientInfosPhone;
    public String clientInfosTimeZone;
    public Integer clientInfoId;
    public Object clientInfosImage;
    public ArrayList<Object> clientSignedDocuments;
    public NearestMeeting nearestMeeting;
}
