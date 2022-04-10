package by.bsuir.constant.ref;

import by.bsuir.entity.domain.Rating;
import by.bsuir.entity.domain.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
public enum RatingRef {

    ONE_STAR(1, 1),
    TWO_STAR(2, 2),
    THREE_STAR(3, 3),
    FOUR_STAR(4, 4),
    FIVE_STAR(5, 5);


    private Integer id;
    private Integer ratingNumber;

    public static List<Rating> getAll(){
        return Arrays.stream(RatingRef.values())
                .map(ratingRef -> Rating.builder()
                        .ratingId(ratingRef.getId())
                        .ratingNumber(ratingRef.getRatingNumber())
                        .build()).collect(Collectors.toList());
    }
}
