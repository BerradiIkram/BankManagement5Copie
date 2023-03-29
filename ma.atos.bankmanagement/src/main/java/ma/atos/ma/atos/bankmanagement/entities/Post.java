package ma.atos.ma.atos.bankmanagement.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    // Testing Class for OpenFeign Demo
    private Long id;
    private String title;
    private String body;
    private Long userId;
}
