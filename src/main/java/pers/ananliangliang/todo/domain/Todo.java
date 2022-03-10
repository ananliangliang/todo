package pers.ananliangliang.todo.domain;

import lombok.*;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String comment;
    private Boolean isComplete;
    private ZonedDateTime completeTime;
    @Column(insertable = false, updatable = false)
    private ZonedDateTime createTime;
    @Column(insertable = false, updatable = false)
    private ZonedDateTime updateTime;
}
