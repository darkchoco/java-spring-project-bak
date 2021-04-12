package kr.cloudscape.spring.simple_mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")  // company로 시작하는 API는 이 Controller에서 모두 처리한다.
public class CompanyController {

    @Autowired
    private CompanyMapper companyMapper;

    @Autowired
    private CompanyService companyService;

    @PostMapping("")
    public Company post(@RequestBody Company company) throws Exception {
//        companyMapper.insert(company);  // 단순히 insert 수행하면 insert 한 데이터 갯수 return. insert 한 데이터 전체
                                          // 를 return 하고 싶으면 CompanyMapper.java의 11번째 라인 주석 참조.
        companyService.add(company);
        return company;
    }

    @GetMapping("")
    public List<Company> getAll() {
        return companyMapper.getAll();
//        return companyService.getAll();
    }

    @GetMapping("/{id}")
    public Company getById(@PathVariable("id") int id) {
        return companyMapper.getById(id);
    }
}
