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
public class NearestMeeting {

    public Integer id;
    public Datetime datetime;
    public String meetUrl;
    public Object subject;
    public Object message;
    public ArrayList<Object> majorConcerns;
    public Object other;
    public Object referredBy;
    public Boolean hypnotizedBefore;
    public String additionalInfo;
    public Created created;
    public Updated updated;
    public Boolean isActive;
    public String addressTitle;
    public Object fullAddress;
    public Integer meetingChangeAttempts;
    public Object rescheduleStatus;
    public Object usePacket;
    public Boolean isPay;
    public Object meetingStatus;
    public String comment;
    public Boolean isSendGoogle;
    public Object packageCount;
}
