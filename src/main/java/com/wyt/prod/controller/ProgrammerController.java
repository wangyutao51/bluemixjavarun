/**
 *ProgrammerController.java
 * 
 * 2017年7月1日 下午12:23:48
 * 文件描述：
 */
package com.wyt.prod.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wyt.prod.bean.ProgrammerWords;

/**
 * 
 * @author WangYuTao
 */
@Controller
@RequestMapping("/programmer")
public class ProgrammerController
{

	 Logger log = Logger.getLogger(ProgrammerController.class);

	 @RequestMapping("/words.do")
	 @ResponseBody
	public ProgrammerWords showResult(Model model,HttpServletRequest request,HttpServletResponse response)
	{
		 String resMsg = this.buildResBdy();
		 return new ProgrammerWords(resMsg);
	}
	 
	 @RequestMapping("/init.do")
	 public String showView(Model model,HttpServletRequest request,HttpServletResponse response)
	 {
		 String resMsg = this.buildResBdy();
		 model.addAttribute("words", resMsg);
		 return "programmer/life";
	 }
	 
	 private String buildResBdy()
	 {
		 List<String> sbs = new ArrayList<String>();
			sbs.add("产品");
			sbs.add("运维");
			sbs.add("自己");
			sbs.add("测试");
			sbs.add("用户");
			
			StringBuffer sbf = new StringBuffer();

			Collections.shuffle(sbs);
			for (String sb : sbs)
			{
				boolean isSB = check(sb);
				if (sb.equals("自己"))
				{
					isSB = false;
				} else
				{

				}

				if (isSB)
				{
					 log.info(sb+" 是SB ，算了，为了SB "+sb+" 我还是修复这个Bug吧");
//					System.out.println(sb + " 是SB ，算了，为了SB " + sb + " 我还是修复这个Bug吧");
					sbf.append(sb + " 是SB ，算了，为了SB " + sb + " 我还是修复这个Bug吧").append("<br />");
					break;

				} else
				{
					 log.info(sb+" 不是SB ，继续下一个");
//					System.out.println(sb + " 不是SB ，继续下一个");
					sbf.append(sb + " 不是SB ，继续下一个").append("<br />");
				}

			}
		 return sbf.toString();
	 }

	private boolean check(String sb)
	{
		Random random = new Random();
		return random.nextBoolean();

	}


}
