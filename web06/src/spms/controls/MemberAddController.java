package spms.controls;

import java.util.Map;

import spms.dao.MemberDao;
import spms.vo.Member;

public class MemberAddController implements Controller {
  @Override
  public String execute(Map<String, Object> model) throws Exception {
    //분기문을 통해 doGet, doPost메서드를 구분한다.
	if (model.get("member") == null) { // 입력폼을 요청할 때
      return "/member/MemberForm.jsp";
      
    } else { // 회원 등록을 요청할 때
      MemberDao memberDao = (MemberDao)model.get("memberDao");
      
      Member member = (Member)model.get("member");
      memberDao.insert(member);
      
      return "redirect:list.do";
    }
  }
}