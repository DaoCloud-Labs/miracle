package io.daocloud.miracle.controller;

import java.io.IOException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.BASE64Encoder;

@RestController
public class MainController {

  @GetMapping(value = "/index", produces = MediaType.IMAGE_JPEG_VALUE)
  @ResponseBody
  public String indexA() throws IOException {
    Resource cpr = new ClassPathResource("static/indexA.jpg");
    //for test
    BASE64Encoder encoder = new BASE64Encoder();
    return encoder.encode(FileCopyUtils.copyToByteArray(cpr.getInputStream()));
  }
//
//  @GetMapping(value = "/indexB", produces = MediaType.IMAGE_JPEG_VALUE)
//  @ResponseBody
//  public byte[] indexB() throws IOException {
//    Resource cpr = new ClassPathResource("static/indexB.jpg");
//    //for test
//    return FileCopyUtils.copyToByteArray(cpr.getInputStream());
//  }
}
