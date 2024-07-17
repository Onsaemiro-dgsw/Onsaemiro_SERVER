package service;

import dto.EthnicRequest;
import dto.EthnicResponse;
import entity.Ethnic;
import repository.EthnicRepository;

public class EthnicService {

    private final EthnicRepository ethnicRepository;

    public EthnicResponse createEthnic(EthnicRequest request){
        Ethnic ethnic = new Ethnic(request);
        ethnicRepository.save(ethnic);
        return new EthnicResponse(ethnic);
    }
}
