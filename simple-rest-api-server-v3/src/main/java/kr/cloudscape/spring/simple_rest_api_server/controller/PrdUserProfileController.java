package kr.cloudscape.spring.simple_rest_api_server.controller;

import kr.cloudscape.spring.simple_rest_api_server.model.UserProfile;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Profile("prd")
public class PrdUserProfileController {

    private Map<String, UserProfile> userMap;

    @Value("${hello.message: 반갑습니다}")  // application.yml 내 지정된 값. 없을 경우 '반갑습니다'는 디폴트 값 사용.
    private String helloMessage;

    @Value("${hello.countries}")
    private List<String> countries;

    @Value("#{${hello.account}}")  // Map일 경우 #{}로 한번 더 싸주어야 한다.
    private Map<String, String> accountMap;

    @GetMapping("/hello")
    public String getHello() {
        return "[PrdUserProfileController]" + helloMessage + " " + countries + " " + accountMap.get("name") + " " + accountMap.get("password");
    }

    @PostConstruct
    public void init() {
        userMap = new HashMap<>();
        userMap.put("1", new UserProfile("1", "천익훈", "1111-1111", "분당구 정자동"));
        userMap.put("2", new UserProfile("2", "김수정", "2222-2222", "성북구 돈암동"));
        userMap.put("3", new UserProfile("3", "조익희", "3333-3333", "성북구 장위동"));
    }

    /**
     * id에 해당하는 UserProfile 가져오기
     * @param id URL Path 내 포함된 id 값을 추출(@PathVariable 사용)하여 파라미터로 넘긴다
     * @return Json 형태로 값이 return 된다
     */
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
