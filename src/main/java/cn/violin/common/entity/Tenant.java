package cn.violin.common.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tenant {

    private String tenantId;

    private String account;

    private String tel;

    private int authority;

    private String avatarUrl;

    private String storageAccount;

    private int pageNo;

    private int pageSize;
}
