package registerlogin.login.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user",uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

@Column(name = "first_name")
    private  String  firstName;
@Column(name = "last_name")
    private String lastName;

    private String Email;
    @Column(name = "password")
    private  String Password;
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
@JoinTable(
        name = "users_roles",
        joinColumns = @JoinColumn(
                name = "user_id",referencedColumnName = "id"))
    private Collection<Role>roles;


    public <T> User(String firstname, String lastname, String email, String password, List<T> roleUser) {


    }
}
