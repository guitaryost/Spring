package jp.co.kenshu;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.kenshu.form.TestForm;

//SpringにこのクラスはControllerだということを教える
@Controller
public class SampleController {
	//valueに記述した文字列でControllerのURLを教える。method = .GETはクライアントがGETしたケースを表す
	@RequestMapping(value = "/show", method = RequestMethod.GET)

	public String showMessage(Model model){
		TestForm form = new TestForm();
		form.setId(0);
		form.setName("ここに名前を書いてね");
		model.addAttribute("testForm", form);
		model.addAttribute("message","FORMの練習");

//		modelインスタンスに属性を追加。第一引数に属性のkeyを、第二引数に値を指定
//		model.addAttribute("message", "hello world!!");

		//この文字列に該当するViewファイル名をフレームワークが探してあればそれを返す
		return "showMessage";
	}

	@RequestMapping(value = "/show", method = RequestMethod.POST)
	public String getFormInfo(@ModelAttribute TestForm form, Model model){
		model.addAttribute("message", "ID : " + form.getId() + " & name : " + form.getName());
		return "showMessage";
	}
}
