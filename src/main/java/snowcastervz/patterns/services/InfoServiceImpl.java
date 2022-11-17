package snowcastervz.patterns.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import snowcastervz.patterns.dao.InfoRepository;
import snowcastervz.patterns.model.Info;


@Service
public class InfoServiceImpl implements InfoService {

    private InfoRepository infoRepository;

    @Autowired
    public InfoServiceImpl(InfoRepository theInfoRepository) {
        infoRepository = theInfoRepository;
    }

    @Override
    public List<Info> findAll() {
        return infoRepository.findAll();
    }

    @Override
    public Info findById(int theId) {
        Optional<Info> result = infoRepository.findById(theId);

        Info theInfo = null;

        if (result.isPresent()) {
            theInfo = result.get();
        }
        else {
            // we didn't find the info
            throw new RuntimeException("Did not find info id - " + theId);
        }

        return theInfo;
    }

    @Override
    public void save(Info theInfo) {
        infoRepository.save(theInfo);
    }

    @Override
    public void deleteById(int theId) {
        infoRepository.deleteById(theId);
    }

}


