package dev.shulika.xtelweb.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
@Slf4j
public class FileService {
    @Value("${token}")
    private String token;
    @Value("${file_info_uri}")
    private String fileInfoUri;
    @Value("${file_storage_uri}")
    private String fileStorageUri;

    public String getDownLoadLink(String fileId) {
        log.info("+++++ IN FileService :: getDownLoadLink :: START +++++");
        String fileInfo = fileInfoUri.replace("{token}", token).replace("{fileId}", fileId);

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> request = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(
                fileInfo,
                HttpMethod.GET,
                request,
                String.class,
                token, fileId
        );
        if (response.getStatusCode() == HttpStatus.OK) {
            System.out.println("++++++++++++++++++ Ok - " + response.getBody());
            JSONObject jsonObject = new JSONObject(response.getBody());
            var filePath = String.valueOf(jsonObject.getJSONObject("result").getString("file_path"));
            String fullUri = fileStorageUri.replace("{token}", token).replace("{filePath}", filePath);
            return fullUri;
        } else {
            log.error("----- IN FileService :: getDownLoadLink :: FAIL get filePath ----");
            return "";
        }

    }

}
