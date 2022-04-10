package by.bsuir.constant.ref;

import by.bsuir.entity.domain.MessageStatus;
import by.bsuir.entity.domain.ProductLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
public enum MessageStatusRef {

    NON_READ(1, "NON_READ"),
    READ(2, "READ");

    private Integer id;
    private String name;

    public static List<MessageStatus> getAll(){
        return Arrays.stream(MessageStatusRef.values())
                .map(messageStatusRef -> MessageStatus.builder()
                        .messageStatusId(messageStatusRef.getId())
                        .messageStatusName(messageStatusRef.getName())
                        .build()).collect(Collectors.toList());
    }
}
