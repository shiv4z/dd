package in.gov.egs.payload.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JwtResponse {
	  private String token;
	  private String type ;
	  private Long id;
	  private String username;
	  private String email;
	  private List<String> roles;
	  
}
