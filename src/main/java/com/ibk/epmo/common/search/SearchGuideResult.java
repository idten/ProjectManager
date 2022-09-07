package com.ibk.epmo.common.search;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SearchGuideResult {

    private Integer guideId;
    private String title;
    private String step;
    private String guideContents;
    private String guideType;
    private String updatedDate;
    private float score;
}
