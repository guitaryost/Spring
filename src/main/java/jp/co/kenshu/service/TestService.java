package jp.co.kenshu.service;


import java.util.LinkedList;
import java.util.List;

import org.jboss.logging.Logger;
import org.jboss.logging.Logger.Level;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.kenshu.dto.test.TestDto;
import jp.co.kenshu.entity.Test;
import jp.co.kenshu.mapper.TestMapper;

@Service
public class TestService {

    @Autowired
    private TestMapper testMapper;

    public TestDto getTest(Integer id) {
        TestDto dto = new TestDto();
        Test entity = testMapper.getTest(id);
        //↑Mapper経由で取得したentityをDtoに詰め替えしてreturn
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    //全件取得のためのメソッド。mapperから取得した結果(entity)をListに詰める
    public List<TestDto> getTestAll() {
        List<Test> testList = testMapper.getTestAll();
        List<TestDto> resultList = convertToDto(testList);
        return resultList;
    }
    //entityをDtoに詰め直す
    private List<TestDto> convertToDto(List<Test> testList) {
        List<TestDto> resultList = new LinkedList<>();
        for (Test entity : testList) {
            TestDto dto = new TestDto();
            BeanUtils.copyProperties(entity, dto);
            resultList.add(dto);
        }
        return resultList;
    }

    public TestDto getTestByDto(TestDto dto) {
    	Test entity = testMapper.getTestByDto(dto);
    	BeanUtils.copyProperties(entity, dto);
    	return dto;
    }

    public int insertTest(String name) {
    	int count = testMapper.insertTest(name);
    	return count;
    }

    public int deleteTest(int id) {
    	int count = testMapper.deleteTest(id);
    	return count;
    }

    public int updateTest(TestDto dto) {
    	int count = testMapper.updateTest(dto);
    	return count;
    }

    @Transactional
    public void deleteAllAndInsert(TestDto dto) {
        int delCount = testMapper.deleteTest(dto.getId());
        Logger.getLogger(TestService.class).log(Level.INFO, "削除件数は" + delCount + "件です。");
        // ここのinsertは失敗する。deleteがrollBackされるかどうか。
        int insCount = testMapper.insertFailTest(null);
        Logger.getLogger(TestService.class).log(Level.INFO, "挿入件数は" + insCount + "件です。");
    }
}