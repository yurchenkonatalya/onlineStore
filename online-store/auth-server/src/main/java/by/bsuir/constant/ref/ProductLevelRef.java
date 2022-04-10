package by.bsuir.constant.ref;

import by.bsuir.entity.domain.ProductLevel;
import by.bsuir.entity.domain.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
public enum ProductLevelRef {

    LOW_PRIORITY(1, "LOW_PRIORITY"),
    HIGH_PRIORITY(2, "HIGH_PRIORITY");

    private Integer id;
    private String name;

    public static List<ProductLevel> getAll(){
        return Arrays.stream(ProductLevelRef.values())
                .map(productLevelRef -> ProductLevel.builder()
                        .productLevelId(productLevelRef.getId())
                        .productLevelName(productLevelRef.getName())
                        .build()).collect(Collectors.toList());
    }
}
