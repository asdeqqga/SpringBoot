package kr.co.farmstory.controller;

import kr.co.farmstory.service.UserService;
import kr.co.farmstory.vo.TermsVO;
import kr.co.farmstory.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("user/login")
    public String login() {
        return "user/login";
    }

    @GetMapping("user/register")
    public String register() {
        return "user/register";
    }

    /**
     * 회원 가입 기능
     * @since 2023/01/26 // 라성준 // ver1
     * @param vo
     * @param req
     * @return
     */
    @PostMapping("user/register")
    public String register(UserVO vo, HttpServletRequest req) {
        vo.setRegip(req.getRemoteAddr());
        int result = service.insertUser(vo);
        return "redirect:/user/login?success="+result;
    }

    @GetMapping("user/terms")
    public String terms(Model model) {
        TermsVO vo = service.selectTerms();
        model.addAttribute(vo);
        return "user/terms";
    }
    /**
     * 회원가입 아이디 중복 체크 기능
     * @param uid // 확인하는 아이디
     * @return Map<String, Integer> // 중복되는 아이디 갯수
     * @since 2023/01/26 // 라성준 // ver1
     */
    @ResponseBody
    @GetMapping("user/checkUid")
    public Map<String, Integer> checkUid(@RequestParam("uid") String uid) {
        log.info("uid : " + uid);
        int result = service.countByUid(uid);

        Map<String, Integer> resultMap = new HashMap<>();
        resultMap.put("result", result);

        return resultMap;
    }

    /**
     * 회원가입 별명 중복 체크 기능
     * @param nick // 확인하는 아이디
     * @return Map<String, Integer>
     * @since 2023/01/27 // 라성준 // ver1
     */
    @GetMapping("user/checkNick")
    public Map<String, Integer> checkNick(String nick) {
        int result = service.countByNick(nick);

        Map<String, Integer> resultMap = new HashMap<>();
        resultMap.put("result", result);

        return resultMap;
    }

    /**
     * 회원가입 이메일 중복 체크 및 인증
     * since 2023/01/27 // 라성준 // ver1
     * @param email
     * @return
     */
    @ResponseBody
    @GetMapping("user/checkEmail")
    public Map<String, Integer> checkEmail(String email) {
        // 이메일 중복 검사
        int status = service.countByEmail(email);

        Map<String, Integer> resultMap = new HashMap<>();
        resultMap.put("status", status);

        return resultMap;
    }

    /**
     * 회원가입 휴대폰 번호 중복 체크
     * @since 2023/01/27 // 라성준 // ver1
     * @param hp
     * @return
     */
    public Map<String, Integer> checkHp(String hp) {
        int result = service.countByHp(hp);

        Map<String, Integer> resultMap = new HashMap<>();
        resultMap.put("result", result);

        return resultMap;
    }

}
