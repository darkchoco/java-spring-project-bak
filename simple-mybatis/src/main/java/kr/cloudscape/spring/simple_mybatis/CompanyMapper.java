package kr.cloudscape.spring.simple_mybatis;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CompanyMapper {

    @Insert("INSERT INTO company (company_name, company_address) VALUES (#{company.name}, #{company.address})")
    @Options(useGeneratedKeys = true, keyProperty = "id")  // DB에서 자동생성된 Key 값을 포함한 Company 전체를 return
                                                           // 으로 확인가능(int 값이 아니라).
    int insert(@Param("company") Company company);

    @Select("SELECT * FROM company")
    @Results(id = "CompanyMap", value = {
            @Result(property = "name", column = "company_name"),
            @Result(property = "address", column = "company_address"),
            @Result(property = "employeeList",
                    column = "id",
                    many = @Many(select = "kr.cloudscape.spring.simple_mybatis.EmployeeMapper.getByCompanyId"))
    })  // Company의 property 이름과 테이블의 컬럼명이 틀리기 때문에 이렇게 mapping이 필요하다.
    List<Company> getAll();

    @Select("SELECT * FROM company WHERE id = #{id}")
    @ResultMap("CompanyMap")  // getAll()의 @Results annotation에서 선언된 id를 재사용.
    Company getById(@Param("id") int id);
}
