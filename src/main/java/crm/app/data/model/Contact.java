package crm.app.data.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/*@Entity
@Table(name = "contact")*/
public class Contact implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 25)
    private String name;
    @Column(nullable = false, length = 25)
    private String surname;
    @Column(length = 15)
    private String number;
    @Column(length = 60)
    private String email;


}
