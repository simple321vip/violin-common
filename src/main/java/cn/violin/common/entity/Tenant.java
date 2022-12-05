package cn.violin.common.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "t_tenant")
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

    private String wikiName;
}
