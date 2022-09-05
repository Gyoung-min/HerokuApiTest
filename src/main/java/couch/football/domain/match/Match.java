package couch.football.domain.match;

import com.fasterxml.jackson.annotation.JsonFormat;
import couch.football.domain.base.BaseTimeEntity;
import couch.football.domain.stadium.Stadium;
import couch.football.request.match.MatchCreateRequest;
import couch.football.request.match.MatchUpdateRequest;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@ToString
@NoArgsConstructor(access = PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@Table(name = "matches")
public class Match extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "match_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "stadium_id")
    private Stadium stadium;

    private Integer matchNum;

    private Integer applicantNum;

    @Enumerated(STRING)
    private MatchStatus status;

    @Enumerated(STRING)
    private MatchGender gender;

    @Lob
    private String content;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startAt;

    private Integer matchDay;

    @Builder
    public Match(Long id, Stadium stadium, MatchCreateRequest request) {
        this.id = id;
        this.stadium = stadium;
        this.matchNum = request.getMatchNum();
        this.applicantNum = 0;
        this.status = MatchStatus.OPEN;
        this.gender = MatchGender.valueOf(request.getMatchGender().toUpperCase());
        this.content = request.getContent();
        this.startAt = request.getStartAt();
        this.matchDay = startAt.getDayOfYear();
    }

    public void update(Stadium stadium, MatchUpdateRequest request) {
        this.stadium = stadium;
        this.matchNum = request.getMatchNum();
        this.gender = MatchGender.valueOf(request.getMatchGender().toUpperCase());
        this.content = request.getContent();
        this.startAt = request.getStartAt();
    }

    public void increaseApplicantNum() {
        this.applicantNum++;
    }

    public void decreaseApplicantNum() {
        this.applicantNum--;
    }

    public int getRest() {
        return this.matchNum - this.applicantNum;
    }

    public void updateStatus() {
        if (getRest() <= 0) {
            this.status = MatchStatus.CLOSE;
        } else if (getRest() > 0) {
            this.status = MatchStatus.OPEN;
        }
    }
}
