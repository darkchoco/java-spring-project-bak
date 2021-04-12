package kr.cloudscape.spring.simple_mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CompanyService {

    @Autowired
    private CompanyMapper companyMapper;

    @Autowired
    private EmployeeMapper employeeMapper;

    public List<Company> getAll() {
        List<Company> companyList = companyMapper.getAll();
        if (companyList != null && companyList.size() > 0) {
            for (Company company : companyList)
                company.setEmployeeList(employeeMapper.getByCompanyId(company.getId()));
        }

        return companyList;
    }

    /**
     * 아래 메소드에서 모든 것이 Exception 없이 실행되어야 DB commit이 되게 하기 위하여 @Transactional 이란 어노테이션
     * 을 사용한다.
     * 보통은 RuntimeException이 발생할 경우를 고려하지만 그 밖의 경우도 고려할 경우 @Transactional 어노테이션에 원하는
     * Exception을 지정해주면 된다. 아래와 같이 (rollbackFor = Exception.class) 같이 할 경우 Exception을 상속받은 모든
     * Exception이 rollback 대상이 된다.
     */
    @Transactional(rollbackFor = Exception.class)
    public Company add(Company company) throws Exception {
        companyMapper.insert(company);

        // 기존 레거시 시스템의 어떤 값을 추가하다가 에러가 발생했다고 가정한다.
        if (true)
            // RuntimeException이 발생한 순간 companyMapper.insert(company); 수행은 rollback 된다.
//            throw new RuntimeException("Legacy Exception");
            throw new Exception("Legacy Exception");

        return company;
    }
}
