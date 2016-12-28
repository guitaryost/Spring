package jp.co.kenshu.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.co.kenshu.dto.test.TestDto;
import jp.co.kenshu.service.TestService;

@RestController
public class RestfulController {

	@Autowired
	private TestService service;

    // テキストが返る※@RestControllerが付いているので、@ResponseBodyが不要
    @RequestMapping(value = "/api/text/")
    public String getTestMember() {
        return "aaaa";
    }

    // XMLを返却する例
    @RequestMapping(value = "/xml/", produces = "application/xml")
    public String xml1() {
        return "<a><b>content</b></a>";
    }

    // JSON返却する例※jackson.coreとjackson-databindがPOMに必要
    @RequestMapping("/api/json/")
    public List<TestDto> json() {
        List<TestDto> tests = service.getTestAll();
        return tests;
    }
}
