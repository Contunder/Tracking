package com.microservice.tracking.tracking.domain.gateway;

import com.microservice.tracking.tracking.domain.entities.Role;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailsDto {
    String email;
    String password;
    Set<Role> roles;
}
