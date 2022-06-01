package cn.violin.auth.controller;

import cn.violin.auth.config.BaiduConf;
import cn.violin.auth.service.UserModifyService;
import cn.violin.auth.vo.UserInfoVo;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@CrossOrigin
@RequestMapping("/auth/v1")
public class OauthController {

    @Autowired
    private BaiduConf BaiduConf;

    @GetMapping("/getBaiDuCode")
    public ResponseEntity<String> getBaiDuCode() {

        return ResponseEntity.ok(String.valueOf(BaiduConf));
    }

    @GetMapping("/authorize/baidu")
    public void qrAuthorize(@RequestParam(value = "code") String code, HttpServletResponse resp) throws IOException {
        StringBuilder authorizeUrl = new StringBuilder();
        authorizeUrl.append(BaiduConf.getAccessToken())
                .append("?").append("grant_type=authorization_code")
                .append("&").append("code=" + code)
                .append("&").append("client_id=" + BaiduConf.getAppKey())
                .append("&").append("client_secret=").append(BaiduConf.getSecretKey())
                .append("&").append("redirect_uri=").append(BaiduConf.getRedirectUri());
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGetToken = new HttpGet(authorizeUrl.toString());
        CloseableHttpResponse response = httpClient.execute(httpGetToken);
        if (response.getStatusLine().getStatusCode() == 200) {

            StringBuilder redirect = new StringBuilder();
            redirect.append("http://localhost:3000/?token=");
            HttpEntity entity = response.getEntity();
            JSONObject object = JSONObject.parseObject(EntityUtils.toString(entity));
            String accessToken = object.getString("access_token");
            redirect.append(accessToken);
            System.out.println(accessToken);
            resp.sendRedirect(redirect.toString());
        }
    }

    @GetMapping("/user_info")
    public ResponseEntity<UserInfoVo> getUInfo(@RequestParam(value = "token") String token) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String uInfoUrl = "https://pan.baidu.com/rest/2.0/xpan/nas?method=uinfo&access_token=" +
                token;
        HttpGet httpGetUInfo = new HttpGet(uInfoUrl);
        CloseableHttpResponse response = httpClient.execute(httpGetUInfo);
        if (response.getStatusLine().getStatusCode() == 200) {
            HttpEntity uInfoEntity = response.getEntity();
            JSONObject uInfoObject = JSONObject.parseObject(EntityUtils.toString(uInfoEntity));
            UserInfoVo build = UserInfoVo.builder()
                    .uk(uInfoObject.getString("uk"))
                    .baiduName(uInfoObject.getString("baidu_name"))
                    .netdiskName(uInfoObject.getString("netdisk_name"))
                    .avatarUrl(uInfoObject.getString("avatar_url"))
                    .build();
            return new ResponseEntity<>(build, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
}
