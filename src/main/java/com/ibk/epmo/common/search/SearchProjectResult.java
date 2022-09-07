package com.ibk.epmo.common.search;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SearchProjectResult {

    private Integer projectId;
    private String projectName;
    private String contents;
    private String type;
    private String updatedDate;
    private float score;
}
