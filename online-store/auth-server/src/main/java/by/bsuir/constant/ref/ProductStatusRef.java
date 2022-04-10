package by.bsuir.constant.ref;

import by.bsuir.entity.domain.ProductStatus;
import by.bsuir.entity.domain.Rating;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
public enum ProductStatusRef {

    WAITING_FOR_APPROVE(1, "WAITING_FOR_APPROVE"),
    APPROVED(2, "APPROVED"),
    NON_APPROVED(3, "NON_APPROVED"),
    DELETED(4, "DELETED");

    private Integer id;
    private String name;

    public static List<ProductStatus> getAll(){
        return Arrays.stream(ProductStatusRef.values())
                .map(productStatusRef -> ProductStatus.builder()
                        .productStatusId(productStatusRef.getId())
                        .productStatusName(productStatusRef.getName())
                        .build()).collect(Collectors.toList());
    }
}
