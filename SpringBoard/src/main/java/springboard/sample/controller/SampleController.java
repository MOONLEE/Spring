package springboard.sample.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import springboard.common.common.CommonMap;
import springboard.sample.service.SampleService;

@Controller
public class SampleController {
	
	Logger log = Logger.getLogger(SampleController.class);
	
	@Resource(name="sampleService")
	private SampleService sampleService;
	
	@RequestMapping(value="/sample/service/openSampleBoardList.do")
	public ModelAndView openSampleList(Map<String, Object> commonMap) throws Exception {
		ModelAndView mv = new ModelAndView("/sample/BoardList");
		
		
		List<Map<String, Object>> list = sampleService.selectBoard(commonMap);
		mv.addObject("list", list);	
		
		
		if (log.isDebugEnabled()) {
			log.debug(list);
		}
		
		return mv;
	}
	
	@RequestMapping(value="/sample/writeBoard.do")
	public ModelAndView openWriteBoard(Map<String, Object> commonMap) throws Exception {
		ModelAndView mv = new ModelAndView("/sample/WriteBoard");	
		return mv;
	}
	
	
	@RequestMapping(value="/sample/saveBoard.do")
	public ModelAndView saveBoard(CommonMap commonMap) throws Exception {
		ModelAndView mv = new ModelAndView("redirect:/sample/service/openSampleBoardList.do");
		
		sampleService.insertBoard(commonMap.getMap());
			
		return mv;	
	}


	@RequestMapping(value="/sample/login.do")
	public ModelAndView accessLoginPage(CommonMap commonMap) throws Exception {
		ModelAndView mv = new ModelAndView("/sample/Login");
		
		
		return mv;
	}
	
	@RequestMapping(value="/sample/service/doLogin.do")
	public ModelAndView doLogin(CommonMap commonMap) throws Exception {
		ModelAndView mv = new ModelAndView("sample/login.do");
		Map<String, Object> modelMap = new HashMap<String, Object>();
		
		Map<String, Object> resultMap = sampleService.selectUserConfirm(commonMap.getMap());
		String successYn = (String) (resultMap == null ? "N" : resultMap.get("SUCCESS_YN"));
		
		if ("Y".equals(successYn)) {
			mv.setViewName("redirect:/sample/service/openSampleBoardList.do");
		} else {
			modelMap.put("SUCCESS_YN", "N");
		}
		
		mv.addObject("resultmap", modelMap);
		
		return mv;
	}
	
}
