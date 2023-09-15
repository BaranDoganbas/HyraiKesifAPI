package pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {
    private String firstName;
    private String lastName;
    private Object profilePicture;
    private List<String> roles;
    private Integer id;
    private Object title;
    private String email;

}