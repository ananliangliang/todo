package pers.ananliangliang.todo.domain;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Getter
@Setter
@Entity
@Builder
@DynamicInsert
@NoArgsConstructor
@AllArgsConstructor
public class Task extends AbstractPersistable<Long> {
    private String title;
    private String comment;
    private Boolean isComplete;
    private ZonedDateTime completeTime;
    @Column(insertable = false, updatable = false)
    private ZonedDateTime createTime;
    @Column(insertable = false, updatable = false)
    private ZonedDateTime updateTime;
}
