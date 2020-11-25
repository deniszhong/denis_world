package com.denis.zhong.world.message.event;

import com.denis.zhong.world.entity.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.ApplicationEvent;

import java.io.Serializable;

@Setter
@Getter
@ToString
public class LoginEvent extends ApplicationEvent implements Serializable {

    private static final long serialVersionUID = 9086816482836027394L;

    private User user;

    public LoginEvent(Object source) {
        super(source);
    }

    public LoginEvent(Object source, User user) {
        super(source);
        this.user = user;
    }
}
