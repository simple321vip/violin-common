package cn.violin.auth.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoVo {

    @JsonProperty("uk")
    private String uk;

    @JsonProperty("avatar_url")
    private String avatarUrl;

    @JsonProperty("baidu_name")
    private String baiduName;

    @JsonProperty("netdisk_name")
    private String netdiskName;
}
