package com.ecommerce.user.VO;

import com.ecommerce.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserBean {

    private Long userId;
    private String firstName;
    private String lastName;
    private String email;
    private Department department;
}
