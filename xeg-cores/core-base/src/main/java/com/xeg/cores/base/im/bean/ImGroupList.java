package com.xeg.cores.base.im.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.xeg.cores.base.im.ImResponse;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * @description:
 * @author: Zhongkun Zhang
 * @create: 2021/8/5 19:40
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class ImGroupList extends ImResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "群ID列表")
    @JsonProperty("GroupIdList")
    private List<GroupId> groupIdList;

    @ApiModelProperty(value = "App 当前的群组总数")
    @JsonProperty("TotalCount")
    private Integer totalCount;

    @ApiModelProperty(value = "分页拉取的标志")
    @JsonProperty("Next")
    private Integer next;

    /**
     * 群ID
     */
    @Data
    public static class GroupId implements Serializable {
        private static final long serialVersionUID = 1L;

        @ApiModelProperty(value = "群ID")
        @JsonProperty("GroupId")
        private String groupId;
    }
}
