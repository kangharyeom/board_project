package company.board_project.domain.apply.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LeagueApplyPostDto {
    private long userId;
    private long teamId;
    private long leagueId;
    private long hostLeagueId;
    private String applierName;
    private String teamName;
    private String levelType;
    private String ageType;
    private String applyType;
}
