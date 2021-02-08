package kr.cloudscape.spring.simple_rest_api_server.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class UserProfile {
    private final String id;
    @Setter private String name;
    @Setter private String phone;
    @Setter private String address;
}
