package pojos.hypnotes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Ignore;

@Ignore
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Datetime {

    public String date;
    public Integer timezone_type;
    public String timezone;
}
