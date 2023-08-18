package company.board_project.content.mapper;

import company.board_project.comment.dto.CommentResponseDto;
import company.board_project.comment.entity.Comment;
import company.board_project.comment.repository.CommentRepository;
import company.board_project.content.dto.*;
import company.board_project.content.entity.Content;
import company.board_project.content.entity.ContentFile;
import company.board_project.content.repository.ContentFileRepository;
import company.board_project.user.entity.User;
import org.mapstruct.Mapper;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
@Mapper(componentModel = "spring")
public interface ContentMapper {

    default Content contentPostDtoToContent(ContentPostDto requestBody){
        User user = new User();

        user.setUserId(requestBody.getUserId());
        user.setName(requestBody.getName());

        Content content = new Content();
        content.setUser(user);
        content.setTitle( requestBody.getTitle() );
        content.setContent( requestBody.getContent() );

        return content;
    }
    default Content contentPatchDtoToContent(ContentPatchDto requestBody) {
        Content content = new Content();

        content.setContentId( requestBody.getContentId() );
        content.setTitle( requestBody.getTitle() );
        content.setContent( requestBody.getContent() );

        return content;
    }

    default ContentResponseDto contentToContentResponse(Content content, ContentFileRepository contentFileRepository){
        User user = content.getUser();
        List<ContentFile> contentFile = contentFileRepository.findByContentId(content.getContentId());

        return ContentResponseDto.builder()
                .contentId(content.getContentId())
                .userId(user.getUserId())
                .name(user.getName())
                .title(content.getTitle())
                .content(content.getContent())
                .contentFileList(contentFile)
                .createdAt(content.getCreatedAt())
                .modifiedAt(content.getModifiedAt())
                .build();
    }

    // 컨텐츠 to 컨텐트 단건 조회 //
    default ContentAllResponseDto contentToContentAllResponse(Content content, ContentFileRepository contentFileRepository,CommentRepository commentRepository){
        User user = content.getUser();
        List<Comment> comments = commentRepository.findAllByContentId(content.getContentId());
        Collections.reverse(comments);

        return ContentAllResponseDto.builder()
                .contentId(content.getContentId())
                .userId(user.getUserId())
                .name(user.getName())
                .title(content.getTitle())
                .content(content.getContent())
                .contentFileList(contentFileRepository.findByContentId(content.getContentId()))
                .comments(commentsToCommentResponseDtos(comments))
                .createdAt(content.getCreatedAt())
                .modifiedAt(content.getModifiedAt())
                .build();
    }

    // 컨텐츠 List 선언
    default ContentListDto contentListDtoToContentResponse(List<Content> contents, ContentFileRepository contentFileRepository){

        return ContentListDto.builder()
                .contentResponseDto(contentsToContentsResponse(contents, contentFileRepository))
                .build();
    }

    // 컨텐츠(다중) to 컨텐츠 리스폰스 (전체) //
    default List<ContentResponseDto> contentsToContentsResponse(List<Content> contents, ContentFileRepository contentFileRepository){
        return contents.stream()
                .map(content -> ContentResponseDto.builder()
                        .contentId(content.getContentId())
                        .userId(content.getUser().getUserId())
                        .name(content.getUser().getName())
                        .title(content.getTitle())
                        .content(content.getContent())
                        .contentFileList(contentFileRepository.findByContentId(content.getContentId()))
                        .createdAt(content.getCreatedAt())
                        .modifiedAt(content.getModifiedAt())
                        .build())
                .collect(Collectors.toList());
    }

    // 커멘츠 to 커멘트 리스폰스 (전체) //
    default List<CommentResponseDto> commentsToCommentResponseDtos(List<Comment> comments){
        return comments.stream()
                .map(comment -> CommentResponseDto.builder()
                        .commentId(comment.getCommentId())
                        .contentId(comment.getContent().getContentId())
                        .userId(comment.getUser().getUserId())
                        .name(comment.getUser().getName())
                        .comment(comment.getComment())
                        .createdAt(comment.getCreatedAt())
                        .modifiedAt(comment.getModifiedAt())
                        .title(comment.getContent().getTitle())
                        .name(comment.getUser().getName())
                        .build())
                .collect(Collectors.toList());
    }

    // 컨텐츠 to 최신 오래된 순서 리스폰스 //
    default List<ContentNewestAndLatestResponseDto> contentsToContentNewestAndLatestResponseDto(List<Content> contents, ContentFileRepository contentFileRepository){
        return contents.stream()
                .map(content -> ContentNewestAndLatestResponseDto.builder()
                        .contentId(content.getContentId())
                        .title(content.getTitle())
                        .content(content.getContent())
                        .contentFileList(contentFileRepository.findByContentId(content.getContentId()))
                        .build())
                .collect(Collectors.toList());
    }
}
