package test.herokut.testController;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.herokut.domain.Member;
import test.herokut.dto.MemberDto;
import test.herokut.service.MemberService;

@RestController
@AllArgsConstructor
public class TestController {

    private final MemberService memberService;

    @RequestMapping("/main")
    public String main() {
        String str = "hello";

        return str;
    }

    @PostMapping("")
    public Member createMember(@RequestBody MemberDto memberDto) {
        return memberService.createMember(memberDto);
    }

}
