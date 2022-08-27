package test.herokut.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import test.herokut.domain.Member;
import test.herokut.dto.MemberDto;
import test.herokut.repository.MemberRepository;

@Service
@AllArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public Member createMember(MemberDto memberDto) {
        Member member = Member.builder()
                .name(memberDto.getName())
                .build();

        member = memberRepository.save(member);

        return member;

    }
}
