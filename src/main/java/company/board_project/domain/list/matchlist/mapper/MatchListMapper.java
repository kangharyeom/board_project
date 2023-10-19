package company.board_project.domain.list.matchlist.mapper;

import company.board_project.domain.apply.entity.Apply;
import company.board_project.domain.list.matchlist.dto.*;
import company.board_project.domain.list.matchlist.entity.MatchList;
import company.board_project.global.constant.AgeType;
import company.board_project.global.constant.LevelType;
import company.board_project.global.constant.MatchStatus;
import company.board_project.global.constant.UniformType;
import company.board_project.domain.match.normalmatch.dto.MatchEndDto;
import company.board_project.domain.match.normalmatch.dto.MatchEndResponseDto;
import company.board_project.domain.match.normalmatch.entity.Match;
import company.board_project.domain.team.entity.Team;
import company.board_project.domain.user.entity.User;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface MatchListMapper {
    default MatchList matchListPostDtoToMatchList(MatchListPostDto requestBody) {
        User user = new User();
        user.setPosition(user.getPosition());

        user.setUserId(requestBody.getHomeTeamUserId());

        Apply apply = new Apply();
        apply.setApplyId(requestBody.getApplyId());

        Team team = new Team();
        team.setTeamId(requestBody.getHomeTeamId());
        team.setHonorScore(requestBody.getAwayTeamHonorScore());
        team.setTeamName(requestBody.getAwayTeamName());
        team.setManagerName(requestBody.getAwayTeamManagerName());
        team.setTotalWinRecord(requestBody.getAwayTeamTotalWinRecord());
        team.setTotalDrawRecord(requestBody.getAwayTeamTotalDrawRecord());
        team.setTotalLoseRecord(requestBody.getAwayTeamTotalLoseRecord());
        team.setLevelType(LevelType.valueOf(requestBody.getAwayTeamLevelType()));
        team.setAgeType(AgeType.valueOf(requestBody.getAwayTeamAgeType()));
        team.setUniformType(UniformType.valueOf(requestBody.getAwayTeamUniformType()));

        Match match = new Match();
        match.setMatchId(requestBody.getMatchId());
        match.setHomeTeamHonorScore(requestBody.getHomeTeamHonorScore());
        match.setHomeTeamName(requestBody.getHomeTeamName());
        match.setHomeTeamManagerName(requestBody.getHomeTeamManagerName());
        match.setHomeTeamTotalWinRecord(requestBody.getHomeTeamTotalWinRecord());
        match.setHomeTeamTotalDrawRecord(requestBody.getHomeTeamTotalDrawRecord());
        match.setHomeTeamTotalLoseRecord(requestBody.getHomeTeamTotalLoseRecord());
        match.setHomeTeamLevelType(LevelType.valueOf(requestBody.getHomeTeamLevelType()));
        match.setHomeTeamAgeType(AgeType.valueOf(requestBody.getHomeTeamAgeType()));
        match.setHomeTeamUniformType(UniformType.valueOf(requestBody.getHomeTeamUniformType()));

        MatchList matchList = new MatchList();
        matchList.setUser(user);
        matchList.setApply(apply);
        matchList.setTeam(team);
        matchList.setMatch(match);
        matchList.setHomeTeamId(requestBody.getHomeTeamId());
        matchList.setAwayTeamName(requestBody.getAwayTeamName());
        matchList.setHomeTeamScore(requestBody.getHomeTeamScore());
        matchList.setHomeTeamScore(requestBody.getHomeTeamScore());
        matchList.setHomeTeamHonorScore(requestBody.getHomeTeamHonorScore());
        matchList.setHomeTeamName(requestBody.getHomeTeamName());
        matchList.setHomeTeamManagerName(requestBody.getHomeTeamManagerName());
        matchList.setHomeTeamTotalWinRecord(requestBody.getHomeTeamTotalWinRecord());
        matchList.setHomeTeamTotalDrawRecord(requestBody.getHomeTeamTotalDrawRecord());
        matchList.setHomeTeamTotalLoseRecord(requestBody.getHomeTeamTotalLoseRecord());
        matchList.setHomeTeamLevelType(LevelType.valueOf(requestBody.getHomeTeamLevelType()));
        matchList.setHomeTeamAgeType(AgeType.valueOf(requestBody.getHomeTeamAgeType()));
        matchList.setHomeTeamUniformType(UniformType.valueOf(requestBody.getHomeTeamUniformType()));
        matchList.setAwayTeamHonorScore(requestBody.getAwayTeamHonorScore());
        matchList.setAwayTeamName(requestBody.getAwayTeamName());
        matchList.setAwayTeamScore(requestBody.getAwayTeamScore());
        matchList.setAwayTeamManagerName(requestBody.getAwayTeamManagerName());
        matchList.setAwayTeamTotalWinRecord(requestBody.getAwayTeamTotalWinRecord());
        matchList.setAwayTeamTotalDrawRecord(requestBody.getAwayTeamTotalDrawRecord());
        matchList.setAwayTeamTotalLoseRecord(requestBody.getAwayTeamTotalLoseRecord());
        matchList.setAwayTeamLevelType(LevelType.valueOf(requestBody.getAwayTeamLevelType()));
        matchList.setAwayTeamAgeType(AgeType.valueOf(requestBody.getAwayTeamAgeType()));
        matchList.setAwayTeamUniformType(UniformType.valueOf(requestBody.getAwayTeamUniformType()));
        matchList.setMatchTime(requestBody.getMatchTime());
        matchList.setMatchDate(requestBody.getMatchDate());

        return matchList;
    }

    default MatchList matchListPatchDtoToMatchList (MatchListPatchDto requestBody) {
        Apply apply = new Apply();
        apply.setApplyId(apply.getApplyId());

        MatchList matchList = new MatchList();
        matchList.setApply(apply);
        matchList.setHomeTeamScore(requestBody.getHomeTeamScore());
        matchList.setHomeTeamHonorScore(requestBody.getHomeTeamHonorScore());
        matchList.setHomeTeamName(requestBody.getHomeTeamName());
        matchList.setHomeTeamManagerName(requestBody.getHomeTeamManagerName());
        matchList.setHomeTeamTotalWinRecord(requestBody.getHomeTeamTotalWinRecord());
        matchList.setHomeTeamTotalDrawRecord(requestBody.getHomeTeamTotalDrawRecord());
        matchList.setHomeTeamTotalLoseRecord(requestBody.getHomeTeamTotalLoseRecord());
        matchList.setHomeTeamLevelType(LevelType.valueOf(requestBody.getHomeTeamLevelType()));
        matchList.setHomeTeamAgeType(AgeType.valueOf(requestBody.getHomeTeamAgeType()));
        matchList.setHomeTeamUniformType(UniformType.valueOf(requestBody.getHomeTeamUniformType()));
        matchList.setAwayTeamHonorScore(requestBody.getAwayTeamHonorScore());
        matchList.setAwayTeamName(requestBody.getAwayTeamName());
        matchList.setAwayTeamManagerName(requestBody.getAwayTeamManagerName());
        matchList.setAwayTeamTotalWinRecord(requestBody.getAwayTeamTotalWinRecord());
        matchList.setAwayTeamTotalDrawRecord(requestBody.getAwayTeamTotalDrawRecord());
        matchList.setAwayTeamTotalLoseRecord(requestBody.getAwayTeamTotalLoseRecord());
        matchList.setAwayTeamLevelType(LevelType.valueOf(requestBody.getAwayTeamLevelType()));
        matchList.setAwayTeamAgeType(AgeType.valueOf(requestBody.getAwayTeamAgeType()));
        matchList.setAwayTeamUniformType(UniformType.valueOf(requestBody.getAwayTeamUniformType()));
        matchList.setMatchTime(requestBody.getMatchTime());
        matchList.setMatchDate(requestBody.getMatchDate());

        return matchList;
    }

    default MatchList applyToMatchList (MatchAwayTeamDto requestBody) {
        MatchList matchList = new MatchList();
        matchList.setAwayTeamId(requestBody.getAwayTeamId());
        matchList.setAwayTeamUserId(requestBody.getAwayTeamUserId());
        matchList.setAwayTeamName(requestBody.getAwayTeamName());
        matchList.setAwayTeamHonorScore(requestBody.getAwayTeamHonorScore());
        matchList.setAwayTeamManagerName(requestBody.getAwayTeamManagerName());
        matchList.setAwayTeamTotalWinRecord(requestBody.getAwayTeamTotalWinRecord());
        matchList.setAwayTeamTotalDrawRecord(requestBody.getAwayTeamTotalDrawRecord());
        matchList.setAwayTeamTotalLoseRecord(requestBody.getAwayTeamTotalLoseRecord());
        matchList.setAwayTeamLevelType(LevelType.valueOf(requestBody.getAwayTeamLevelType()));
        matchList.setAwayTeamAgeType(AgeType.valueOf(requestBody.getAwayTeamAgeType()));
        matchList.setAwayTeamUniformType(UniformType.valueOf(requestBody.getAwayTeamUniformType()));

        return matchList;
    }

    default MatchList matchEndDtoToMatch(MatchEndDto requestBody) {
        MatchList matchList = new MatchList();

        matchList.setHomeTeamScore(requestBody.getHomeTeamScore());
        matchList.setAwayTeamScore(requestBody.getAwayTeamScore());
        matchList.setMatchStatus(MatchStatus.valueOf(requestBody.getMatchStatus()));

        return matchList;
    }

    default MatchEndResponseDto matchToMatchEndResponse(MatchList matchList){
        Match match = matchList.getMatch();
        User user = matchList.getUser();
        Team team = matchList.getTeam();

        return MatchEndResponseDto.builder()
                .matchListId(matchList.getMatchListId())
                .matchId(match.getMatchId())
                .homeTeamUserId(user.getUserId())
                .awayTeamUserId(matchList.getAwayTeamUserId())
                .homeTeamId(team.getTeamId())
                .awayTeamId(matchList.getAwayTeamId())
                .homeTeamScore(matchList.getHomeTeamScore())
                .awayTeamScore(matchList.getAwayTeamScore())
                .matchStatus(String.valueOf(matchList.getMatchStatus()))
                .matchTime(matchList.getMatchTime())
                .matchDate(matchList.getMatchDate())
                .createdAt(matchList.getCreatedAt())
                .modifiedAt(matchList.getModifiedAt())
                .build();
    }

    default MatchListResponseDto matchListToMatchListResponse(MatchList matchList){

        User user = matchList.getUser();

        Team team = matchList.getTeam();

        Apply apply = matchList.getApply();

        Match match = matchList.getMatch();

        return MatchListResponseDto.builder()
                .homeTeamUserId(user.getUserId())
                .homeTeamId(team.getTeamId())
                .matchId(match.getMatchId())
                .applyId(apply.getApplyId())
                .matchListId(matchList.getMatchListId())
                .homeTeamScore(matchList.getHomeTeamScore())
                .homeTeamHonorScore(matchList.getHomeTeamHonorScore())
                .homeTeamName(matchList.getHomeTeamName())
                .homeTeamManagerName(matchList.getHomeTeamManagerName())
                .homeTeamTotalWinRecord(matchList.getHomeTeamTotalWinRecord())
                .homeTeamTotalDrawRecord(matchList.getHomeTeamTotalDrawRecord())
                .homeTeamTotalLoseRecord(matchList.getHomeTeamTotalLoseRecord())
                .homeTeamLevelType(String.valueOf(matchList.getHomeTeamLevelType()))
                .homeTeamAgeType(String.valueOf(matchList.getHomeTeamAgeType()))
                .homeTeamUniformType(String.valueOf(matchList.getHomeTeamUniformType()))

                .awayTeamScore(matchList.getAwayTeamScore())
                .awayTeamHonorScore(matchList.getAwayTeamHonorScore())
                .awayTeamName(matchList.getAwayTeamName())
                .awayTeamManagerName(matchList.getAwayTeamManagerName())
                .awayTeamTotalWinRecord(matchList.getAwayTeamTotalWinRecord())
                .awayTeamTotalDrawRecord(matchList.getAwayTeamTotalDrawRecord())
                .awayTeamTotalLoseRecord(matchList.getAwayTeamTotalLoseRecord())
                .awayTeamLevelType(String.valueOf(matchList.getAwayTeamLevelType()))
                .awayTeamAgeType(String.valueOf(matchList.getAwayTeamAgeType()))
                .awayTeamUniformType(String.valueOf(matchList.getAwayTeamUniformType()))
                .matchTime(matchList.getMatchTime())
                .matchDate(matchList.getMatchDate())
                .createdAt(matchList.getCreatedAt())
                .modifiedAt(matchList.getModifiedAt())
                .build();
    }

    default MatchListResponseDto applyToMatchListResponse(MatchList matchList, Long applyId){
        Match match = matchList.getMatch();
        User user = matchList.getUser();
        Team team = matchList.getTeam();

        return MatchListResponseDto.builder()
                .homeTeamUserId(user.getUserId())
                .awayTeamUserId(matchList.getAwayTeamUserId())
                .awayTeamId(matchList.getAwayTeamId())
                .matchId(match.getMatchId())
                .homeTeamId(team.getTeamId())
                .applyId(applyId)
                .matchListId(matchList.getMatchListId())
                .homeTeamScore(matchList.getHomeTeamScore())
                .homeTeamHonorScore(matchList.getHomeTeamHonorScore())
                .homeTeamName(matchList.getHomeTeamName())
                .homeTeamManagerName(matchList.getHomeTeamManagerName())
                .homeTeamTotalWinRecord(matchList.getHomeTeamTotalWinRecord())
                .homeTeamTotalDrawRecord(matchList.getHomeTeamTotalDrawRecord())
                .homeTeamTotalLoseRecord(matchList.getHomeTeamTotalLoseRecord())
                .homeTeamLevelType(String.valueOf(matchList.getHomeTeamLevelType()))
                .homeTeamAgeType(String.valueOf(matchList.getHomeTeamAgeType()))
                .homeTeamUniformType(String.valueOf(matchList.getHomeTeamUniformType()))

                .awayTeamScore(matchList.getAwayTeamScore())
                .awayTeamHonorScore(matchList.getAwayTeamHonorScore())
                .awayTeamName(matchList.getAwayTeamName())
                .awayTeamManagerName(matchList.getAwayTeamManagerName())
                .awayTeamTotalWinRecord(matchList.getAwayTeamTotalWinRecord())
                .awayTeamTotalDrawRecord(matchList.getAwayTeamTotalDrawRecord())
                .awayTeamTotalLoseRecord(matchList.getAwayTeamTotalLoseRecord())
                .awayTeamLevelType(String.valueOf(matchList.getAwayTeamLevelType()))
                .awayTeamAgeType(String.valueOf(matchList.getAwayTeamAgeType()))
                .awayTeamUniformType(String.valueOf(matchList.getAwayTeamUniformType()))
                .matchTime(matchList.getMatchTime())
                .matchDate(matchList.getMatchDate())
                .createdAt(matchList.getCreatedAt())
                .modifiedAt(matchList.getModifiedAt())
                .build();
    }

    default MatchListResponseListDto matchListDtoToMatchListResponse(List<MatchList> matchLists){

        return MatchListResponseListDto.builder()
                .matchListResponseDtoList(matchListsToMatchListResponse(matchLists))
                .build();
    }

    default List<MatchListResponseDto> matchListsToMatchListResponse(List<MatchList> matchLists){
        return matchLists.stream()
                .map(matchList -> MatchListResponseDto.builder()
                        .matchListId(matchList.getMatchListId())
                        .homeTeamScore(matchList.getHomeTeamScore())
                        .homeTeamHonorScore(matchList.getHomeTeamHonorScore())
                        .homeTeamName(matchList.getHomeTeamName())
                        .homeTeamManagerName(matchList.getHomeTeamManagerName())
                        .homeTeamTotalWinRecord(matchList.getHomeTeamTotalWinRecord())
                        .homeTeamTotalDrawRecord(matchList.getHomeTeamTotalDrawRecord())
                        .homeTeamTotalLoseRecord(matchList.getHomeTeamTotalLoseRecord())
                        .homeTeamLevelType(String.valueOf(matchList.getHomeTeamLevelType()))
                        .homeTeamAgeType(String.valueOf(matchList.getHomeTeamAgeType()))
                        .homeTeamUniformType(String.valueOf(matchList.getHomeTeamUniformType()))

                        .awayTeamScore(matchList.getAwayTeamScore())
                        .awayTeamHonorScore(matchList.getAwayTeamHonorScore())
                        .awayTeamName(matchList.getAwayTeamName())
                        .awayTeamManagerName(matchList.getAwayTeamManagerName())
                        .awayTeamTotalWinRecord(matchList.getAwayTeamTotalWinRecord())
                        .awayTeamTotalDrawRecord(matchList.getAwayTeamTotalDrawRecord())
                        .awayTeamTotalLoseRecord(matchList.getAwayTeamTotalLoseRecord())
                        .awayTeamLevelType(String.valueOf(matchList.getAwayTeamLevelType()))
                        .awayTeamAgeType(String.valueOf(matchList.getAwayTeamAgeType()))
                        .awayTeamUniformType(String.valueOf(matchList.getAwayTeamUniformType()))
                        .matchTime(matchList.getMatchTime())
                        .matchDate(matchList.getMatchDate())
                        .createdAt(matchList.getCreatedAt())
                        .modifiedAt(matchList.getModifiedAt())
                        .createdAt(matchList.getCreatedAt())
                        .modifiedAt(matchList.getModifiedAt())
                        .build())
                .collect(Collectors.toList());
    }
}