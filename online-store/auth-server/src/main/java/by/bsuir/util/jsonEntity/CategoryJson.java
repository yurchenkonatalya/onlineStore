package by.bsuir.util.jsonEntity;


import by.bsuir.entity.domain.Category;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class CategoryJson {

    @JsonProperty("categories")
    private List<Category> categories;
}
