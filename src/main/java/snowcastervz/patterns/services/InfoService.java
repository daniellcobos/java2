package snowcastervz.patterns.services;

import snowcastervz.patterns.model.Info;

import java.util.List;

public interface InfoService {

    public List<Info> findAll();

    public Info findById(int theId);

    public void save(Info theInfo);

    public void deleteById(int theId);

}