package controller;

import dto.EthnicRequest;
import dto.EthnicResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EthnicController {

    // 민족 등록
    @PostMapping("/ethnics")
    public EthnicResponse creatEthnic(@RequestBody EthnicRequest requestDto){
        EthnicResponse ethnic = ethnicService.createEthnic(requestDto);
        return ethnic;
    }
}
