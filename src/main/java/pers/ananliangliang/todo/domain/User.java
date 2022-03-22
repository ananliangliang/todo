package pers.ananliangliang.todo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.time.ZonedDateTime;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User extends AbstractPersistable<Long> {

    private String username;
    private String password;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;

    @Column(insertable = false, updatable = false)
    private ZonedDateTime createTime;
    @Column(insertable = false, updatable = false)
    private ZonedDateTime updateTime;

    @OneToMany
    @JoinColumn(name = "user_id")
    private Set<Authority> authorities;


    @Override
    public boolean isNew() {
        return false;
    }
}
