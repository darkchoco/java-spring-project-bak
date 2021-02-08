package kr.cloudscape.spring.simple_rest_api_server.controller;

import kr.cloudscape.spring.simple_rest_api_server.model.UserProfile;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserProfileController {

    private Map<String, UserProfile> userMap;

    @PostConstruct
    public void init() {
        userMap = new HashMap<>();
        userMap.put("1", new UserProfile("1", "천익훈", "1111-1111", "분당구 정자동"));
        userMap.put("2", new UserProfile("2", "김수정", "2222-2222", "성북구 돈암동"));
        userMap.put("3", new UserProfile("3", "조익희", "3333-3333", "성북구 장위동"));
    }

    @GetMapping("/user/{id}")
    public UserProfile getUserProfile(@PathVariable("id") String id) {
        return userMap.get(id);
    }

    @GetMapping("/user/all")
    public List<UserProfile> getUserProfileList() {
        return new ArrayList<>(userMap.values());
    }

    @PutMapping("/user/{id}")
    public void putUserProfile(@PathVariable("id") String id,
                               @RequestParam("name") String name,
                               @RequestParam("phone") String phone,
                               @RequestParam("address") String address) {
        UserProfile userProfile = new UserProfile(id, name, phone, address);
        userMap.put(id, userProfile);
    }

    @PostMapping("/user/{id}")
    public void postUserProfile(@PathVariable("id") String id,
                                @RequestParam("name") String name,
                                @RequestParam("phone") String phone,
                                @RequestParam("address") String address) {
        UserProfile userProfile = userMap.get(id);
        userProfile.setName(name);
        userProfile.setPhone(phone);
        userProfile.setAddress(address);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUserProfile(@PathVariable("id") String id) {
        userMap.remove(id);
    }
}
