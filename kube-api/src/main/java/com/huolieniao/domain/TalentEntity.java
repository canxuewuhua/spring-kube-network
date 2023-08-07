package com.huolieniao.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "my_talent")
public class TalentEntity implements Serializable {

    private static final long serialVersionUID = 5423139728509906609L;
    private Long id;
    private String name;
    private String addr;
}
