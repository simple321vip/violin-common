package cn.violin.common.vo;


import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponsePageVo {

    private int page;
    private int total;
    private int pagePer;



}
