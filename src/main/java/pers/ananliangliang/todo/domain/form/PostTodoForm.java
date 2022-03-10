package pers.ananliangliang.todo.domain.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;

@Getter
@Setter
public class PostTodoForm {
    @Size(min = 1, max = 64)
    private String title;
    @Size(min = 1, max = 1024)
    private String comment;
}
