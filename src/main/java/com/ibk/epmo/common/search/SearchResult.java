package com.ibk.epmo.common.search;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SearchResult {

    String title;
    String contents;
    String type;
    String updatedDate;
    float score;

    public SearchResult(String title, String contents, String type, String updatedDate,float score) {
        this.title = title;
        this.contents = contents;
        this.type = type;
        this.updatedDate = updatedDate;
        this.score = score;
    }
}
